package axysis.test;


import axysis.entity.ManWaiter;
import axysis.interfaces.AfterAdvice;
import axysis.interfaces.BeforeAdvice;
import axysis.interfaces.Waiter;
import axysis.proxy.ProxyFactory;
import axysis.proxy.WaiterProxyFactory;

/**
 * @program: spring
 * @description: 代理测试
 * @author: shaw
 * @create: 2020-07-14 16:11
 **/
public class ProxyTest {

    public static void main(String[] args) {
        //直接生成接口的代理实现
        WaiterProxyFactory proxyFactory = new WaiterProxyFactory();
        Waiter waiter = proxyFactory.getWaiter();
        waiter.doService();

        //创建一个指定类的对象，然后对指定对象进行增强
        Waiter manWaiter = new ManWaiter();
        Waiter proxyWaiter = proxyFactory.getStrongerWaiterByObject(manWaiter);
        proxyWaiter.doService();

        ProxyFactory factory = new ProxyFactory();//创建工厂

        factory.setTargetObject(new ManWaiter());//设置目标对象
        //设置前置增强
        factory.setBeforeAdvice(new BeforeAdvice() {
            @Override
            public void before() {
                System.out.println("客户你好");
            }
        });
        //设置后置增强
        factory.setAfterAdvice(new AfterAdvice() {
            @Override
            public void after() {
                System.out.println("客户再见");
            }
        });
        Waiter manWaiterProxy = (Waiter) factory.creatProxy();
        manWaiterProxy.doService();
    }
}

