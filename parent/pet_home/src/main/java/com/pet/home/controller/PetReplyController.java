package com.pet.home.controller;


import com.pet.common.entity.PetQuestion;
import com.pet.common.entity.PetReply;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@RestController
@Api(tags = "回答问题模块")
public class PetReplyController {

    @Autowired
    private IPetReplyService petReplyService;

    @PostMapping("/reply")
    @ApiOperation(value = "添加一个回答", notes = " 添加一个回答", httpMethod = "POST")
    public ResultInfo addReply(PetReply petReply) {
        ResultInfo resultInfo = petReplyService.addReply(petReply);
        return resultInfo;
    }

    @GetMapping("/reply")
    @ApiOperation(value = "获取当前问题的答案", notes = " 获取当前问题的答案", httpMethod = "GET")
    public ResultInfo getReply(String userId,String qtId, @RequestParam(defaultValue = "0") int pageStart, @RequestParam(defaultValue = "5") int pageEnd) {
        //通过token获取userId
        ResultInfo resultInfo = petReplyService.getReply(userId,qtId,pageStart,pageEnd);
        return resultInfo;
    }

}
