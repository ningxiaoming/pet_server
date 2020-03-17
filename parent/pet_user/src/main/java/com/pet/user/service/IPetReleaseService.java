package com.pet.user.service;

import com.pet.common.entity.PetRelease;
import com.baomidou.mybatisplus.extension.service.IService;
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
    ResultInfo addPetRelease(PetRelease petRelease);
    ResultInfo getPetRelease(String releaseId);
    ResultInfo getPetReleaseByUserId(String userId);
    ResultInfo upPetRelease(PetRelease petRelease);
    ResultInfo dePetRelease(String releaseId);


}
