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
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


/**
 * SocketChannel案列
 * 参考网址：<br/>
 * <a>http://blog.csdn.net/wenhuayuzhihui/article/details/51900204</a>
 */
public class SocketChannelThread implements Runnable {

    private SocketChannel socketChannel;
    private String remoteName;

    public SocketChannelThread(SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        this.remoteName = socketChannel.getRemoteAddress().toString();
        System.out.println("客户:" + remoteName + " 连接成功!");
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteBuffer sizeBuffer = ByteBuffer.allocate(4);
        StringBuilder sb = new StringBuilder();
        byte b[];
        while (true) {
            try {
                sizeBuffer.clear();
                int read = socketChannel.read(sizeBuffer);
                if (read != -1) {
                    sb.setLength(0);
                    sizeBuffer.flip();
                    //can access Integer.SIZE get a byte num
                    int size = sizeBuffer.getInt();
                    int readCount = 0;
                    b = new byte[1024];
                    //读取已知长度消息内容
                    while (readCount < size) {
                        buffer.clear();
                        //read()方法是一次性读取进buffer里面的，当buffer装满后就会返回，然后取出里面的数据后，又会继续往里面装
                        read = socketChannel.read(buffer);
                        if (read != -1) {
                            readCount += read;
                            buffer.flip();
                            int index = 0;
                            while (buffer.hasRemaining()) {
                                b[index++] = buffer.get();
                                if (index >= b.length) {
                                    index = 0;
                                    sb.append(new String(b, "UTF-8"));
                                }
                            }
                            if (index > 0) {
                                sb.append(new String(b, "UTF-8"));
                            }
                        }
                    }
                    System.out.println(remoteName + ":" + sb.toString());
                }
            } catch (Exception e) {
                System.out.println(remoteName + " 断线了,连接关闭");
                try {
                    socketChannel.close();
                } catch (IOException ex) {
                }
                break;
            }
        }
    }

}
