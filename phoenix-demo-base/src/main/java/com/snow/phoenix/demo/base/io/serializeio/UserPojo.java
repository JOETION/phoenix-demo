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

package com.snow.phoenix.demo.base.io.serializeio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.Serializable;

public class UserPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    //名字
    private String name;

    //性别
    private String sex;

    //年龄
    private int age;

    //身高
    private String high;

    //体重
    private String weight;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getHigh() {
        return high;
    }

    public String getWeight() {
        return weight;
    }

    private Builder builder;

    public UserPojo(Builder builder) {
        this.name = builder.name;
        this.sex = builder.name;
        this.age = builder.age;
        this.high = builder.high;
        this.weight = builder.weight;
    }

    public static class Builder {
        //名字
        private String name;

        //性别
        private String sex;

        //年龄
        private int age;

        //身高
        private String high;

        //体重
        private String weight;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }


        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }


        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setHigh(String high) {
            this.high = high;
            return this;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public UserPojo build() {
            return new UserPojo(this);
        }
    }

}
