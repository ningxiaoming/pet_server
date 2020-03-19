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
 * @since 2020-03-18
 */
@Data
@Accessors(chain = true)
public class PetTask {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    @TableId(value = "task_id")
    private String taskId;
    private String userId;
    /**
     * 任务执行时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd %H:%i:%S")
    @JsonFormat(pattern = "yyyy-MM-dd %H:%i:%S",timezone = "GMT+8")
    private LocalDateTime taskTime;

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
