package com.pet.home.service.impl;

import com.pet.common.entity.PetComment;
import com.pet.common.entity.PetQuestion;
import com.pet.common.entity.PetReply;
import com.pet.common.model.IdWorker;
import com.pet.common.model.PetCommentModel;
import com.pet.common.model.PetReplyModel;
import com.pet.common.model.ResultInfo;
import com.pet.common.utils.EntityToModel;
import com.pet.common.utils.PetUtil;
import com.pet.home.mapper.PetReplyMapper;
import com.pet.home.service.IPetReplyLikeService;
import com.pet.home.service.IPetReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Slf4j
@Service
public class PetReplyServiceImpl extends ServiceImpl<PetReplyMapper, PetReply> implements IPetReplyService {

    @Autowired
    private PetReplyMapper petReplyMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private IPetReplyLikeService petReplyLikeService;

    private String replyKey = "replyKey";
    private String pet_question = "pet_question";
    private String commentKey = "commentKey";
    private String replyLike = "replyLikeKey";


    @Override
    public ResultInfo getReply(String userId,String qtId,Integer pageStart,Integer pageEnd) {
        if (StringUtils.isBlank(qtId)){
            return ResultInfo.failure(500,"qtId为空");
        }
        List<Object> range = redisTemplate.opsForList().range(qtId+replyKey, pageStart, pageEnd);

        List<PetReplyModel> list = new ArrayList<>();
        for (int i = 0; i < range.size(); i++) {
            PetReplyModel petReplyModel = new PetReplyModel();
            PetReply petReply = (PetReply) range.get(i);
            Long commentCount = redisTemplate.opsForList().size(petReply.getRpId() + commentKey);
            Long replyLikeCount = redisTemplate.opsForList().size(petReply.getRpId() + replyLike);
            petReply.setCommentCount(commentCount.intValue());
            petReply.setLikeCount(replyLikeCount.intValue());
            //判断当前用户有没有点赞
            petReply.setLkStatus(petReplyLikeService.getRLByRpIdAndUserId(petReply.getRpId(),userId));
            EntityToModel.petReplyToPetReplyModel(petReply,petReplyModel);
            redisTemplate.opsForList().set(qtId + replyKey,i,petReply);
            List<PetCommentModel> petCommentModels = new ArrayList<>();
            List<Object> rangeCo = redisTemplate.opsForList().range(petReply.getRpId()+commentKey, 0, 3);
            assert rangeCo != null;
            for (Object o : rangeCo) {
                PetComment petComment = (PetComment) o;
                petCommentModels.add(EntityToModel.petCommentToPetCommentModel(petComment, null));
            }
            petReplyModel.setCommentList(petCommentModels);
            list.add(petReplyModel);
        }
        return ResultInfo.success(200,"查询成功",list);
    }

    @Override
    public ResultInfo addReply(PetReply petReply) {
        if (StringUtils.isBlank(petReply.getQtId())){
            return ResultInfo.failure(500,"qtId为空");
        }
        IdWorker idWorker = new IdWorker(1,1,1);
        String id = String.valueOf(idWorker.nextId());
        petReply.setRpId(id);
        petReply.setCreateTime(System.currentTimeMillis());
        petReply.setUpTime(System.currentTimeMillis());
        petReply.setLikeCount(0);
        petReply.setCommentCount(0);
        petReply.setRpStatus(true);
        petReply.setLkStatus(false);
        redisTemplate.opsForList().leftPush( petReply.getQtId()+replyKey,petReply);
//        List<Object> range = redisTemplate.opsForList().range(pet_question, 0, -1);
//        for (int i = 0; i < range.size(); i++) {
//            PetQuestion petQuestion = new PetQuestion();
//            if (petReply.getQtId().equals(petQuestion.getQtId())){
//
//            }
//        }
        return ResultInfo.success(200,"回答成功",petReply);
    }

    @Override
    public void transReplyFromRedis2DB(String qtId) {
        List<Object> range = redisTemplate.opsForList().range(qtId+replyKey, 0, -1);
        List<PetReply> replies = new ArrayList<>();
        for (Object o:range
             ) {
            replies.add((PetReply)o);
        }
        if (replies.size()>0) {
            petReplyMapper.transReplyFromRedis2DB(replies);
        }else {
            log.info("LikeTask-------- {}", LocalDateTime.now());
        }

    }

    @Override
    public boolean delReplyByQtId(String qtId) {
//        petReplyMapper.up
        return false;
    }
}