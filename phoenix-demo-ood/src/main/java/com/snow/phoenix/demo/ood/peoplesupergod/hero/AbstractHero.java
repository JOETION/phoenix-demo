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

package com.snow.phoenix.demo.ood.peoplesupergod.hero;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/8/13          FXY        Created
 **********************************************
 */

import com.snow.phoenix.demo.ood.peoplesupergod.engine.DefaultHeroAction;

/**
 * 默认英雄的基类，包括黑天魔王和烈焰巨龙
 */
public abstract class AbstractHero extends AbstractElement implements DefaultHeroAction {

    //生命值
    protected int life;


    //基础攻击力
    protected int aggressivity;

    public AbstractHero(double x, double y, int life, int aggressivity) {
        super(x, y);
        this.life = life;
        this.aggressivity = aggressivity;
    }
}
