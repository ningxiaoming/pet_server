package com.pet.common.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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

    private String releaseId;

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
    private LocalDateTime releaseTime;


}
