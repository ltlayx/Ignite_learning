package com.iss.ignite_learning.javarun;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * @program: ignite_learning
 * @create: 2018-06-06 20:41
 **/
public class FirstDataGridApplication {
    public static void main(String[] args) {
        try(Ignite ignite = Ignition.start("examples/config/example-cache.xml")){

            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName");

            for (int i = 0; i < 10; i++) {
                cache.put(i, Integer.toString(i));
            }

            for (int i = 0; i < 10; i++) {
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']');
            }
        }
    }
}
