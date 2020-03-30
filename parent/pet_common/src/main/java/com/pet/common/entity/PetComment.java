package com.pet.common.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class PetComment {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "cm_id")
    private String cmId;
    /**
     * pet_question表的id
     */
    private String qtId;
    /**
     * pet_reply表的id
     */
    private String rpId;

    /**
     * 评论人的id
     */
    private String userId;

    /**
     * 评论人名称
     */
    private String userName;

    /**
     * 评论人头像url
     */
    private String userImage;

    /**
     * 评论的父id
     */
    private String cmParentId;
    /**
     * 被回复人的名称
     */
    private String cmParentIdName;

    /**
     * 评论详情
     */
    private String cmItem;

    /**
     * 创建时间
     */

    private long createTime;

    /**
     * 评论状态  0表示删除1表示存在
     */
    private Boolean cmStatus;


}
