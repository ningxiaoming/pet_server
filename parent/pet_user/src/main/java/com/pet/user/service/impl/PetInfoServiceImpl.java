package com.pet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.common.entity.PetInfo;
import com.pet.common.model.IdWorker;
import com.pet.common.model.PetInfoModel;
import com.pet.common.model.ResultInfo;
import com.pet.common.utils.PetUtil;
import com.pet.user.mapper.PetInfoMapper;
import com.pet.user.service.IPetInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
public class PetInfoServiceImpl extends ServiceImpl<PetInfoMapper, PetInfo> implements IPetInfoService {

    @Autowired
    private PetInfoMapper petInfoMapper;


    @Override
    public ResultInfo getDate(String petId, String date) {
        List<PetInfoModel> petInfos = null;
        try {
            if (StringUtils.isBlank(date)) {
                date = PetUtil.getStringDate();
            }
            petInfos = petInfoMapper.findDatesByPetIdAndDate(petId,date);
        }catch (Exception e){
            e.printStackTrace();
            ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.success(200,"查询成功",petInfos);
    }

    @Override
    public ResultInfo getAction(String petId,String date) {
        List<PetInfoModel> petInfos = null;
        try {
            if (StringUtils.isBlank(date)) {
                date = PetUtil.getStringDate();
            }
            petInfos = petInfoMapper.selectListByPetIdAndDate(petId,date);
        }catch (Exception e){
            e.printStackTrace();
            ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.success(200,"查询成功",petInfos);
    }

    @Override
    public ResultInfo upAction(PetInfo petInfo) {
        if (StringUtils.isBlank(petInfo.getItemId())){
            return addAction(petInfo);
        }
        petInfoMapper.updateById(petInfo);
        return ResultInfo.success(200,"修改记录成功");
    }

    @Override
    public ResultInfo addAction(PetInfo petInfo) {
        try {
            petInfo.setActionDate(PetUtil.getDate());
            IdWorker idWorker = new IdWorker(1,1,1);
            long itemId = idWorker.nextId();
            petInfo.setItemId(String.valueOf(itemId));
            petInfo.setActionTime(LocalDateTime.now());
            petInfoMapper.insert(petInfo);
        }catch (Exception e){
            e.printStackTrace();
            ResultInfo.failure(500,"系统错误");
        }
        return ResultInfo.success(200,"添加记录成功");
    }
}
