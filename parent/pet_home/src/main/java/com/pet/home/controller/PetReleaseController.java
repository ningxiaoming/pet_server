package com.pet.home.controller;


import com.github.pagehelper.PageHelper;
import com.pet.common.model.ResultInfo;
import com.pet.home.service.IPetReleaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@RestController
@Api(tags = "首页")
public class PetReleaseController {

    private final IPetReleaseService petReleaseService;
    public PetReleaseController(IPetReleaseService petReleaseService){
        this.petReleaseService=petReleaseService;
    }



    @GetMapping("/ip")
    @ApiOperation(value = " 获取ip", notes = " 获取ip", httpMethod = "GET")
    public ResultInfo getIp(HttpServletRequest request) throws Exception {
        if (request == null) {
            throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
        }
        String ipString = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
            ipString = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ipString.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ipString = str;
                break;
            }
        }

        return ResultInfo.success(200,"",ipString);
    }

    @GetMapping("/home/{releaseId}")
    @ApiOperation(value = " 查询一个宠物发布信息", notes = " 查询一个宠物发布信息", httpMethod = "GET")
    public ResultInfo getPetRelease(@PathVariable String releaseId) {
        ResultInfo resultInfo = petReleaseService.getPetRelease(releaseId);
        return resultInfo;
    }
    @GetMapping("/home/releases")
    @ApiOperation(value = " 查询10条发布信息", notes = " 查询10条发布信息", httpMethod = "GET")
    public ResultInfo getAllPetRelease(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageNum) {
        PageHelper.startPage(pageNo, pageNum);
        ResultInfo resultInfo = petReleaseService.getAllPetRelease();
        return resultInfo;
    }

    @GetMapping("/banner")
    @ApiOperation(value = "获取banner", notes = " 获取banner", httpMethod = "GET")
    public ResultInfo getBanner() {
        ResultInfo resultInfo = petReleaseService.getBanner();
        return resultInfo;
    }

}
