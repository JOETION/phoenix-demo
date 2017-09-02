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


public abstract class AbstractSkills {


    //技能冷却时间
    protected int waitTime;

    //技能范围
    protected int scope;

    //技能耗蓝
    protected int cost;

    //技能攻击力
    protected int aggressivity;

    public AbstractSkills(int waitTime, int scope, int cost, int aggressivity) {
        this.waitTime = waitTime;
        this.scope = scope;
        this.cost = cost;
        this.aggressivity = aggressivity;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAggressivity() {
        return aggressivity;
    }

    public void setAggressivity(int aggressivity) {
        this.aggressivity = aggressivity;
    }
}
