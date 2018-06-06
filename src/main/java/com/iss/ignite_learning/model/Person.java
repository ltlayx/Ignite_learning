package com.iss.ignite_learning.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @program: ignite_learning
 * @create: 2018-06-05 11:15
 *
 * 这个类用于表示人，包含三个字段，用于ignite测试
 * @param: id   人的id
 * @param: name 人的名称
 * @param: city_id  人所在城市的id
 **/
public class Person {

    @QuerySqlField(index = true)
    private int id;

    @QuerySqlField
    private String name;

    @QuerySqlField
    private int city_id;

    public Person() {

    }

    public Person(int id, String name, int city_id) {
        this.id = id;
        this.name = name;
        this.city_id = city_id;
    }

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

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

}
