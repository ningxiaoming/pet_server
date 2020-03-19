package com.pet.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author xmn
 * @since 2020-03-18
 */
@Data
public class PetTaskModel {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    private String taskId;
    private String userId;
    /**
     * 任务执行时间
     */
    private String taskTime;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务说明
     */
    private String taskDescription;

    /**
     * 任务类型：是不是轮询任务：1，轮询；0表示轮询
     */
    private Integer taskType;

    /**
     * 此任务是否被删除：0：表示被删除
     */
    private Integer isExist;


}
