package com.pet.home.controller;


import com.github.pagehelper.PageHelper;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetReleaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@RestController
//@RequestMapping("/pet_home/pet-release")
public class PetReleaseController {

    private final IPetReleaseService petReleaseService;
    public PetReleaseController(IPetReleaseService petReleaseService){
        this.petReleaseService=petReleaseService;
    }




    @GetMapping("/home/{releaseId}")
    @ApiOperation(value = " 查询一个宠物发布信息", notes = " 查询一个宠物发布信息", httpMethod = "GET")
    public ResultInfo getPetRelease(@PathVariable String releaseId) {
        ResultInfo resultInfo = petReleaseService.getPetRelease(releaseId);
        return resultInfo;
    }
    @GetMapping("/home/releases")
    @ApiOperation(value = " 查询所有发布信息", notes = " 查询所有发布信息", httpMethod = "GET")
    public ResultInfo getAllPetRelease(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageNum) {
        PageHelper.startPage(pageNo, pageNum);
        ResultInfo resultInfo = petReleaseService.getAllPetRelease();
        return resultInfo;
    }

}
