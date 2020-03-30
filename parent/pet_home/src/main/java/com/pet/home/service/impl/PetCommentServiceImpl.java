package com.pet.home.service.impl;

import com.pet.common.entity.PetComment;
import com.pet.common.entity.PetReply;
import com.pet.common.model.IdWorker;
import com.pet.common.model.ResultInfo;
import com.pet.home.mapper.PetCommentMapper;
import com.pet.home.service.IPetCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Service
public class PetCommentServiceImpl extends ServiceImpl<PetCommentMapper, PetComment> implements IPetCommentService {

    @Autowired
    private PetCommentMapper petCommentMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private String commentKey = "commentKey";
    private String petReply = "replyKey";

    @Override
    public ResultInfo getComment(String rpId, Integer pageStart, Integer pageEnd) {
        if (StringUtils.isBlank(rpId)){
            return ResultInfo.failure(500,"rpId为空");
        }
        List<Object> petComments = redisTemplate.opsForList().range(rpId+commentKey, pageStart, pageEnd);
        return ResultInfo.success(200,"查询成功",petComments);
    }

    @Override
    public ResultInfo addComment(PetComment petComment) {
        if (StringUtils.isBlank(petComment.getRpId())){
            return ResultInfo.failure(500,"rpId为空");
        }
        IdWorker idWorker = new IdWorker(1,1,1);
        String id = String.valueOf(idWorker.nextId());
        petComment.setCmId(id);
        petComment.setCreateTime(System.currentTimeMillis());
        petComment.setCmStatus(true);
        //更新redis操作
        String commentsKey = petComment.getRpId()+commentKey;
        redisTemplate.opsForList().leftPush(commentsKey,petComment);
        return ResultInfo.success(200,"添加成功",petComment);
    }
}
