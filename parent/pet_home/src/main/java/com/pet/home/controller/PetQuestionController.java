package com.pet.home.controller;


import com.github.pagehelper.PageHelper;
import com.pet.common.entity.PetQuestion;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
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
@Api(tags = "首页问答模块")
public class PetQuestionController  {

    @Autowired
    private IPetQuestionService petQuestionService;


    @PostMapping("/question")
    @ApiOperation(value = "添加一个问题", notes = " 添加一个问题", httpMethod = "POST")
    public ResultInfo addQuestion(PetQuestion petQuestion) {
        ResultInfo resultInfo = petQuestionService.addQuestion(petQuestion);
        return resultInfo;
    }

    @GetMapping("/question")
    @ApiOperation(value = "根据用户类型，喜好来查询首页的问题集合", notes = " 根据用户类型，喜好来查询首页的问题集合", httpMethod = "GET")
    public ResultInfo getQuestion(String qtType,@RequestParam(defaultValue = "0") int pageStart, @RequestParam(defaultValue = "5") int pageEnd) {
//        PageHelper.startPage(pageNo, pageNum);
        ResultInfo resultInfo = petQuestionService.getQuestion(qtType,pageStart,pageEnd);
        return resultInfo;
    }
    @DeleteMapping("/question")
    @ApiOperation(value = "删除一个问题", notes = " 删除一个问题", httpMethod = "DELETE")
    public ResultInfo delQuestion(String qtId,Integer index) {
        ResultInfo resultInfo = petQuestionService.delQuestion(qtId,index);
        return resultInfo;
    }

    @GetMapping("/111")
    @ApiOperation(value = "根据用户类型，喜好来查询首页的问题集合", notes = " 根据用户类型，喜好来查询首页的问题集合", httpMethod = "GET")
    public ResultInfo getQuestion() {
//        PageHelper.startPage(pageNo, pageNum);
        petQuestionService.transQuestionFromRedis2DB();
        return null;
    }

}
