package com.pet.user.controller;


import com.pet.common.entity.PetPets;
import com.pet.common.model.ResultInfo;
import com.pet.user.service.IPetPetsService;
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
 * @since 2020-03-14
 */
@RestController
@Api(tags = "宠物模块")
public class PetPetsController {

    private final IPetPetsService petPetsService;
    public PetPetsController(IPetPetsService petPetsService) {
        this.petPetsService = petPetsService;
    }

/*    @PostMapping("/pet")
    @ApiOperation(value = " 添加一个宠物信息", notes = " 添加一个宠物信息", httpMethod = "POST")
    public ResultInfo addPets(PetPets petPets) {
        ResultInfo resultInfo = petPetsService.addPets(petPets);
        return resultInfo;
    }*/
    @GetMapping("/pet/{petId}")
    @ApiOperation(value = " 查询一个宠物信息", notes = " 查询一个宠物信息", httpMethod = "GET")
    public ResultInfo getPets(@PathVariable String petId) {
        ResultInfo resultInfo = petPetsService.getPets(petId);
        return resultInfo;
    }
    @GetMapping("/pets")
    @ApiOperation(value = " 查询一个宠物信息", notes = " 查询一个宠物信息", httpMethod = "GET")
    public ResultInfo getAllPets() {
        String userId = "123";
        ResultInfo resultInfo = petPetsService.getAllPets(userId);
        return resultInfo;
    }
    @PostMapping("/pet")
    @ApiOperation(value = " （添加）编辑一个宠物信息", notes = " （添加）编辑一个宠物信息", httpMethod = "POST")
    public ResultInfo upPets(PetPets petPets) {
        ResultInfo resultInfo = petPetsService.upPets(petPets);
        return resultInfo;
    }
    @DeleteMapping("/pet/{petId}")
    @ApiOperation(value = " 删除一个宠物信息", notes = " 删除一个宠物信息", httpMethod = "DELETE")
    public ResultInfo dePets(@PathVariable String petId) {
        ResultInfo resultInfo = petPetsService.dePets(petId);
        return resultInfo;
    }



}
