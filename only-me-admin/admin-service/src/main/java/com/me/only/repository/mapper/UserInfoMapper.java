package com.me.only.repository.mapper;

import com.me.only.repository.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 人员基本信息表 Mapper 接口
 * </p>
 *
 * @author 秋名山小佩奇
 * @since 2023-03-28
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

}
