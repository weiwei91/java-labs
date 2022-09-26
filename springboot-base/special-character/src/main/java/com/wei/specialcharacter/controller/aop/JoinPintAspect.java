package com.wei.specialcharacter.controller.aop;

import com.alibaba.fastjson.JSONObject;
import com.wei.specialcharacter.common.IdempotentConstant;
import com.wei.weitoolsspringbootstarter.annotation.PreventDuplication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/***
 *
 * createTime : 2022/9/26 11:51
 * author     : 魏伟
 * describe   : 学习JoinPoint对象
 *
 ***/

@Aspect
@Component
public class JoinPintAspect {



    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.wei.*.controller..*Controller.*(..))")
    public void preventDuplication() {
    }

    /**
     * 环绕通知 （可以控制目标方法前中后期执行操作）
     *
     * @param joinPoint
     * @return
     */
    @Around("preventDuplication()")
    public void before(ProceedingJoinPoint joinPoint) throws Exception {
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
    }
}
