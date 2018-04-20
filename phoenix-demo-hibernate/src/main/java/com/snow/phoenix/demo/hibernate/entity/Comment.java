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

package com.snow.phoenix.demo.hibernate.entity;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/4/20          FXY        Created
 **********************************************
 */


import javax.persistence.*;
import java.util.Date;

//评论实体

/**
 * 涉及注解：
 *
 * @Transient
 * @Temporal
 * @Enumerated
 * @Column
 * @Embedded
 * @Embeddable
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "video_id")
    private int videoId;

    @Embedded
    private CommentBody commentBody;

    public CommentBody getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(CommentBody commentBody) {
        this.commentBody = commentBody;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    @Embeddable
    public static class CommentBody {

        @Column(name = "comment_content")
        private String commentContent;

        @Enumerated(value = EnumType.ORDINAL)
        @Column(name = "top")
        private CommentEnum top;

        @Column(name = "below")
        private int below;

        //不序列化，不存进数据库
        @Transient
        @Column(name = "reply")
        private String reply;

        //对Date数据进行映射
        @Temporal(value = TemporalType.DATE)
        @Column(name = "comment_time")
        private Date commentTime;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public CommentEnum getTop() {
            return top;
        }

        public void setTop(CommentEnum top) {
            this.top = top;
        }

        public int getBelow() {
            return below;
        }

        public void setBelow(int below) {
            this.below = below;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public Date getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(Date commentTime) {
            this.commentTime = commentTime;
        }
    }

}
