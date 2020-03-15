package com.pet.common.model;

import lombok.Data;

/**
 * Copyright (C), 2016-2019, Mobius-Vision
 * FileName: ResultInfo
 * Author: liuwenxu
 * Date: 2019/7/10 18:03
 * Description: 返回结果
 */
@Data
public class ResultInfo {

    private Integer code;
    private String msg;
    private Object data; // 返回结果


    public ResultInfo() {
    }

    public ResultInfo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultInfo(String msg) {
        this.msg = msg;
    }

    public ResultInfo(Integer code) {
        this.code = code;
    }


    public ResultInfo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultInfo(Object data) {
        this.data = data;
    }
    public ResultInfo(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public ResultInfo(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public static ResultInfo success(Integer code, String msg, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo success(Integer code, String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        return resultInfo;
    }
    public static ResultInfo failure(Integer code, String msg, Object data) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        resultInfo.setData(data);
        return resultInfo;
    }

    public static ResultInfo failure(Integer code, String msg) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(code);
        resultInfo.setMsg(msg);
        return resultInfo;
    }
}