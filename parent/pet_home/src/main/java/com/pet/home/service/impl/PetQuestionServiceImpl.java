package com.pet.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.common.entity.PetQuestion;
import com.pet.common.entity.PetReply;
import com.pet.common.model.IdWorker;
import com.pet.common.model.PetQuestionModel;
import com.pet.common.model.PetReplyModel;
import com.pet.common.model.ResultInfo;
import com.pet.common.utils.BeanUtils;
import com.pet.common.utils.EntityToModel;
import com.pet.home.mapper.PetQuestionMapper;
import com.pet.home.service.IPetQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.home.service.IPetReplyService;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Service
public class PetQuestionServiceImpl extends ServiceImpl<PetQuestionMapper, PetQuestion> implements IPetQuestionService {

    @Autowired
    private PetQuestionMapper petQuestionMapper;
    @Autowired
    private IPetReplyService petReplyService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private String petReplyKey = "replyKey";
    private String pet_question = "pet_question";

    @Override
    public ResultInfo addQuestion(PetQuestion petQuestion) {
        IdWorker idWorker = new IdWorker(1,1,1);
        String id = String.valueOf(idWorker.nextId());
        petQuestion.setQtId(id);
        petQuestion.setCreateTime(System.currentTimeMillis());
        petQuestion.setReplyCount(0);
        redisTemplate.opsForList().rightPush("pet_question",petQuestion);
        return ResultInfo.success(200,"添加成功",petQuestion);
    }

    @Override
    public ResultInfo delQuestion(String qtId, Integer index) {
        PetQuestion petQuestion = new PetQuestion();
        petQuestion.setQtId(qtId);
        petQuestion.setQtStatus(false);
        petQuestionMapper.updateById(petQuestion);
        List<Object> range = redisTemplate.opsForList().range(pet_question, 0, -1);
        for (int i = 0; i < range.size(); i++) {
            if (qtId.equals(((PetQuestion)range.get(i)).getQtId())){
                redisTemplate.opsForList().remove(pet_question,i, range.get(i));
            }
        }
        //删除回答，评论，点赞
        List<Object> range1 = redisTemplate.opsForList().range(qtId + petReplyKey, 0, -1);
        redisTemplate.delete(qtId+petReplyKey);
//        petReplyService.delReplyByQtId(qtId);
        return null;
    }

    @Override
    public ResultInfo getQuestion(String qtType,Integer pageStart,Integer pageEnd) {
        if (StringUtils.isBlank(qtType)){
            return ResultInfo.failure(500,"qtType");
        }
        List<Object> pet_question = redisTemplate.opsForList().range("pet_question", pageStart, pageEnd);
        List<PetQuestionModel> petQuestionModels = new ArrayList<>();
        for (int i = 0; i < pet_question.size(); i++) {
            PetQuestion petQuestion = (PetQuestion)pet_question.get(i);
            PetQuestionModel petQuestionModel = new PetQuestionModel();
            Long size = redisTemplate.opsForList().size(petQuestion.getQtId() + petReplyKey);
            assert size != null;
            petQuestion.setReplyCount(size.intValue());
            redisTemplate.opsForList().set("pet_question",i,petQuestion);
            EntityToModel.petQuestionToPetQuestionModel(petQuestion,petQuestionModel);
            PetReply petReply = (PetReply)redisTemplate.opsForList().index(petQuestion.getQtId() + petReplyKey,0);
            if (petReply!=null) {
                PetReplyModel petReplyModel = new PetReplyModel();
                EntityToModel.petReplyToPetReplyModel(petReply, petReplyModel);
                petQuestionModel.setPetReplyModel(petReplyModel);
            }
            petQuestionModels.add(petQuestionModel);
        }
        return ResultInfo.success(200,"查询成功",petQuestionModels);
    }

    public void test(){
        PetQuestion petQuestion = new PetQuestion();
        IdWorker idWorker = new IdWorker(1,1,1);
        petQuestion.setQtId(String.valueOf(idWorker.nextId()));
        petQuestion.setQtStatus(false);
        petQuestionMapper.insert(petQuestion);
    }

    @Override
    public void transQuestionFromRedis2DB() {
        List<Object> pet_question = redisTemplate.opsForList().range("pet_question", 0, -1);
        List<PetQuestion> petQuestions = new ArrayList<>();
        for (Object o:pet_question
             ) {
            petQuestions.add((PetQuestion) o);
        }
        petQuestionMapper.transQuestionFromRedis2DB(petQuestions);
        for (PetQuestion p:petQuestions
             ) {
            petReplyService.transReplyFromRedis2DB(p.getQtId());
        }
    }

    @Override
    public void test1(PetQuestion petQuestion) {
        petQuestion.setQtStatus(false);
        petQuestionMapper.updateById(petQuestion);
    }
}
