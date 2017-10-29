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

package com.snow.phoenix.demo.base.network.sample.socketchannel;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/10/29          FXY        Created
 **********************************************
 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * SocketChannel服务器案列
 * 参考网址：<br/>
 * <a>http://blog.csdn.net/wenhuayuzhihui/article/details/51900204</a>
 */
public class ServerSocketChannelServer {

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(100));

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(1234));

        while (true) {
            //accept()是阻塞函数
            SocketChannel socketChannel = serverSocketChannel.accept();
            //每个连接使用一个单独线程处理
            if (socketChannel != null) {
                executor.submit(new SocketChannelThread(socketChannel));
            }
        }
    }
}
