package axysis.proxy;

import axysis.interfaces.Waiter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spring
 * @description: 根据waiter接口生成代理对象,使用Poxy的newProxyInstance方法只能为接口生成代理对象
 *  无法为类生成代理对象。
 * @author: shaw
 * @create: 2020-07-14 16:16
 **/
public class WaiterProxyFactory {

    /**
     * 根据接口生成接口的代理对象
     * @return
     */
    public Waiter getWaiter() {

        InvocationHandler handler = new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //在此处增强Waiter,
                System.out.println("hello");
                System.out.println(proxy instanceof Waiter);
                System.out.println(method.getName());
                return null;
            }
        };
        //newProxyInstance方法由三个参数，第一个参数是类加载器，第二个参数是代理的接口的字节码对象，注意这里不能是类因为这是接口的动态代理
        //第三个参是增强代理对象的处理器，在处理器的invoke方法中写增强代理对象的逻辑
        Waiter waiter = (Waiter) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Waiter.class}, handler);
        return waiter;
    }

    /**
     * 传入一个对象，返回一个对该对象加强的代理对象
     * @return
     */
    public Waiter getStrongerWaiterByObject( Waiter waiter){

        Waiter proxyWaiter = (Waiter) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Waiter.class}, new WaiterInvocationHandler(waiter));
        return proxyWaiter;
    }
}

