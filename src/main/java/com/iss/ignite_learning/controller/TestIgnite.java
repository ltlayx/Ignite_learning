package com.iss.ignite_learning.controller;

import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ignite_learning
 * @create: 2018-06-06 06:55
 **/
@RestController
public class TestIgnite {

    // 通过依赖注入的方式获取到Ignite对象
    @Autowired
    private Ignite ignite;

    @GetMapping(value = "/")
    public String testInject() {
        ignite.log();
        return "";
    }

    public void setIgnite(Ignite ignite) {
        this.ignite = ignite;
    }
}
