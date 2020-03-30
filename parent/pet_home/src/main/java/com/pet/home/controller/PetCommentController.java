package com.pet.home.controller;



import com.pet.common.entity.PetComment;
import com.pet.common.entity.PetQuestion;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@Api(tags = "回答问题评论")
public class PetCommentController  {

    @Autowired
    private IPetCommentService petCommentService;

    @PostMapping("/comment")
    @ApiOperation(value = "添加一个回答的评论", notes = " 添加一个回答的评论", httpMethod = "POST")
    public ResultInfo addComment(PetComment PetComment) {
        ResultInfo resultInfo = petCommentService.addComment(PetComment);
        return resultInfo;
    }

    @GetMapping("/comment")
    @ApiOperation(value = "获取回答的评论集合", notes = "获取回答的评论集合", httpMethod = "GET")
    public ResultInfo getComment(String rpId, @RequestParam(defaultValue = "0") int pageStart, @RequestParam(defaultValue = "5") int pageEnd) {
//        PageHelper.startPage(pageNo, pageNum);
        ResultInfo resultInfo = petCommentService.getComment(rpId,pageStart,pageEnd);
        return resultInfo;
    }

}
