package com.pet.home.config.swagger;

import com.pet.home.service.IPetQuestionService;
import com.pet.home.service.IPetReplyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 点赞的定时任务
 */
@Slf4j
public class PetTask extends QuartzJobBean {

    @Autowired
    private IPetQuestionService petQuestionService;
    @Autowired
    private IPetReplyService petReplyService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("LikeTask-------- {}", sdf.format(new Date()));

        //将 Redis 里的问题信息同步到数据库里
//        petQuestionService.transQuestionFromRedis2DB();
        //将 Redis 里的回答信息同步到数据库里
//        likedService.transLikedCountFromRedis2DB();
    }
}