package com.onle.me.mode;

import org.omg.CORBA.Request;

/**
 * 责任链
 * @author Administrator
 */
public interface HandelItf {

    /**
     * 处理请求
     * @param request
     */
    void handleRequest(UserReq request);
}
