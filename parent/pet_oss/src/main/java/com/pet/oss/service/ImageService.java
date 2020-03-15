package com.pet.oss.service;


import com.aliyun.oss.OSS;
import com.pet.common.model.IdWorker;
import com.pet.common.model.ResultInfo;
import com.pet.oss.config.AliyunConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
public class ImageService {
    //允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg", ".jpeg", ".svg", ".gif", ".png"};
    @Autowired
    private OSS ossClient;
    @Autowired
    private AliyunConfig aliyunConfig;

    public ResultInfo uploadImage(MultipartFile image){

        // 校验文件格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(image.getOriginalFilename(),
                    type)) {
                isLegal = true;
                break;
            }
        }

        if (!isLegal) {
            return ResultInfo.failure(200,"图片格式不正确");
        }
        IdWorker idWorker = new IdWorker(1,1,1);
        String filePath = "test/"+String.valueOf(idWorker.nextId())+".png";
        // 上传到阿里云
        try {
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, new
                    ByteArrayInputStream(image.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.failure(200,"上传失败");
        }
        return ResultInfo.success(200,"上传成功",filePath);

    }
}
