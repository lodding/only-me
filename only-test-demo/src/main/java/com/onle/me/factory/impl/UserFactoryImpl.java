package com.onle.me.factory.impl;

import com.onle.me.factory.User;
import com.onle.me.factory.UserFactory;

public class UserFactoryImpl {
    public class WeChatUserFactory implements UserFactory {
        @Override
        public User createUser() {
            return new userImpl.WeChatUser();
        }
    }

    public class QQUserFactory implements UserFactory {
        @Override
        public User createUser() {
            return new userImpl.QQUser();
        }
    }

    public class WeiboUserFactory implements UserFactory {
        @Override
        public User createUser() {
            return new userImpl.WeiboUser();
        }
    }

}
