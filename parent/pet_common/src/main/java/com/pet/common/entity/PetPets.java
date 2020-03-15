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
public class PetPets  {

    private static final long serialVersionUID = 1L;

    private String petId;

    /**
     * 用户id
     */
    private String userId;

    private String petType;

    private String petName;

    /**
     * 宠物照片地址
     */
    private String petImage;

    /**
     * 宠物性别
     */
    private String petSex;

    private Double petAge;

    /**
     * 出生日期
     */
    private LocalDateTime petBirthday;

    private LocalDateTime addTime;

    /**
     * 此宠物是否被删除：0表示删除
     */
    private Integer isExist;

    /**
     * 是否主页显示宠物：0表示不是
     */
    private Integer isHome;

    /**
     * 宠物品种：金毛，阿拉斯加  等
     */
    private String petVariety;


}
