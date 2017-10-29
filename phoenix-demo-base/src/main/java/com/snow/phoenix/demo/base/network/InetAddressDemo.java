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

package com.snow.phoenix.demo.base.network;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/29          FXY        Created
 **********************************************
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress案例
 */
public class InetAddressDemo {

    //本地主机地址
    private static final String LOCALHOST_ADDRESS = "127.0.0.1";

    //百度链接
    private static final String BAIDU_URL = "www.baidu.com";

    //验证InetAddress
    public void verifyInetAddress() {
        try {
            // 获取本机地址信息
            InetAddress localIp = InetAddress.getLocalHost();
            System.out.println("localIp.getCanonicalHostName()= "
                    + localIp.getCanonicalHostName());
            System.out.println("localIp.getHostAddress()= "
                    + localIp.getHostAddress());
            System.out.println("localIp.getHostName()= "
                    + localIp.getHostName());
            System.out.println("localIp.toString()= " + localIp.toString());
            System.out.println("localIp.isReachable(5000)= "
                    + localIp.isReachable(5000));
            System.out.println("====================================");

            // 获取指定域名地址信息
            InetAddress baiduIp = InetAddress.getByName(BAIDU_URL);
            System.out.println("baiduIp.getCanonicalHostName()= "
                    + baiduIp.getCanonicalHostName());
            System.out.println("baiduIp.getHostAddress()= "
                    + baiduIp.getHostAddress());
            System.out.println("baiduIp.getHostName()= "
                    + baiduIp.getHostName());
            System.out.println("baiduIp.toString()= " + baiduIp.toString());
            System.out.println("baiduIp.isReachable(5000)= "
                    + baiduIp.isReachable(5000));
            System.out.println("====================================");

            // 获取指定原始IP地址信息
            // InetAddress ip = InetAddress
            // .getByAddress(new byte[] { 127, 0, 0, 1 });
            InetAddress ip = InetAddress.getByName(LOCALHOST_ADDRESS);
            System.out.println("ip.getCanonicalHostName()= "
                    + ip.getCanonicalHostName());
            System.out.println("ip.getHostAddress()= " + ip.getHostAddress());
            System.out.println("ip.getHostName()= " + ip.getHostName());
            System.out.println("ip.toString()= " + ip.toString());
            System.out.println("ip.isReachable(5000)= " + ip.isReachable(5000));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //主程序入口
    public static void main(String[] args) {

        new InetAddressDemo().verifyInetAddress();

    }
}
