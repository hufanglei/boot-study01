package com.hfl.test.cglibProxy;

import com.hfl.test.jdkProxy.ForumService;
import com.hfl.test.jdkProxy.ForumServiceImpl;

/**
 * Created by hfl on 2017-5-23.
 */
public class TestForumService {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumService forumService = (ForumService) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
