package com.pet.user.controller;


import com.pet.common.entity.PetPets;
import com.pet.common.model.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@RestController
@Api(tags = "用户模块")
public class PetUserController {

    @PostMapping("/wxLogin")
    @ApiOperation(value = "微信登录", notes = " 微信登录", httpMethod = "POST")
    public ResultInfo upPets(PetPets petPets) {

        return null;
    }

}
