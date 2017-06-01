package com.hfl.test.cglibProxy;


import com.hfl.test.jdkProxy.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *使用JDK创建代理有一个限制，即它只能为接口创建代理实例，这一点我们可从Proxy的接口newProxyInstance(ClassLoader loader, Class[] interfaces,
 *  InvocationHandler h)的方法签名中就看得很清楚：第二个入参interfaces就是需要代理实例实现的接口列表。虽然面向接口编程的思想被很多大师级人物
 *  （包括Rod Johnson）推崇，但在实际开发中，许多开发者也对此深感困惑：难道对一个简单业务表的操作也需要老老实实地创建5个类（领域对象类、Dao接口，Dao实现类，
 *  Service接口和Service实现类）吗？难道不能直接通过实现类构建程序吗？对于这个问题，我们很难给出一个孰好孰劣的准确判断，
 *  但我们确实发现有很多不使用接口的项目也取得了非常好的效果（包括大家所熟悉的SpringSide开源项目）。

 对于没有通过接口定义业务方法的类，如何动态创建代理实例呢？JDK的代理技术显然已经黔驴技穷，CGLib作为一个替代者，填补了这个空缺。

 CGLib采用非常底层的字节码技术，可以为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，并顺势织入横切逻辑。
 下面，我们采用CGLib技术，编写一个可以为任何类创建织入性能监视横切逻辑代理对象的代理创建器
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new  Enhancer();

    public  Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);  //① 设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create();  //②通过字节码技术动态创建子类实例
    }

    //③拦截父类所有方法的调用
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName()+"."+method. getName());    //③-1
        Object result = proxy.invokeSuper(o, args); //  ③-2
        PerformanceMonitor.end();    //③-1通过代理类调用父类中的方法
        return result;
    }
}
