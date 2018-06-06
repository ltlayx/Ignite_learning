package com.iss.ignite_learning.ignitetest;

import com.iss.ignite_learning.model.City;
import com.iss.ignite_learning.model.Person;
import org.apache.ignite.*;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: ignite_learning
 * @author: 李泰郎
 * @create: 2018-06-05 11:06
 **/
@Configuration
public class FirstSQLApplication {

    @Bean
    public Ignite igniteInit() {
        // 配置一个节点的Configuration
        IgniteConfiguration cfg = new IgniteConfiguration();

        // 设置该节点名称
        cfg.setIgniteInstanceName("springDataNode");

        // 启用Peer类加载器
        cfg.setPeerClassLoadingEnabled(true);

        // 创建一个Cache的配置，名称为PersonCache
        CacheConfiguration ccfg = new CacheConfiguration("SQL_PUBLIC_CITY");

        // 设置这个Cache的键值对模型
        ccfg.setIndexedTypes(Long.class, City.class);

        // 把这个Cache放入springDataNode这个Node中
        cfg.setCacheConfiguration(ccfg);

        // 启动这个节点
        return Ignition.start(cfg);
    }

//    @Bean
//    public Ignite igniteTest() {
//        // Connecting to the cluster.
//        Ignite ignite = Ignition.start();
//        // Getting a reference to an underlying cache created for City table above.
//        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");
//        // Getting a reference to an underlying cache created for Person table above.
//        IgniteCache<Long, Person> personCache = ignite.cache("SQL_PUBLIC_PERSON");
//        // Inserting entries into City.
//        SqlFieldsQuery query = new SqlFieldsQuery(
//                "INSERT INTO City (id, name) VALUES (?, ?)");
//        cityCache.query(query.setArgs(1, "Forest Hill")).getAll();
//        cityCache.query(query.setArgs(2, "Denver")).getAll();
//        cityCache.query(query.setArgs(3, "St. Petersburg")).getAll();
//        // Inserting entries into Person.
//        query = new SqlFieldsQuery(
//                "INSERT INTO Person (id, name, city_id) VALUES (?, ?, ?)");
//        personCache.query(query.setArgs(1, "John Doe", 3)).getAll();
//        personCache.query(query.setArgs(2, "Jane Roe", 2)).getAll();
//        personCache.query(query.setArgs(3, "Mary Major", 1)).getAll();
//        personCache.query(query.setArgs(4, "Richard Miles", 2)).getAll();
//
//        return ignite;
//    }

}
