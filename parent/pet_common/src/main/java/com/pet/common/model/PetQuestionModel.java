package com.pet.common.model;

import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Data
@Accessors(chain = true)
public class PetQuestionModel {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    @TableId(value = "qt_id")
    private String qtId;

    /**
     * 创建问题的用户id
     */
    private String userId;

    /**
     * 问题描述
     */
    private String qtItem;

    /**
     * 问题的创建时间
     */

    private String createTime;

    /**
     * 此问题的回答数量
     */
    private Integer replyCount;

    /**
     * 问题状态：0删除
     */
    private Boolean qtStatus;

    /**
     * 提出问题的用户名称
     */
    private String userName;

    /**
     * 头像地址
     */
    private String userImage;

    /**
     * 问题类型
     */
    private String qtType;
    /**
     * 问题的第一条评论
     */
    private PetReplyModel petReplyModel;
}
