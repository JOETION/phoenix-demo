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

package com.snow.phoenix.demo.base.jdbc;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2017/9/30          FXY        Created
 **********************************************
 */

import java.sql.*;

/**
 * jdbc 案列
 */
public class JdbcDemo {

    //驱动名称
    private static final String CLAZZ_NAME = "com.mysql.jdbc.Driver";

    //数据库连接信息一般写在配置文件中
    private static final String DB_URL = "jdbc:mysql://localhost:3306/chaxun";
    private static final String DB_USER = "root";
    private static final String DB_PWD = "123456";

    //数据库连接句柄
    private Connection connection = null;
    //sql陈述
    private PreparedStatement statement = null;
    //查询结果
    private ResultSet resultSet = null;

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String args[]) {
        JdbcDemo jdbcDemo = new JdbcDemo();
        jdbcDemo.verifyQuery();
//        jdbcDemo.verifyUpdate();

    }

    /**
     * 验证查询
     */
    public void verifyQuery() {
        final String sql = "select * from rate where number=?";
        final Object[] params = new Object[]{"FXY"};
        //执行查询
        ResultSet resultSet = this.executeQuery(sql, params);
        assert resultSet != null; //虚拟机添加 -ea 参数
        //遍历查询结果
        try {
            while (resultSet.next()) {
                System.out.println("number: " + resultSet.getString("number"));
                System.out.println("name: " + resultSet.getString("name"));
                System.out.println("class: " + resultSet.getString("class"));
                System.out.println("used: " + resultSet.getString("used"));
                System.out.println("firstname: " + resultSet.getString("firstname"));
                //下面这三句必须连用
                resultSet.updateString("class", "****"); //修改某字段
                resultSet.updateRow(); // 更新某行
                connection.commit(); //提交事务，如果未打开事务，updateRow()会自动提交事务
            }
        } catch (SQLException e) {
            System.err.println("遍历查询结果发生了异常:" + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                System.out.println("回滚结果集失败，原因：" + e1);
            }
        }
        //关闭数据库连接
        this.close();
    }


    /**
     * 验证更新
     */
    public void verifyUpdate() {
        final String sql = "update rate set number=? where name=? ";
        final Object[] params = new Object[]{"FXY", "111"};
        this.executeUpdate(sql, params);
        this.close();
    }

    /**
     * 连接数据库第一步：获取数据库的链接
     *
     * @return 数据库连接句柄
     */
    private Connection getMysqlConnection() {
        // 加载驱动
        try {
            Class.forName(CLAZZ_NAME);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            connection.setAutoCommit(false);//添加事务支持，默认为true，即事务是关闭的
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("开始连接数据库地址：" + metaData.getURL());
            System.out.println("当前用户名：" + metaData.getUserName());
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("没有能连接Mysql的驱动:" + e);
            return null;
        } catch (SQLException e) {
            System.err.println("连接数据库异常：" + e);
            return null;
        }
    }


    /**
     * 连接数据库第二步：用第一步中的连接拼接sql语句
     * <p>
     * PreparedStatement sql语句预编译时就确定
     * Statement 每次执行操作前都要指定sql语句
     *
     * @param sql    查询语句
     * @param params 查询语句中的参数 替换sql语句中的问号
     * @return 查询结果集
     */
    private PreparedStatement getMysqlStatement(String sql, Object[] params) {
        try {
            // 创建一个JDBC声明
            statement = getMysqlConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); //结果集不可滚动，结果集对更新敏感
            if (null != params && params.length != 0) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]);
                }
            }
            return statement;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    /**
     * INSERT,UPDATE,DELETE
     * 连接数据库第三步：用第一步中的连接执行更新并返回受影响的行数
     *
     * @param sql    更新语句
     * @param params 更新参数，替换sql语句中的问号
     * @return 受影响的行数
     */
    public int executeUpdate(String sql, Object[] params) {
        try {
            // 创建一个JDBC声明
            statement = getMysqlConnection().prepareStatement(sql);
            if (null != params && params.length != 0) {
                for (int i = 0; i < params.length; i++) {
                    statement.setObject(i + 1, params[i]); //参数索引从1开始
                }
            }
            int rowIds = statement.executeUpdate();
            connection.commit(); //不手动提交，数据库中的数据不会改变
            return rowIds;
        } catch (Exception ex) {
            System.out.println("执行更新发生错误，原因：" + ex);
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println("回滚失败，原因：" + e);
            }
            return -1;
        }
    }


    /**
     * 连接数据库第三步：用第二步中的sql语句得到查询结果
     * 查询时不需要commit或者回滚
     *
     * @return 查询结果
     */
    public ResultSet executeQuery(String sql, Object[] params) {
        try {
            this.resultSet = getMysqlStatement(sql, params).executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println("一共：" + metaData.getColumnCount() + "列数据");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("执行查询出错，原因：" + e);
            return null;
        }
    }


    /**
     * 连接数据库第四步：关闭数据库连接
     * <p>
     * 关闭顺序：Result,Statement,Connection
     */
    public void close() {
        try {
            // 应该明确地关闭所有的数据库资源
            if (null != resultSet) {
                resultSet.close();
            }
            if (null != statement) {
                statement.close();
            }
            if (null != connection)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
