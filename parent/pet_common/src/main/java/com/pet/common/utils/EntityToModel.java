package com.pet.common.utils;

import com.pet.common.entity.PetComment;
import com.pet.common.entity.PetQuestion;
import com.pet.common.entity.PetReply;
import com.pet.common.model.PetCommentModel;
import com.pet.common.model.PetQuestionModel;
import com.pet.common.model.PetReplyModel;

public class EntityToModel {

    public static void petQuestionToPetQuestionModel(PetQuestion petQuestion, PetQuestionModel petQuestionModel){
        petQuestionModel.setQtId(petQuestion.getQtId());
        petQuestionModel.setUserId(petQuestion.getUserId());
        petQuestionModel.setQtItem(petQuestion.getQtItem());
        petQuestionModel.setCreateTime(PetUtil.currentTimeMillisToDateString(petQuestion.getCreateTime()));
        petQuestionModel.setQtStatus(petQuestion.getQtStatus());
        petQuestionModel.setQtType(petQuestion.getQtType());
        petQuestionModel.setReplyCount(petQuestion.getReplyCount());
        petQuestionModel.setUserImage(petQuestion.getUserImage());
        petQuestionModel.setUserName(petQuestion.getUserName());
    }

    public static void petReplyToPetReplyModel(PetReply petReply,PetReplyModel petReplyModel){
        petReplyModel.setRpId(petReply.getRpId());
        petReplyModel.setRpItem(petReply.getRpItem());
        petReplyModel.setQtId(petReply.getQtId());
        petReplyModel.setCommentCount(petReply.getCommentCount());
        petReplyModel.setLikeCount(petReply.getLikeCount());
        petReplyModel.setLkStatus(petReply.getLkStatus());
        petReplyModel.setCreateTime(PetUtil.currentTimeMillisToDateString(petReply.getCreateTime()));
        petReplyModel.setUserId(petReply.getUserId());
        petReplyModel.setUserName(petReply.getUserName());
        petReplyModel.setUserImage(petReply.getUserImage());
        petReplyModel.setUpTime(PetUtil.currentTimeMillisToDateString(petReply.getUpTime()));
    }
    public static PetCommentModel petCommentToPetCommentModel(PetComment petComment, PetCommentModel petCommentModel1){
        PetCommentModel petCommentModel = new PetCommentModel();
        petCommentModel.setCmId(petComment.getCmId());
        petCommentModel.setQtId(petComment.getQtId());
        petCommentModel.setCmItem(petComment.getCmItem());
        petCommentModel.setCmParentId(petComment.getCmParentId());
        petCommentModel.setCmStatus(petComment.getCmStatus());
        petCommentModel.setCreateTime(PetUtil.currentTimeMillisToDateString(petComment.getCreateTime()));
        petCommentModel.setRpId(petComment.getRpId());
        petCommentModel.setUserId(petComment.getUserId());
        petCommentModel.setUserName(petComment.getUserName());
        petCommentModel.setUserImage(petComment.getUserImage());
        return petCommentModel;
    }


}
