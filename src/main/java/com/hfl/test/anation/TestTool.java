package com.hfl.test.anation;

import java.lang.reflect.Method;

/**
 * Created by hfl on 2017-5-23.
 */
public class TestTool {

    public static void main(String[] args) {
        //①得到ForumService对应的Class对象
        Class clazz = ForumService.class;
        //②得到ForumSerivce对应的Method数组
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method : methods){
            NeedTest nt = method.getAnnotation(NeedTest. class);
            if(null!=nt){
                if(nt.value()){
                    System.out.println(method.getName()+"()====需要测试");
                }else{
                    System.out.println(method.getName()+"()====不需要测试");
                }
            }
        }
    }
}
