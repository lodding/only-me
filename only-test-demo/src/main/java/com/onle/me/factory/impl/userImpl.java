package com.onle.me.factory.impl;

import com.onle.me.factory.User;

public class userImpl {
    public static class WeChatUser implements User {
        @Override
        public void createUser() {
            // 微信用户创建逻辑
            System.out.println("正在创建微信用户...");
        }
    }

    public static class QQUser implements User {
        @Override
        public void createUser() {
            // QQ用户创建逻辑
            System.out.println("正在创建QQ用户...");
        }
    }

    public static class WeiboUser implements User {
        @Override
        public void createUser() {
            // 微博用户创建逻辑
            System.out.println("正在创建微博用户...");
        }
    }


}

