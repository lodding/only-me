package com.me.only.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @program: only-me->User
 * @description:
 * @author: szh
 * @create: 2022-01-11 09:05
 **/
@Data
@Accessors(chain = true)
@EqualsAndHashCode()
@TableName("admin_user")
public class User {

    @ApiModelProperty(value = "主键")
    private Long id;

    private String name;

    private Integer age;
}
