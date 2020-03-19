package com.pet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.common.entity.PetTask;
import com.pet.common.model.IdWorker;
import com.pet.common.model.PetTaskModel;
import com.pet.common.model.ResultInfo;
import com.pet.common.utils.PetUtil;
import com.pet.user.mapper.PetTaskMapper;
import com.pet.user.service.IPetTaskService;
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
 * @since 2020-03-18
 */
@Service
public class PetTaskServiceImpl extends ServiceImpl<PetTaskMapper, PetTask> implements IPetTaskService {

    @Autowired
    private PetTaskMapper petTaskMapper;


    @Override
    public ResultInfo getTask(String userId) {
        QueryWrapper<PetTask> qw = new QueryWrapper<>();
        qw.eq("user_id",userId);
        qw.eq("is_exist",1);
        List<PetTask> petTasks = petTaskMapper.selectList(qw);
        return ResultInfo.success(200,"查询成功",petTasks);
    }

    @Override
    public ResultInfo upTask(PetTaskModel petTaskModel) {
        if (StringUtils.isBlank(petTaskModel.getTaskId())){
            return addTask(petTaskModel);
        }
        try {
            petTaskMapper.updateById(PetUtil.replacePetTask(petTaskModel));
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.failure(500,"未知错误，修改失败");
        }
        return ResultInfo.success(200,"编辑成功",petTaskModel);
    }

    @Override
    public ResultInfo addTask(PetTaskModel petTaskModel) {
        IdWorker idWorker = new IdWorker(1,1,1);
        petTaskModel.setTaskId(String.valueOf(idWorker.nextId()));
        try {
            petTaskMapper.insert(PetUtil.replacePetTask(petTaskModel));
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.failure(500,"添加失败");
        }
        return ResultInfo.success(200,"添加成功",petTaskModel);
    }
}
