package com.me.only.service.impl;

import com.me.only.repository.entity.UserRoleRelEntity;
import com.me.only.repository.mapper.UserRoleRelMapper;
import com.me.only.service.UserRoleRelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员角色关联表 服务实现类
 * </p>
 *
 * @author 秋名山小佩奇
 * @since 2023-03-28
 */
@Service
public class UserRoleRelServiceImpl extends ServiceImpl<UserRoleRelMapper, UserRoleRelEntity> implements UserRoleRelService {

}
