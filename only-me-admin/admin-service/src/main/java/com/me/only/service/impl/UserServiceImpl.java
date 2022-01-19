package com.me.only.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.only.repository.entity.User;
import com.me.only.repository.mapper.UserMapper;
import com.me.only.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: only-me->UserServiceImpl
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:09
 **/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
}
