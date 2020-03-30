package com.pet.home.service;

import com.pet.common.entity.PetReplyLike;
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
public interface IPetReplyLikeService extends IService<PetReplyLike> {
    ResultInfo addReplyLike(PetReplyLike petReplyLike);
    ResultInfo delReplyLike(PetReplyLike petReplyLike);
    ResultInfo getReplyLike(PetReplyLike petReplyLike);
    boolean getRLByRpIdAndUserId(String rpId,String userId);

}
