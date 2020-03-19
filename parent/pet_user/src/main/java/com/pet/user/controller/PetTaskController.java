package com.pet.user.controller;


import com.pet.common.entity.PetPets;
import com.pet.common.entity.PetTask;
import com.pet.common.model.PetTaskModel;
import com.pet.common.model.ResultInfo;
import com.pet.user.service.IPetTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-18
 */
@RestController
@Api(tags = "定时任务")
public class PetTaskController {

    private final IPetTaskService petTaskService;
    public PetTaskController(IPetTaskService petTaskService) {
        this.petTaskService = petTaskService;
    }

    @PostMapping("/Task")
    @ApiOperation(value = " （添加）编辑一个任务信息", notes = " （添加）编辑一个任务信息", httpMethod = "POST")
    public ResultInfo upTask(PetTaskModel petTaskModel) {
        ResultInfo resultInfo = petTaskService.upTask(petTaskModel);
        return resultInfo;
    }
    @GetMapping("/Task/{userId}")
    @ApiOperation(value = " 获取当前用户下所有的定时任务", notes = " 获取当前用户下所有的定时任务", httpMethod = "GET")
    public ResultInfo getTask(@PathVariable String userId) {
        ResultInfo resultInfo = petTaskService.getTask(userId);
        return resultInfo;
    }

}
