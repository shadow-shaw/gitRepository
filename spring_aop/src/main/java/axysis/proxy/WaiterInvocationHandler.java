package axysis.proxy;

import axysis.interfaces.Waiter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: spring
 * @description: 根据指定对象生成代理对象
 * @author: shaw
 * @create: 2020-07-15 09:21
 **/
public class WaiterInvocationHandler implements InvocationHandler {

    private Waiter waiter;

    public WaiterInvocationHandler(Waiter waiter){
        this.waiter = waiter;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("对象的前置增强方法");
        waiter.doService();
        System.out.println("对象的后置增强方法");
        return null;
    }
}

