package com.iss.ignite_learning.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

/**
 * @program: ignite_learning
 * @author: 李泰郎
 * @create: 2018-06-05 11:14
 **/
public class City {

    @QuerySqlField
    private int id;

    @QuerySqlField
    private String name;


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

    public City() {
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }
}