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

package com.snow.phoenix.demo.base.io.filterio;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;

/**
 *
 */
public class LineNumberInputStreamDemo {

    private static final String FILE_PATH = "E://linux.txt";

    public static void main(String[] args) throws IOException {

        LineNumberInputStream lnis = null;
        FileInputStream fis = null;
        int i, j;
        char c;

        try {
            // create new input streams
            fis = new FileInputStream(FILE_PATH);
            lnis = new LineNumberInputStream(fis);

            // reads till the end of the stream
            //read方法，每次只会读取一个字符
            while ((i = lnis.read()) != -1) {
                // converts int to char
                c = (char) i;

                // if the character is not new line
                if (i != 10) //整形的10转换为char类型就是换行符，排除掉
                {
                    // prints char
                    System.out.print("Character read: " + c);

                    // get the line number
                    j = lnis.getLineNumber();
                    System.out.println(" at line: " + j);
                }
            }
        } catch (Exception e) {

            // if any error occurs
            e.printStackTrace();
        } finally {

            // closes the stream and releases any system resources
            if (fis != null)
                fis.close();
            if (lnis != null)
                lnis.close();
        }
    }
}
