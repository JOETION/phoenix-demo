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

package com.snow.phoenix.demo.base.io.chario;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/22          FXY        Created
 **********************************************
 */

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 管道字符流案列
 * <p>
 * 主要用于线程之间交换流数据
 */
public class PipeDemo {

    public static void main(String args[]) {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //一定要连接输入输出流，不然肯定会抛异常
        try {
            out.connect(in);
            Thread printThread = new Thread(new Print(in),"打印线程");
            printThread.start();
            int receive = 0;
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } catch (IOException e) {
            System.out.println("输出流和输入流连接异常");
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("关闭管道流发送异常");
            }
        }
    }

    static class Print implements Runnable {

        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                System.out.println("从输入流中读取数据发生异常");
            }
        }
    }
}
