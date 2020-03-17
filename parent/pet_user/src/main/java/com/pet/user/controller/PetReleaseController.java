package com.pet.user.controller;


import com.pet.common.entity.PetPets;
import com.pet.common.entity.PetRelease;
import com.pet.common.model.ResultInfo;
import com.pet.user.service.IPetReleaseService;
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
//@RequestMapping("/user/pet-release")
public class PetReleaseController {

    private final IPetReleaseService petReleaseService;
    public PetReleaseController(IPetReleaseService petReleaseService){
        this.petReleaseService=petReleaseService;
    }



    @PutMapping("/release")
    @ApiOperation(value = " 添加一个宠物发布信息", notes = " 添加一个宠物发布信息", httpMethod = "PUT")
    public ResultInfo addPetRelease(PetRelease petRelease) {
        ResultInfo resultInfo = petReleaseService.addPetRelease(petRelease);
        return resultInfo;
    }
    @GetMapping("/release/{releaseId}")
    @ApiOperation(value = " 查询一个宠物发布信息", notes = " 查询一个宠物发布信息", httpMethod = "GET")
    public ResultInfo getPetRelease(@PathVariable String releaseId) {
        ResultInfo resultInfo = petReleaseService.getPetRelease(releaseId);
        return resultInfo;
    }
    @GetMapping("/release/{userId}")
    @ApiOperation(value = " 查询当前用户的所有发布信息", notes = " 查询当前用户的所有发布信息", httpMethod = "GET")
    public ResultInfo getPetReleaseByUserId(@PathVariable String userId) {
        ResultInfo resultInfo = petReleaseService.getPetReleaseByUserId(userId);
        return resultInfo;
    }
    @PostMapping("/release")
    @ApiOperation(value = " 编辑一个宠物发布信息", notes = " 编辑一个宠物发布信息", httpMethod = "POST")
    public ResultInfo upPetRelease(PetRelease petRelease) {
        ResultInfo resultInfo = petReleaseService.upPetRelease(petRelease);
        return resultInfo;
    }
    @DeleteMapping("/release/{releaseId}")
    @ApiOperation(value = " 删除一个宠物信息", notes = " 删除一个宠物信息", httpMethod = "DELETE")
    public ResultInfo dePetRelease(@PathVariable String releaseId) {
        ResultInfo resultInfo = petReleaseService.dePetRelease(releaseId);
        return resultInfo;
    }

}
