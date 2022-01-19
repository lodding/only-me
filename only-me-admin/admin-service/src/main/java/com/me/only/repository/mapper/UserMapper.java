package com.me.only.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.only.repository.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: only-me->UserMapper
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:01
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
