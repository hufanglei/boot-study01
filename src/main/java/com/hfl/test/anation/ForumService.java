package com.hfl.test.anation;

/**
 * Created by hfl on 2017-5-23.
 */
public class ForumService {

    @NeedTest(false)
    public void deleteForum(int forumId){
        System.out.println("删除论坛模块："+forumId);
    }

    @NeedTest(value=true)
    public void deleteTopic(int postId){
        System.out.println("删除论坛主题："+postId);
    }

}
