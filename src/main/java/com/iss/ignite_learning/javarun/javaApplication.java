package com.iss.ignite_learning.javarun;

import com.iss.ignite_learning.model.City;
import com.iss.ignite_learning.model.Person;
import com.iss.ignite_learning.model.PersonKey;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.FieldsQueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

import java.util.Iterator;
import java.util.List;

/**
 * @program: ignite_learning
 * @author: 李泰郎
 * @create: 2018-06-06 07:25
 **/
public class javaApplication {

    public static void main(String[] args) {
        // Connecting to the cluster.
        Ignite ignite = Ignition.start();
        // Getting a reference to an underlying cache created for City table above.
        IgniteCache<Long, City> cityCache = ignite.getOrCreateCache("SQL_PUBLIC_CITY");
        // Getting a reference to an underlying cache created for Person table above.
        IgniteCache<Long, Person> personCache = ignite.getOrCreateCache("SQL_PUBLIC_PERSON");
        // Inserting entries into City.
        SqlFieldsQuery query = new SqlFieldsQuery(
                "INSERT INTO SQL_PUBLIC_CITY (id, name) VALUES (?, ?)");
        cityCache.query(query.setArgs(1L, "Forest Hill")).getAll();
        cityCache.query(query.setArgs(2L, "Denver")).getAll();
        cityCache.query(query.setArgs(3L, "St. Petersburg")).getAll();
        // Inserting entries into Person.
        query = new SqlFieldsQuery(
                "INSERT INTO SQL_PUBLIC_PERSON (id, name, city_id) VALUES (?, ?, ?)");
        personCache.query(query.setArgs(1L, "John Doe", 3)).getAll();
        personCache.query(query.setArgs(2L, "Jane Roe", 2)).getAll();
        personCache.query(query.setArgs(3L, "Mary Major", 1)).getAll();
        personCache.query(query.setArgs(4L, "Richard Miles", 2)).getAll();

        // Querying data from the cluster using a distributed JOIN.
        query = new SqlFieldsQuery("SELECT p.name, c.name " +
                " FROM SQL_PUBLIC_PERSON p, SQL_PUBLIC_CITY c WHERE p.city_id = c.id");
        FieldsQueryCursor<List<?>> cursor = cityCache.query(query);
        Iterator<List<?>> iterator = cursor.iterator();
        while (iterator.hasNext()) {
            List<?> row = iterator.next();
            System.out.println(row.get(0) + ", " + row.get(1));
        }
    }
}
