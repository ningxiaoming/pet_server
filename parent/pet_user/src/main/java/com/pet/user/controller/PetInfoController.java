package com.pet.user.controller;


import com.pet.common.entity.PetInfo;
import com.pet.common.entity.PetPets;
import com.pet.common.model.ResultInfo;
import com.pet.user.service.IPetInfoService;
import com.pet.user.service.IPetPetsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@RestController
@Api(tags = "宠物动作详情")
public class PetInfoController  {

    private final IPetInfoService petInfoService;
    public PetInfoController(IPetInfoService petInfoService) {
        this.petInfoService = petInfoService;
    }

    @PostMapping("/action")
    @ApiOperation(value = " （添加）编辑一条动作", notes = " （添加）编辑一条动作", httpMethod = "POST")
    public ResultInfo upAction(PetInfo petInfo) {
        ResultInfo resultInfo = petInfoService.upAction(petInfo);
        return resultInfo;
    }

    @GetMapping("/action/{petId}")
    @ApiOperation(value = "查询当前宠物当天(或者某一天)的action", notes = "查询当前宠物当天的action", httpMethod = "GET")
    public ResultInfo getAction(@PathVariable String petId, String date) {
        ResultInfo resultInfo = petInfoService.getAction(petId,date);
        return resultInfo;
    }
    @GetMapping("/action/date/{petId}")
    @ApiOperation(value = "获取十天的action记录", notes = "获取十天的action记录", httpMethod = "GET")
    public ResultInfo getDate(@PathVariable String petId, String date) {
        ResultInfo resultInfo = petInfoService.getDate(petId,date);
        return resultInfo;
    }

}
