package com.pet.home.controller;


import com.pet.common.entity.PetQuestion;
import com.pet.common.entity.PetReplyLike;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetReplyLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@RestController
@Api(tags = "回答问题点赞模块")
public class PetReplyLikeController {

    @Autowired
    private IPetReplyLikeService petReplyLikeService;

    @GetMapping("/rpLike")
    @ApiOperation(value = "查看当前用户有没有对当前回答点赞", notes = " 查看当前用户有没有对当前回答点赞", httpMethod = "GET")
    public ResultInfo getReplyLike(PetReplyLike petReplyLike) {
        ResultInfo resultInfo = petReplyLikeService.getReplyLike(petReplyLike);
        return resultInfo;
    }
    @PostMapping("/rpLike")
    @ApiOperation(value = "对一个回答点赞", notes = " 对一个回答点赞", httpMethod = "POST")
    public ResultInfo addReplyLike(PetReplyLike petReplyLike) {
        ResultInfo resultInfo = petReplyLikeService.addReplyLike(petReplyLike);
        return resultInfo;
    }
    @PostMapping("/unRpLike")
    @ApiOperation(value = "取消点赞", notes = "取消点赞", httpMethod = "POST")
    public ResultInfo delReplyLike(PetReplyLike petReplyLike) {
        ResultInfo resultInfo = petReplyLikeService.delReplyLike(petReplyLike);
        return resultInfo;
    }
}
