package com.pet.common.utils;

import com.pet.common.entity.PetTask;
import com.pet.common.model.PetTaskModel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PetUtil {

    //替换对象
    public static PetTask replacePetTask(PetTaskModel petTaskModel){
        PetTask petTask = new PetTask();
        petTask.setTaskId(petTaskModel.getTaskId());
        petTask.setIsExist(1);
        petTask.setTaskTime(PetUtil.getLocalDateTime(petTaskModel.getTaskTime()));
        petTask.setIsExist(1);
        petTask.setTaskName(petTaskModel.getTaskName());
        petTask.setTaskType(petTaskModel.getTaskType());
        petTask.setTaskDescription(petTaskModel.getTaskDescription());
        petTask.setUserId(petTaskModel.getUserId());
        return petTask;
    }
    //将字符串类型的日期转化成LocalDateTime
    public static LocalDateTime getLocalDateTime(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(localDateTime, df);
    }
    //获取当前时间，并且转化成yyyy-MM-dd格式
    public static Date getDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        try {
            date = dateFormat.parse(format);
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }
    //获取当前时间字符串类型的，并且转化成yyyy-MM-dd格式
    public static String getStringDate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
