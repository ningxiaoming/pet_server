package com.pet.user.service.impl;

import com.pet.common.entity.PetRelease;
import com.pet.common.model.IdWorker;
import com.pet.common.model.ResultInfo;
import com.pet.common.utils.PetUtil;
import com.pet.user.mapper.PetReleaseMapper;
import com.pet.user.service.IPetReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@Service
public class PetReleaseServiceImpl extends ServiceImpl<PetReleaseMapper, PetRelease> implements IPetReleaseService {

    private final PetReleaseMapper petReleaseMapper;
    public PetReleaseServiceImpl(PetReleaseMapper petReleaseMapper){
        this.petReleaseMapper=petReleaseMapper;
    }

    @Override
    public ResultInfo addPetRelease(PetRelease petRelease) {
        IdWorker idWorker = new IdWorker(1,1,1);
        petRelease.setReleaseId(String.valueOf(idWorker.nextId()));
        petRelease.setReleaseDate(PetUtil.getDate());
        try {
            petReleaseMapper.insert(petRelease);
        }catch (Exception e){
            return ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.failure(200,"添加成功",petRelease);
    }

    @Override
    public ResultInfo getPetRelease(String releaseId) {
        return null;
    }

    @Override
    public ResultInfo getPetReleaseByUserId(String userId) {
        return null;
    }

    @Override
    public ResultInfo upPetRelease(PetRelease petRelease) {
        return null;
    }

    @Override
    public ResultInfo dePetRelease(String releaseId) {
        return null;
    }
}
