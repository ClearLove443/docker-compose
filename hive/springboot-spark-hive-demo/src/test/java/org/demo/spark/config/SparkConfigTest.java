package org.demo.spark.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.val;

@ExtendWith(MockitoExtension.class)
public class SparkConfigTest {

    @Spy
    SparkConfig sparkConfig;

    SparkSession spark;

    @BeforeEach
    void init() {
        spark = sparkConfig.spark();
    }

    @Test
    void testSpark0() {
        spark.sql("create database openbeer");
        spark.sql("show databases").show();
        spark.sql("show tables").show();
        // val df = spark.sql("select * from testdb.breweries limit 10");
        // df.show();

        assertTrue(true);
    }

    @Test
    void testSpark() {
        // spark.sql("create database openbeer");
        // spark.sql("show databases").show();
        // spark.sql("show tables").show();
        val df = spark.sql("select * from testdb.employee limit 10");
        val t = df.toJSON().collectAsList();
        df.show();

        assertTrue(true);
    }

    @Test
    void testSpark1() {
        val sql = " CREATE EXTERNAL TABLE IF NOT EXISTS testdb.breweries(" +
                " NUM INT," +
                " NAME CHAR(100)," +
                " CITY CHAR(100)," +
                " STATE CHAR(100)," +
                " ID INT )" +
                " ROW FORMAT DELIMITED" +
                " FIELDS TERMINATED BY ','" +
                " STORED AS TEXTFILE" +
                " location '/data/openbeer/breweries'";
        spark.sql(sql);
        assertTrue(true);
    }
}
