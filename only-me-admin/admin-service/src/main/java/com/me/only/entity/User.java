package com.me.only.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: only-me->User
 * @description:
 * @author: szh
 * @create: 2022-01-11 09:05
 **/
@Data
@ApiModel("用户啊")
public class User {

    @ApiModelProperty(value = "主键")
    private Long id;

    private String name;

    private Integer age;
}
