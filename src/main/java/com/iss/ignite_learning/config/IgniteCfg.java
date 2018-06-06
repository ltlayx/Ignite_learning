package com.iss.ignite_learning.config;

import com.iss.ignite_learning.model.City;
import org.apache.ignite.*;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: ignite_learning
 * @create: 2018-06-05 11:06
 *
 * 配置类，这个类中生成了一个Ignite的配置
 * Ignite节点名称：springDataNode
 * Ignite中包含的一个Cache名称：cityCache
 * 设置Cache键值对对应：<Long, City>
 * 并且启动Ignite将Ignite对象交给Spring管理
 **/
@Configuration
public class IgniteCfg {

    /**
     * Ignite的初始化Bean，这么配置的情况下，Ignite与Spring Boot公用一个JVM，Spring Boot停止时Ignite也随之退出
     * 该Bean创建了一个节点名称为springDataNode的节点，并启动了Peer类加载器
     * 创建了一个名为PersonCache的Cache设置其键值对为<Long, City>
     * 将Cahce放入节点并启动
     * @return Ignite
     */
//    @Bean
//    public Ignite igniteInit() {
//        // 配置一个节点的Configuration
//        IgniteConfiguration cfg = new IgniteConfiguration();
//
//        // 设置该节点名称
//        cfg.setIgniteInstanceName("springDataNode");
//
//        // 启用Peer类加载器
//        cfg.setPeerClassLoadingEnabled(true);
//
//        // 创建一个Cache的配置，名称为PersonCache
//        CacheConfiguration ccfg = new CacheConfiguration("cityCache");
//
//        // 设置这个Cache的键值对模型
//        ccfg.setIndexedTypes(Long.class, City.class);
//
//        // 把这个Cache放入springDataNode这个Node中
//        cfg.setCacheConfiguration(ccfg);
//
//        // 设置Ignite启停前后的特定操作
//        cfg.setLifecycleBeans(new IgniteLifecycleBean());
//
//        // 启动这个节点
//        return Ignition.start(cfg);
//    }

    /**
     * 通过配置来启动Ignite节点
     * @return Ignite
     */
    @Bean
    public Ignite igniteInit() {
        String cfgPath = "examples/config/example-cache.xml";

        // 启动这个节点
        return Ignition.start(cfgPath);
    }

}
