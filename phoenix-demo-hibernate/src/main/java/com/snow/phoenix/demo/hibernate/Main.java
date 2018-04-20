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
 *    2018/4/17          FXY        Created
 **********************************************
 */

import com.snow.phoenix.demo.hibernate.entity.Comment;
import com.snow.phoenix.demo.hibernate.entity.CommentEnum;
import com.snow.phoenix.demo.hibernate.entity.User;
import com.snow.phoenix.demo.hibernate.entity.Video;
import com.snow.phoenix.demo.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * 程序入口
 */
public class Main {


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String args[]) {

        Session session = HibernateUtils.getSession();

        //配置文件插入数据
        User user = new User();
        user.setUserName("fangxiaoyong");
        user.setUserPassword("123456");

        //注解插入数据
        Video video = new Video();
        video.setVideoName("test");
        video.setVideoType(3);

        //插入事务
      /*  Transaction transaction = session.beginTransaction();
        session.save(user);
        session.save(video);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();*/

        //更新事务
      /*  Transaction transaction = session.beginTransaction();
        session.load(user,1);
        user.setUserName("liming");
        user.setUserPassword("123456");
        session.update(user);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();*/

        //删除事务
   /*     Transaction transaction = session.beginTransaction();
        session.load(user,12);
        session.delete(user);
        transaction.commit();
        HibernateUtils.closeSession(session);
        HibernateUtils.close();*/

        //测试注解
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

}
