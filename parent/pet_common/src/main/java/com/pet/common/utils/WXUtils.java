package com.pet.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WXUtils {
    /**
     * 获取生成的授权URL
     */
    public static String getAuthorizeUrl(String redirectUrl) {
        return String.format(
                "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
                WXConfig.appId, redirectUrl, "snsapi_userinfo", "state_xxx");
    }

    /**
     * 根据code获取access_token、openid等信息
     */
    public static Map<String, String> getAccessToken(String code) {
        JsonObject jsonObject = null;
        Map<String, String> map = new HashMap();
        try {
            String url = String.format(
                    "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                    WXConfig.appId, WXConfig.appSecret, code);
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String results = EntityUtils.toString(httpEntity, "utf-8");
            Gson gson = new Gson();
            jsonObject = gson.fromJson(results, JsonObject.class);
            map.put("openid", jsonObject.get("openid").toString().replaceAll("\"", ""));
            map.put("expires_in", jsonObject.get("expires_in").toString().replaceAll("\"", ""));
            map.put("refresh_token", jsonObject.get("refresh_token").toString().replaceAll("\"", ""));
            map.put("access_token", jsonObject.get("access_token").toString().replaceAll("\"", ""));
            map.put("scope", jsonObject.get("scope").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    /**
     * 根据accessToken、openId获取用户信息
     */
    public static Map<String, String> getUserInfo(String accessToken, String openId) {
        Map<String, String> map = new HashMap();
        String url = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN",
                accessToken, openId);
        JsonObject jsonObject = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity, "utf-8");
            Gson gson = new Gson();
            jsonObject = gson.fromJson(response, JsonObject.class);
            map.put("openid", jsonObject.get("openid").toString().replaceAll("\"", ""));
            map.put("nickname", jsonObject.get("nickname").toString().replaceAll("\"", ""));
            map.put("sex", jsonObject.get("sex").toString().replaceAll("\"", ""));
            map.put("country", jsonObject.get("country").toString().replaceAll("\"", ""));
            map.put("province", jsonObject.get("province").toString().replaceAll("\"", ""));
            map.put("city", jsonObject.get("city").toString().replaceAll("\"", ""));
            map.put("headimgurl", jsonObject.get("headimgurl").toString().replaceAll("\"", ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}