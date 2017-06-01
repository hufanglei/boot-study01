package com.hfl.test.reflact;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by hfl on 2017-5-23.
 */
public class Test {

    public static void test() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //采用构造方法
        Car car = new Car();
        car.setBrand("红旗");
        Car car1 = new Car("奇瑞","红",545);
        //使用反射
        //通过类加载器获取Car对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.hfl.test.Car");

        //获取类的默认构造方法并实例化对象
        Constructor cons = clazz.getDeclaredConstructor(null);
        Car car2 = (Car) cons.newInstance();

        //通过反射方法设置属性
        Method setBand = clazz.getMethod("setBrand",String.class);
        setBand.invoke(car2, "红旗zz");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car2,"白色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car2, 515);

        car2.introduce();

    }

    public static void test2(){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("parent loader:"+loader.getParent());
        System.out.println("grandparent loader:"+loader.getParent(). getParent());
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //test();
        test2();
    }
}
