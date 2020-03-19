package com.pet.user.mapper;

import com.pet.common.entity.PetInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.common.model.PetInfoModel;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@Repository
public interface PetInfoMapper extends BaseMapper<PetInfo> {

    List<PetInfoModel> selectListByPetIdAndDate(String petId, String actionDate);
    List<PetInfoModel> findDatesByPetIdAndDate(String petId, String actionDate);

}
