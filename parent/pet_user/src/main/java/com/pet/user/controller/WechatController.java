package com.pet.user.controller;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.common.utils.WXUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WechatController {

    protected static Logger logger = Logger.getLogger(WechatController.class);
    
    // 自定义 token
    private String token = "rinima";

    @RequestMapping("/handle")
    @ResponseBody
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        String tmpStr = getSHA1(token, timestamp, nonce);
        if (tmpStr.equals(signature)) {
            return echostr;
        } else {
            return null;
        }
    }

    /**
     * 用SHA1算法生成安全签名
     * 
     * @param token
     *            token
     * @param timestamp
     *            时间戳
     * @param nonce
     *            随机字符串
     * @return 安全签名
     */
    public String getSHA1(String token, String timestamp, String nonce) throws Exception {
        String[] array = new String[] { token, timestamp, nonce };
        StringBuffer sb = new StringBuffer();
        // 字符串排序
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        String str = sb.toString();
        // SHA1签名生成
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(str.getBytes());
        byte[] digest = md.digest();

        StringBuffer hexstr = new StringBuffer();
        String shaHex = "";
        for (int i = 0; i < digest.length; i++) {
            shaHex = Integer.toHexString(digest[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexstr.append(0);
            }
            hexstr.append(shaHex);
        }
        return hexstr.toString();
    }

    // 网页授权入口
    @RequestMapping("/preAuth")
    public void preAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirectUrl="http://wechat.zengnansheng.com/auth";
        logger.info(WXUtils.getAuthorizeUrl(redirectUrl));
        response.sendRedirect(WXUtils.getAuthorizeUrl(redirectUrl));
    }

    // 网页授权
    @RequestMapping("/auth")
    public String auth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code=request.getParameter("code");
        logger.info("code:"+code);
        Map<String, String> accessTokenMap = WXUtils.getAccessToken(code);
        String openId = accessTokenMap.get("openid");
        String accessToken = accessTokenMap.get("access_token");
        if (!StringUtils.isEmpty(openId)) {
            Map<String, String> userInfoMap = WXUtils.getUserInfo(accessToken, openId);
            logger.info("用户信息:"+userInfoMap);
            //业务处理...
            return "重定向到新的url";
        }
        return "重定向到失败的url";
    }

}