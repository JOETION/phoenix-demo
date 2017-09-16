/*
 *  Copyright 2016-2020 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       QQ:1322874562  PHONE:13882946572
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.snow.phoenix.demo.spring.aop;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/5          FXY        Created
 **********************************************
 */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 方法调用切面案列
 * 主要用于打印调用日志
 */
@Aspect
@Component
public class MethodInvokeAspectjDemo {


    /**
     * 切点
     */
    @Pointcut("execution(public * com.snow.phoenix.demo.spring.aop.sample.Verify*.*(..))")
    public void pointCut() {
        System.err.println("命中切点了");
    }


    /**
     * 方法调用前切面
     *
     * @param joinPoint 切点参数
     */
    @Before("pointCut()")
    public void callBefore(JoinPoint joinPoint) {
        System.err.println("进入方法调用前切面");
        System.out.println("开始调用方法：" + joinPoint.getSignature().getName());
        System.out.println("方法包名：" + joinPoint.getSignature().getDeclaringType().getName());
        System.out.println("方法参数：" + joinPoint.getArgs()[0] + "," + joinPoint.getArgs()[1]);
    }


    /**
     * 方法调用后切面
     *
     * @param joinPoint 切点参数
     * @param o         返回值
     */
    @AfterReturning(pointcut = "pointCut()", returning = "o")
    public void afterReturning(JoinPoint joinPoint, Object o) {
        System.err.println("进入方法调用后切面");
        System.out.println("返回值：" + o.toString());

    }


    /**
     * 方法抛出异常后切面
     *
     * @param jp    切点参数
     * @param error 异常
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint jp, Throwable error) {
        System.err.println("进入方法抛出异常后切面");
        System.out.println("error：" + error.getMessage());
    }

}
