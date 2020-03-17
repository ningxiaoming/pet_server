package com.pet.user.service.impl;

import com.pet.common.entity.PetUser;
import com.pet.user.mapper.PetUserMapper;
import com.pet.user.service.IPetUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xmn
 * @since 2020-03-14
 */
@Service
public class PetUserServiceImpl extends ServiceImpl<PetUserMapper, PetUser> implements IPetUserService {

}
