package com.pet.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.common.entity.PetInfo;
import com.pet.common.model.ResultInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
public interface IPetInfoService extends IService<PetInfo> {

    ResultInfo upAction(PetInfo petInfo);
    ResultInfo addAction(PetInfo petInfo);
    ResultInfo getAction(String petId, String date);
    ResultInfo getDate(String petId,String date);

}
