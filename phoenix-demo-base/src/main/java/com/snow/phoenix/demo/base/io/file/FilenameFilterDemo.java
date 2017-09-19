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

package com.snow.phoenix.demo.base.io.file;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/14          FXY        Created
 **********************************************
 */

import java.io.File;
import java.io.FilenameFilter;

/**
 * 文件名过滤接口案列
 * <p>
 * 过滤掉不为图片类型的文件
 */
public class FilenameFilterDemo implements FilenameFilter {

    private static final String PNG = ".png";
    private static final String JPG = ".jpg";
    private static final String GIF = ".gif";

    private boolean isGif(String fileName) {
        if (fileName.toLowerCase().endsWith(GIF))
            return true;
        return false;
    }

    private boolean isJpg(String fileName) {
        if (fileName.toLowerCase().endsWith(JPG))
            return true;
        return false;
    }

    private boolean isPng(String fileName) {
        if (fileName.toLowerCase().endsWith(PNG))
            return true;
        return false;
    }


    public boolean accept(File dir, String name) {
        return isGif(name) || isJpg(name) || isPng(name);
    }

    public static void main(String args[]) {
        //File.separatorChar会根据文件系统自动填充合适的分割符
        final String dir = "E:" + File.separatorChar + "学习资料" + File.separatorChar + "文档";
        File file = new File(dir);
        String[] list = file.list(new FilenameFilterDemo());
        for (String filename : list)
            System.out.println(filename);
    }
}
