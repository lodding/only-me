package com.onle.me.mode;

import com.onle.me.constant.BaseConstant;

/**
 * @author Administrator
 */
public class ConcreteHandler2 implements HandelItf{
    private HandelItf nextHandler;

    @Override
    public void handleRequest(UserReq request) {
        if (request.getType().equals(BaseConstant.AppType.EDIT)) {
            System.out.println("ConcreteHandler2 is handling the request...");
            // 处理请求
        } else if (nextHandler != null) {
            // 无法处理，传递给下一个处理器
            nextHandler.handleRequest(request);
        }
    }

    public void setNextHandler(HandelItf nextHandler) {
        this.nextHandler = nextHandler;
    }


}
