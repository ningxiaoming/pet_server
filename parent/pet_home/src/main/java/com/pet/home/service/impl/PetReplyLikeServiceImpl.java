package com.pet.home.service.impl;

import com.pet.common.entity.PetReplyLike;
import com.pet.common.model.IdWorker;
import com.pet.common.model.ResultInfo;
import com.pet.home.mapper.PetReplyLikeMapper;
import com.pet.home.service.IPetReplyLikeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-20
 */
@Service
public class PetReplyLikeServiceImpl extends ServiceImpl<PetReplyLikeMapper, PetReplyLike> implements IPetReplyLikeService {

    @Autowired
    private PetReplyLikeMapper petReplyLikeMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private String replyLike = "replyLikeKey";

    @Override
    public boolean getRLByRpIdAndUserId(String rpId, String userId) {
        boolean flag = false;
        if (StringUtils.isBlank(userId)){
            return false;
        }
        List<Object> range = redisTemplate.opsForList().range(rpId + replyLike, 0, -1);
        for (int i = 0; i < range.size(); i++) {
            PetReplyLike petReplyLike1 = (PetReplyLike) range.get(i);
            if (rpId.equals(petReplyLike1.getRpId())&&userId.equals(petReplyLike1.getLkUserId())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public ResultInfo getReplyLike(PetReplyLike petReplyLike) {
        int flag = 0;
        if (getRLByRpIdAndUserId(petReplyLike.getRpId(),petReplyLike.getLkUserId())){
            flag = 1;
        }
        return ResultInfo.success(200,"查询成功：1:点赞；0：没有点赞",flag);
    }

    @Override
    public ResultInfo addReplyLike(PetReplyLike petReplyLike) {
        if (StringUtils.isBlank(petReplyLike.getRpId())){
            return ResultInfo.failure(500,"rpType");
        }
        IdWorker idWorker = new IdWorker(1,1,1);
        String id = String.valueOf(idWorker.nextId());
        petReplyLike.setLkId(id);
        petReplyLike.setLkStatus(true);
        petReplyLike.setCreateTime(System.currentTimeMillis());
        petReplyLike.setUpTime(System.currentTimeMillis());
        redisTemplate.opsForList().leftPush(petReplyLike.getRpId()+replyLike,petReplyLike);
        return ResultInfo.success(200,"点赞成功",petReplyLike);
    }

    @Override
    public ResultInfo delReplyLike(PetReplyLike petReplyLike) {
        if (StringUtils.isBlank(petReplyLike.getLkId())){
            return ResultInfo.success(500,"lkId为空了");
        }
        List<Object> range = redisTemplate.opsForList().range(petReplyLike.getRpId() + replyLike, 0, -1);
        assert range != null;
        for (int i = 0; i < range.size(); i++) {
            PetReplyLike petReplyLike1 = (PetReplyLike) range.get(i);
            if (petReplyLike.getLkId().equals(petReplyLike1.getLkId())){
                redisTemplate.opsForList().remove(petReplyLike.getRpId() + replyLike,i,petReplyLike1);
                break;
            }
        }
        return ResultInfo.success(200,"取消点赞成功",petReplyLike);
    }
}
