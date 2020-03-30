package com.pet.common.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PetReplyLike {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞的id
     */
    @TableId(value = "lk_id")
    private String lkId;

    /**
     * 被点赞的用户id
     */
    private String lkUserId;

    /**
     * 点赞的用户id
     */
    private String lkPostId;

    /**
     * 创建时间
     */

    private long createTime;


    private long upTime;

    /**
     * 点赞状态  0取消，1点赞
     */
    private Boolean lkStatus;

    /**
     * 答案的id
     */
    private String rpId;


}
