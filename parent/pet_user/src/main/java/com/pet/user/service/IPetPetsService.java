package com.pet.user.service;

import com.pet.common.entity.PetPets;
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
public interface IPetPetsService extends IService<PetPets> {

    ResultInfo addPets(PetPets petPets);
    ResultInfo getPets(String petId);
    ResultInfo getAllPets(String userId);
    ResultInfo upPets(PetPets petPets);
    ResultInfo dePets(String petId);
}
