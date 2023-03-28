package com.me.only.service.impl;

import com.me.only.repository.entity.UserInfoEntity;
import com.me.only.repository.mapper.UserInfoMapper;
import com.me.only.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员基本信息表 服务实现类
 * </p>
 *
 * @author 秋名山小佩奇
 * @since 2023-03-28
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements UserInfoService {

}
