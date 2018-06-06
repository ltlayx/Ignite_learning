package com.iss.ignite_learning.controller;

import com.iss.ignite_learning.model.City;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @program: ignite_learning
 * @create: 2018-06-06 06:55
 **/
@RestController
public class TestIgnite {

    @Autowired
    private Ignite ignite;

    @GetMapping(value = "/")
    public String testInject() {
        IgniteCache<Long, City> cityCache = ignite.cache("SQL_PUBLIC_CITY");
        SqlFieldsQuery query = new SqlFieldsQuery(
                "INSERT INTO City (id, name) VALUES (?, ?)");
        cityCache.query(query.setArgs(1L, "Forest Hill")).getAll();
        cityCache.query(query.setArgs(2L, "Denver")).getAll();
        cityCache.query(query.setArgs(3L, "St. Petersburg")).getAll();

        // Querying data from the cluster using a distributed JOIN.
//        query = new SqlFieldsQuery("SELECT p.name, c.name " +
//                " FROM Person p, City c WHERE p.city_id = c.id");
//        FieldsQueryCursor<List<?>> cursor = cityCache.query(query);
//        Iterator<List<?>> iterator = cursor.iterator();
//        while (iterator.hasNext()) {
//            List<?> row = iterator.next();
//            System.out.println(row.get(0) + ", " + row.get(1));
//        }

        return "";
    }

    public void setIgnite(Ignite ignite) {
        this.ignite = ignite;
    }
}
