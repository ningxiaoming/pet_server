package com.pet.home.mapper;

import com.pet.common.entity.PetReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Repository
public interface PetReplyMapper extends BaseMapper<PetReply> {

    int transReplyFromRedis2DB(List<PetReply> list);

}
