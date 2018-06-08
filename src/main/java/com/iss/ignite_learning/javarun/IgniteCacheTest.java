package com.iss.ignite_learning.javarun;

import com.iss.ignite_learning.model.Person;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

import javax.cache.Cache;

/**
 * @program: ignite_learning
 * @create: 2018-06-08 10:29
 *
 * 这个类用于测试Ignite的访问操作，对FirstDataGridApplication.java中创建的Ignite节点进行访问
 **/
public class IgniteCacheTest {
    public static void main(String[] args) {
        IgniteConfiguration igniteCfg = new IgniteConfiguration();

        igniteCfg.setIgniteInstanceName("firstIgnite");

        igniteCfg.setPeerClassLoadingEnabled(true);
        // 启动一个Ignite节点
        Ignition.start(igniteCfg);

        // 获取名称为firstIgnite的实例
        Ignite ignite = Ignition.ignite("firstIgnite");

        // 获取名称为myCache的Cache
        IgniteCache<String, Person> cache = ignite.getOrCreateCache("myCache");

        // 获取Alice以及Bob的内容
        Person alice = cache.get("Alice");
        Person bob = cache.get("Bob");
        System.out.println(alice.toString());
        System.out.println(bob.toString());

    }
}
