package axysis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @program: spring
 * @description: 日志切面，这种切面通过@Pointcut来配置切点方法，与注解式切面不同
 * @author: shaw
 * @create: 2020-07-15 11:17
 **/
//日志切面类
@Aspect//说明该类是一个切面类
@Component
public class LogAspect {

    /**
     * 该方法的实质作用是配置切面方法,这样的方法可以有多个
     */
    @Pointcut("execution(public * axysis.controller.*.*(..))")
    public void LogAspect(){
        System.out.println("这个方法是干啥用的？？？？");
    }

    //joinPoint中包含类类名，被切面的方法名，以及参数
    @Before("LogAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("doBefore");
    }

    @After("LogAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    @AfterReturning("LogAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("doAfterReturning");
    }

    @AfterThrowing("LogAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){
        System.out.println("deAfterThrowing");
    }

    @Around("LogAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        return joinPoint.proceed();
    }
}




