package com.pet.home.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.common.entity.PetRelease;
import com.pet.common.model.ResultInfo;
import com.pet.home.mapper.PetReleaseMapper;
import com.pet.home.service.IPetReleaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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
        this.petReleaseMapper = petReleaseMapper;
    }
    @Override
    public ResultInfo getPetRelease(String releaseId) {
        PetRelease petRelease = null;
        try {
            petRelease = petReleaseMapper.selectById(releaseId);
        }catch (Exception e){
            return ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.success(200,"查询成功",petRelease);
    }

    @Override
    public ResultInfo getAllPetRelease() {
        QueryWrapper<PetRelease> qw = new QueryWrapper<>();
        List<PetRelease> petReleases = null;
        try {
            petReleases = petReleaseMapper.selectList(qw);
        }catch (Exception e){
            return ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.success(200,"查询成功",petReleases);
    }
}
