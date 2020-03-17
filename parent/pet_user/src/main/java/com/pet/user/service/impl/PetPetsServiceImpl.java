package com.pet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.common.entity.PetPets;
import com.pet.common.model.IdWorker;
import com.pet.common.model.ResultInfo;
import com.pet.user.mapper.PetPetsMapper;
import com.pet.user.service.IPetPetsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
public class PetPetsServiceImpl extends ServiceImpl<PetPetsMapper, PetPets> implements IPetPetsService {

//    private final PetPetsMapper petPetsMapper;
//    public PetPetsServiceImpl(PetPetsMapper petPetsMapper) {
//        this.petPetsMapper = petPetsMapper;
//    }
    @Autowired
    private PetPetsMapper petPetsMapper;

    @Override
    public ResultInfo addPets(PetPets petPets) {
        IdWorker idWorker = new IdWorker(1,1,1);
        petPets.setPetId(String.valueOf(idWorker.nextId()));
        petPets.setAddTime(LocalDateTime.now());
        try {
            petPetsMapper.insert(petPets);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.failure(500,"添加失败");
        }
        return ResultInfo.success(200,"添加成功",petPets);
    }

    @Override
    public ResultInfo getPets(String petId) {
        if (StringUtils.isBlank(petId)){
            return ResultInfo.failure(500,"id为空");
        }
        PetPets petPets = petPetsMapper.selectById(petId);
        if (null == petPets) {
            return ResultInfo.failure(500,"次宠物不存在或者已经被删除");
        }
        return ResultInfo.success(200,"查询成功",petPets);
    }

    @Override
    public ResultInfo getAllPets(String userId) {
        if (StringUtils.isBlank(userId)){
            return ResultInfo.failure(500,"id为空");
        }
        QueryWrapper<PetPets> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        List<PetPets> petPets = null;
        try {
           petPets = petPetsMapper.selectList(qw);
        }catch (Exception e){
            return ResultInfo.failure(500,"未知错误，修改失败");
        }
        return ResultInfo.success(200,"查询成功",petPets);
    }

    @Override
    public ResultInfo upPets(PetPets petPets) {
        if (StringUtils.isBlank(petPets.getPetId())){
            return addPets(petPets);
        }
        try {
            petPetsMapper.updateById(petPets);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.failure(500,"未知错误，修改失败");
        }
        return ResultInfo.success(200,"编辑成功",petPets);
    }

    @Override
    public ResultInfo dePets(String petId) {
        if (StringUtils.isBlank(petId)){
            return ResultInfo.failure(500,"id为空");
        }
        PetPets petPets = new PetPets();
        petPets.setPetId(petId);
        petPets.setIsExist(0);
        try {
            petPetsMapper.updateById(petPets);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.failure(500,"系统错误，删除失败");
        }
        return ResultInfo.success(200,"删除成功");
    }
}
