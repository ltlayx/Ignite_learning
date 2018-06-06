package com.iss.ignite_learning;

import com.iss.ignite_learning.model.City;
import com.iss.ignite_learning.model.Person;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.ignite.*;

@SpringBootApplication
public class IgniteLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgniteLearningApplication.class, args);
//
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
    }
}
