package com.pet.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@Data
@Accessors(chain = true)
public class PetUser {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String wxId;

    private String wxName;

    private String userName;

    private String userPhone;

    private String userProvince;

    private String userCity;

    private String userArea;

    private String userAddress;

    private LocalDateTime regTime;

    private LocalDateTime loginTime;


}
