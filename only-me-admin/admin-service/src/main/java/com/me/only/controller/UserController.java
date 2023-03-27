package com.me.only.controller;

import com.me.only.repository.entity.User;
import com.me.only.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import only.me.common.bo.Result;
import only.me.common.util.ResultUtil;
import only.me.common.util.excelUtil.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: only-me->UserController
 * @description:
 * @author: szh
 * @create: 2022-01-18 09:25
 **/
@RestController
@RequestMapping("user")
@Api(value = "人员管理", description = "人员管理")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    @ApiOperation("获取用户")
    public Result<User> getById(@PathVariable("id")Long id){
        return ResultUtil.OK(userService.getById(id));
    }

    @PostMapping("/test1")
    public Result<User> excelTest(MultipartFile file){
        List<User> users = ExcelUtil.readExcel(file, User.class);

        return ResultUtil.OK();
    }

}
