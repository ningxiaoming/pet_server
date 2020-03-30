package com.pet.common.model;

import java.time.LocalDateTime;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.pet.common.entity.PetComment;
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
public class PetReplyModel {

    private static final long serialVersionUID = 1L;

    /**
     * 问题答案的id
     */
    private String rpId;

    /**
     * 问题id pet_question的主键
     */
    private String qtId;

    /**
     * 回答人的id，pet_user的主键
     */
    private String userId;

    /**
     * 评论的用户名称
     */
    private String userName;

    /**
     * 头像url
     */
    private String userImage;

    /**
     * 回答详情
     */
    private String rpItem;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 回答状态：0表示删除答案
     */
    private Boolean rpStatus;
    /**
     * 当前用户点赞状态：0表示没有点赞
     */
    private Boolean lkStatus;

    /**
     * 创建时间
     */

    private String createTime;

    /**
     * 更新回答时间
     */

    private String upTime;

    private List<PetCommentModel> commentList;


}
