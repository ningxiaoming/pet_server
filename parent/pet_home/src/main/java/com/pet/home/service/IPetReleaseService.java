package com.pet.home.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.common.entity.PetRelease;
import com.pet.common.model.ResultInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
public interface IPetReleaseService extends IService<PetRelease> {

    ResultInfo getPetRelease(String releaseId);
    ResultInfo getAllPetRelease();
    ResultInfo getBanner();

}
