package axysis.proxy;

import axysis.interfaces.AfterAdvice;
import axysis.interfaces.BeforeAdvice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: spring
 * @description: 一个完整的代理共工厂的实现
 * @author: shaw
 * @create: 2020-07-14 16:16
 **/

/**
 * 步骤：
 * 1、创建代理工厂
 * 2、给工厂设置目标对象、前置增强、后置增强
 * 3、调用creatProxy()得到代理对象
 * 4、执行代理对象方法时，先执行前置增强，然后是目标方法，最后是后置增强
 */
//其实在Spring中的AOP的动态代理实现的一个织入器也是叫做ProxyFactory

public class ProxyFactory {

    private Object targetObject;//目标对象
    private BeforeAdvice beforeAdvice;//前值增强
    private AfterAdvice afterAdvice;//后置增强

    /**
     * 用来生成代理对象
     * @return
     */
    public Object creatProxy() {
        /**
         * 给出三个参数
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        //获取当前类型所实现的所有接口类型
        Class[] interfaces = targetObject.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 在调用代理对象的方法时，会执行这里的内容
                 */
                if(beforeAdvice != null) {
                    beforeAdvice.before();
                }
                Object result = method.invoke(targetObject, args);//调用目标对象的目标方法
                //执行后续增强
                afterAdvice.after();

                //返回目标对象的返回值
                return result;
            }
        };

         //2、得到代理对象
        Object proxyObject = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxyObject;

    }


    public Object getTargetObject() {
        return targetObject;
    }

    public BeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public AfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public void setAfterAdvice(AfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
