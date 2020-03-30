package com.pet.home.service;

import com.pet.common.entity.PetComment;
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
public interface IPetCommentService extends IService<PetComment> {
    ResultInfo addComment(PetComment petComment);
    ResultInfo getComment(String rpId,Integer pageStart,Integer pageEnd);
}
