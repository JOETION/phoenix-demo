package com.snow.phoenix.demo.base.sundry.abstracts.sample;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/22          FXY        Created
 **********************************************
 */


/**
 * 程序入口
 */
public class Main {

    public static void main(String args[]) {
        Human male = new Male();
        //男人开始造小人儿
        male.makePeople();

        /**
         * 同一个包下，子类实例能够访问父类protected方法，但是不同包下子类实例不能访问protected方法
         * 但是子类内部能够访问父类protected方法
         *private 只能类内部访问
         * public 能够在任何地方访问
         */
//        male.doWork();
    }

}
