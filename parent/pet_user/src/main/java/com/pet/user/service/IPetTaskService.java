package com.pet.user.service;

import com.pet.common.entity.PetTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.common.model.PetTaskModel;
import com.pet.common.model.ResultInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmn
 * @since 2020-03-18
 */
public interface IPetTaskService extends IService<PetTask> {

    ResultInfo upTask(PetTaskModel PetTaskModel);
    ResultInfo addTask(PetTaskModel petTask);
    ResultInfo getTask(String userId);
}
