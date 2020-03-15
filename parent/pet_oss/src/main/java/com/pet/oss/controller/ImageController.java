package com.pet.oss.controller;

import com.pet.common.model.ResultInfo;
import com.pet.oss.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
@Api(tags = "oss")
public class ImageController {

    private final ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    /**
     * 文件上传到oss
     *
     * @param image
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation(value = " 上传文件", notes = " 上传文件", httpMethod = "POST")
    public ResultInfo uploadImg(@RequestParam("file") MultipartFile image) {
        return imageService.uploadImage(image);
    }

    /**
     * 多文件上传
     *
     * @param
     * @return
     * @throws Exception
     */
    @PostMapping("file/uploadMore")
    @ResponseBody
    public ResultInfo uploadMore(@RequestParam("files") MultipartFile[] uploadMoreFile)
            throws Exception {
        return null;
    }

    @GetMapping("/")
    public String www() {
        return "123";
    }
}
