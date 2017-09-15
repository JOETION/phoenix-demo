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

package com.snow.phoenix.demo.base.enums.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/15          FXY        Created
 **********************************************
 */

/**
 * 苹果实体
 */
public class ApplePojo {


    private Color2Demo color2Demo;

    private String shape;

    public ApplePojo(Color2Demo color2Demo, String shape) {
        this.color2Demo = color2Demo;
        this.shape = shape;
    }

    public Color2Demo getColor2Demo() {
        return color2Demo;
    }

    public void setColor2Demo(Color2Demo color2Demo) {
        this.color2Demo = color2Demo;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
