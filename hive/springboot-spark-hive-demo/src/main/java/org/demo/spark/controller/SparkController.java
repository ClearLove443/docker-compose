package org.demo.spark.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.spark.sql.SparkSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

@RestController
public class SparkController {

    @Resource
    SparkSession spark;

    ObjectMapper mapper = new ObjectMapper();

    @GetMapping("test")
    Object test() {
        val df = spark.sql("select * from testdb.employee limit 10");
        val t = df.toJSON().collectAsList().parallelStream().map(json -> {
            try {
                return mapper.readValue(json, Map.class);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        df.show(1000, false);
        return t;
    }

    @GetMapping("test2")
    Object test2() {
        val df = spark.sql("show create table testdb.employee");
        val t = df.toJSON().collectAsList().parallelStream().map(json -> {
            try {
                return mapper.readValue(json, Map.class);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        df.show(1000, false);
        return t;
    }
}
