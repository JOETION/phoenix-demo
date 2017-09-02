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

package com.snow.phoenix.demo.ood.peoplesupergod.skill;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/13          FXY        Created
 **********************************************
 */

/**
 * 控制系技能
 */
public class DefaultControlSkills extends AbstractSkills {

    //技能持续时间
    protected int continueTime;

    public DefaultControlSkills(int waitTime, int scope, int cost, int aggressivity, int continueTime) {
        super(waitTime, scope, cost, aggressivity);
        this.continueTime = continueTime;
    }

    public int getContinueTime() {
        return continueTime;
    }

    public void setContinueTime(int continueTime) {
        this.continueTime = continueTime;
    }
}
