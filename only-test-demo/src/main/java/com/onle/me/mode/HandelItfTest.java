package com.onle.me.mode;

import com.onle.me.constant.BaseConstant;

/**
 * @author Administrator
 */
public class HandelItfTest {
    public static void main(String[] args) {
        HandelItf handelItf = new ConcreteHandler1();
        HandelItf handelItf2 = new ConcreteHandler2();

        UserReq userReq = new UserReq();
        userReq.setType(BaseConstant.AppType.ADD);
        handelItf.handleRequest(userReq);
        userReq.setType(BaseConstant.AppType.EDIT);
        handelItf2.handleRequest(userReq);
    }

}
