package com.me.only.controller;


import com.me.only.repository.entity.UserInfoEntity;
import only.me.common.util.excelUtil.ExcelUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.List;

/**
 * <p>
 * 角色基本信息表 前端控制器
 * </p>
 *
 * @author 秋名山小佩奇
 * @since 2023-03-28
 */
@RestController
@RequestMapping("/role-info")
public class RoleInfoController {

    public void  excelTest(@RequestBody MultipartFile field){

        List<UserInfoEntity> userInfoEntities = ExcelUtil.readExcel(field, UserInfoEntity.class);

    }

}

