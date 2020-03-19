package com.pet.common.model;

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
public class PetInfoModel {

    private static final long serialVersionUID = 1L;

    private String itemId;
    private String petId;

    /**
     * 当前动作；就是做了什么 例如：进食，拉屎
     */
    private String petAction;

    private String actionTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date actionDate;

    /**
     * 动作详细描述
     */
    private String actionInfo;


}
