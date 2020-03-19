package com.pet.zuul.controller;

import com.pet.common.model.ResultInfo;
import com.pet.common.utils.SHA1;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

@RestController
public class WxController {


    @GetMapping("/wx")
    @ApiOperation(value = " 微信测试", notes = "微信测试", httpMethod = "GET")
    public String getPets(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String echostr = request.getParameter("echostr");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String token = "rinima";
        String[] arr = {token,timestamp,nonce};
        Arrays.sort(arr);
        try {
            StringBuffer buu = new StringBuffer();
            for(String st:arr){
                buu.append(st);
            }
            String opresult = SHA1.encode(buu.toString());
            if(opresult.equals(signature)){
                return echostr;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return "";
    }
}
