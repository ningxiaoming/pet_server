package com.pet.home.service;

import com.pet.common.entity.PetReply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.common.model.ResultInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
public interface IPetReplyService extends IService<PetReply> {

    ResultInfo addReply(PetReply petReply);
    ResultInfo getReply(String userId,String qtId,Integer pageNo,Integer pageNum);
    boolean delReplyByQtId(String qtId);
    void transReplyFromRedis2DB(String qtId);

}
