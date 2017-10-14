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

package com.snow.phoenix.demo.safe.token;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/14          FXY        Created
 **********************************************
 */


/**
 * 载荷：
 * <p>
 * <p>
 * { "iss": "Online JWT Builder",
 * "iat": 1416797419,
 * "exp": 1448333419,
 * "aud": "www.example.com",
 * "sub": "jrocket@example.com",
 * "GivenName": "Johnny",
 * "Surname": "Rocket",
 * "Email": "jrocket@example.com",
 * "Role": [ "Manager", "Project Administrator" ]
 * }
 * <p>
 * <p>
 * 头部：
 * {
 * "typ": "JWT",
 * "alg": "HS256"
 * }
 */
public class Main {

    private static final String ID = "123";
    private static final String ISSUER = "fxy";
    private static final String SUBJECT = "test";
    private static final long TTMILLIS = 123456789;

    public static void main(String args[]) {

        System.out.println("..........开始jwt编码........");
        String jwt = EncodeJwtUtils.createJWT(ID, ISSUER, SUBJECT, TTMILLIS);
        System.out.println(jwt);
        System.out.println("..........jwt编码完成........");

        System.out.println("..........开始jwt解码.........");
        DecodeJwtUtils.parseJWT(jwt);
        System.out.println("..........jwt解码完成.........");

    }

}
