package com.me.only.service.impl;

import com.me.only.repository.entity.RoleInfoEntity;
import com.me.only.repository.mapper.RoleInfoMapper;
import com.me.only.service.RoleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色基本信息表 服务实现类
 * </p>
 *
 * @author 秋名山小佩奇
 * @since 2023-03-28
 */
@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfoEntity> implements RoleInfoService {

}
