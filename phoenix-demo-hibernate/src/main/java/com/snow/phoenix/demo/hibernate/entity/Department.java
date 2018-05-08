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

package com.snow.phoenix.demo.hibernate.entity;

/* 				    
 **********************************************
 *      DATE           PERSON       REASON
 *    2018/5/8          FXY        Created
 **********************************************
 */

import javax.persistence.*;
import java.util.Set;

//部门实体类，与employee类是一对多的关系
@Entity
public class Department {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    /**
     * CascadeType.PERSIST：保存           CascadeType.REMOVE：删除
     * CascadeType.MERGE：修改            CascadeType.REFRESH：刷新
     * CascadeType.ALL：全部
     * <br/>
     * Fetch.EAGER：及时加载，多对一默认是Fetch.EAGER
     * Fetch.LAZY：延迟加载，一对多默认是Fetch.LAZY
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id") //参考本表的哪个字段作为外键
    private Set<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
