package com.pet.common.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@Data
@Accessors(chain = true)
public class PetRelease  {

    private static final long serialVersionUID = 1L;
    @TableId(value = "release_id")
    private String releaseId;


    private String userId;
    private String userName;
    private String userPhone;

    /**
     * 发布类型；例如：买卖；托管；配偶
     */
    private String releaseType;

    /**
     * 宠物类型；猫，狗
     */
    private String petType;

    private String petSex;

    private Double petAge;

    private String petImage;

    /**
     * 宠物品种：金毛，贵宾。。。。等
     */
    private String petVariety;

    /**
     * 宠物描述
     */
    private String petDescription;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date releaseDate;

    /**
        省
     */
    private String releaseProvince;
    /**
        市
    */
    private String releaseCity;
    /**
        区
    */
    private String releaseArea;
    /**
        详细地址
    */
    private String releaseAddress;


}
