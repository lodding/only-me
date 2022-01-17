package com.me.only.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: only-me->Testinterceptor
 * @description:
 * @author: szh
 * @create: 2022-01-10 10:36
 **/
@RestController
@RequestMapping("/only")
@Api(value = "hello", description = "hello啊")
public class Testinterceptor {

    @GetMapping( "/hello")
    @ApiOperation(value = "hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
        String s = "hello";
        return s;
    }
}
