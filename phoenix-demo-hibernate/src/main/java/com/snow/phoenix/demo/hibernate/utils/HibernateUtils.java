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

package com.snow.phoenix.demo.hibernate.utils;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/17          FXY        Created
 **********************************************
 */


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.annotation.Resource;

/**
 * hibernate工具类
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private HibernateUtils() {
    }


    /**
     * 读取配置文件
     */
    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    /**
     * 获取数据库Session对象
     */
    public static Session getSession() {
        //如果当前线程有session则返回该session
        //如果没有则创建，且自动关闭session，必须要代码中显式关闭session
        return sessionFactory.getCurrentSession();
    }


    /***
     * 关闭传入的数据库Session对象
     */
    public static void closeSession(Session session) {
        if (session != null && session.isOpen())
            session.close();
    }

    /**
     * 关闭整个hibernate的sessionFactory
     */
    public static void close() {
        if (sessionFactory != null && sessionFactory.isOpen())
            sessionFactory.close();
    }
}