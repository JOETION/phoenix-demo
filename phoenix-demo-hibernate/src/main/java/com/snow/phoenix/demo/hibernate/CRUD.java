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

package com.snow.phoenix.demo.hibernate;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/26          FXY        Created
 **********************************************
 */


import com.snow.phoenix.demo.hibernate.entity.*;
import com.snow.phoenix.demo.hibernate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;
import java.util.stream.Stream;

public class CRUD {

    //xml配置文件插入数据
    public static void insertByXml() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        //配置文件插入数据
        User user = new User();
        user.setUserName("fangxiaoyong");
        user.setUserPassword("123456");

        //注解插入数据
        Video video = new Video();
        video.setVideoName("test");
        video.setVideoType(3);

        session.save(user);
        session.save(video);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //注解插入数据
    public static void insertByAnnotation() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Comment comment = new Comment();
        comment.setUserId(111);
        comment.setVideoId(222);
        Comment.CommentBody commentBody = new Comment.CommentBody();
        commentBody.setBelow(333);
        commentBody.setCommentContent("hello world!!!");
        commentBody.setCommentTime(new Date());
        commentBody.setReply("you are welcome!!!");
        commentBody.setTop(CommentEnum.TOP2);
        comment.setCommentBody(commentBody);
        session.save(comment);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //级联插入
    public static void insertByCascade() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        Department department = new Department();
        department.setName("computer department");
        Set<Employee> employees = new HashSet<>();
        Employee employee = new Employee("fxy", department);
        Employee employee1 = new Employee("lxm", department);
        employees.add(employee);
        employees.add(employee1);
        department.setEmployees(employees);
        session.save(department);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //更新
    public static void update() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        session.load(user, 1);
        user.setUserName("liming");
        user.setUserPassword("123456");
        session.update(user);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //删除
    public static void delete() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        session.load(user, 12);
        session.delete(user);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //查询
    public static void queryAllByHql() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Video";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        List<User> users = query.list();

        Stream.of(users).forEach(user -> {
            System.out.println(user);
        });
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //查询指定列
    public static void queryColumnByHql() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s";  //HQL查询语句
        Query<Video> query = session.createQuery(hql);// 查询所有的Person
        List<Video> videos = query.list();

        videos.stream().forEach((video) -> {
            System.out.println(video);
        });

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }


    //查询指定列
    public static void queryColumnByHql1() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT s.videoName,s.videoType FROM Video s";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        List<Object[]> strings = query.list();

        strings.stream().forEach(
                (string) -> {
                    Stream.of(string).forEach(string1 -> {
                        System.out.println(string1);
                    });
                }
        );
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //带条件查询
    public static void queryWithConditionByHql() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s where s.id=?";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        query.setParameter(0, 2);
        List<Video> videos = query.list();

        videos.stream().forEach((video) -> {
            System.out.println(video);
        });

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }


    //带条件查询
    public static void queryWithConditionByHql1() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s where s.id=:id";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        query.setParameter("id", 2);
        List<Video> videos = query.list();

        videos.stream().forEach((video) -> {
            System.out.println(video);
        });

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //带条件查询
    public static void queryWithConditionByHql2() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s where s.id in (:ids)";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        query.setParameterList("ids", new Integer[]{2, 3});
        List<Video> videos = query.list();

        videos.stream().forEach((video) -> {
            System.out.println(video);
        });

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //查询唯一结果，如果有多个数据将抛出异常
    public static void queryOnlyOneWithConditionByHql2() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s where s.id in (:ids)";  //HQL查询语句
        Query query = session.createQuery(hql);// 查询所有的Person
        query.setParameterList("ids", new Integer[]{2});
        Video video = (Video) query.uniqueResult();

        System.out.println(video);

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }

    //设置分页查询
    public static void queryPage() {
        final int pageNo = 1;
        final int pageSize = 2;
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT new Video(s.videoName,s.videoType) FROM Video s";  //HQL查询语句
        Query<Video> query = session.createQuery(hql);// 查询所有的Person
        query.setFirstResult((pageNo - 1) * pageSize);//设置起始位置（索引位置是从0开始）
        query.setMaxResults(pageSize);//设置返回最大记录数
        List<Video> videos = query.list();

        videos.stream().forEach((video) -> {
            System.out.println(video);
        });

        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();
    }


}
