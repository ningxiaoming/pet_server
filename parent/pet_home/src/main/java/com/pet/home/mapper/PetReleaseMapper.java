package com.pet.home.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.common.entity.PetBanner;
import com.pet.common.entity.PetRelease;
import org.springframework.stereotype.Repository;

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
public interface PetReleaseMapper extends BaseMapper<PetRelease> {
    List<PetBanner> getBanner();

}
