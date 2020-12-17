package axysis.aop;


import axysis.aonnotation.DoneTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: spring
 * @description: 注解式切面,
 * @author: shaw
 * @create: 2020-07-15 14:49
 **/
@Aspect
@Component
public class DoneTimeAspect {

    /**
     * 基于注解的切面不需要使用@Pintcout注解来控制切面方法,因此@Around注解的参数是@annotation(doneTime)
     * 指的是如果切面方法被被@annotation注解标注了方法，那么该方法就会触发@Around注解标注的方法，
     * 同时通过doneTime传参
   * @param joinPoint
     * @param doneTime
     * @return
     * @throws Throwable
     */
    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        //这里是通过注解传参
        System.out.println("获取注解的参数："+doneTime.param());
        System.out.println("方法开始时间是:"+new Date());
        doneTime.param();
        Object o = joinPoint.proceed();//执行切面方法（就是业务方法），该方法的返回值就是业务逻辑方法的返回值
        System.out.println("方法结束时间是:"+new Date()) ;
        return o;
    }
}


