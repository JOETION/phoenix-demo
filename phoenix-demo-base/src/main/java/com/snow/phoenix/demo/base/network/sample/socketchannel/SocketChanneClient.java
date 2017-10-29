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
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * SocketChannel客户端案列
 * 参考网址：<br/>
 * <a>http://blog.csdn.net/wenhuayuzhihui/article/details/51900204</a>
 */
public class SocketChanneClient {
    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(1234));
        while (true) {
            Scanner sc = new Scanner(System.in);
            String next = sc.next();
            sendMessage(socketChannel, next);
        }
    }

    public static void sendMessage(SocketChannel socketChannel, String mes) throws IOException {
        if (mes == null || mes.isEmpty()) {
            return;
        }
        byte[] bytes = mes.getBytes("UTF-8");
        int size = bytes.length;
        ByteBuffer buffer = ByteBuffer.allocate(size);
        ByteBuffer sizeBuffer = ByteBuffer.allocate(4);

        sizeBuffer.putInt(size);
        buffer.put(bytes);

        buffer.flip();
        sizeBuffer.flip();
        ByteBuffer dest[] = {sizeBuffer, buffer};
        while (sizeBuffer.hasRemaining() || buffer.hasRemaining()) {
            socketChannel.write(dest);
        }
    }
}
