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
public class PetInfo {

    private static final long serialVersionUID = 1L;

    private String itemId;

    /**
     * 当前动作；就是做了什么 例如：进食，拉屎
     */
    private String action;

    private LocalDateTime actionTime;

    /**
     * 动作详细描述
     */
    private String actionInfo;


}
