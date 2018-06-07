package com.iss.ignite_learning.javarun;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * @program: ignite_learning
 * @create: 2018-06-06 20:41
 *
 * 使用配置启动Ignite节点，并且向Ignite节点中创建myCache这个Cache，并向其中放入十个元素，最后访问这10个元素
 * 用于测试在当前已经有Ignite节点启动的情况下在启动一个Ignite节点组成集群，并尝试ignite简单的的put以及get操作
 **/
public class FirstDataGridApplication {
    public static void main(String[] args) {
        try(Ignite ignite = Ignition.start("examples/config/example-ignite.xml")){

            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");

            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }
        }
    }
}
