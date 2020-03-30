package com.pet.home.service;

import com.pet.common.entity.PetQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.common.model.ResultInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
public interface IPetQuestionService extends IService<PetQuestion> {
    void test();
    void test1(PetQuestion petQuestion);
    ResultInfo addQuestion(PetQuestion petQuestion);
    ResultInfo delQuestion(String qtId,Integer index);
    ResultInfo getQuestion(String qtType,Integer pageStart,Integer pageEnd);


    void transQuestionFromRedis2DB();
}
