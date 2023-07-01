package org.demo.spark.config;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.val;

@Component
public class SparkConfig {

    @Bean
    public SparkSession spark() {
        System.setProperty("hadoop.home.dir", "D:/workspace_bigdata/hadoop/hadoop-2.6.0");
        val conf = new SparkConf();
        conf.setMaster("local");
        // conf.set("spark.sql.warehouse.dir", "/user/hive/warehouse");
        // conf.set("dfs.client.use.datanode.hostname", "true");
        conf.set("hive.exec.dynamic.partition", "true");
        conf.set("hive.exec.dynamic.partition.mode", "nonstrict");
        return SparkSession.builder().enableHiveSupport().config(conf).getOrCreate();
    }

}
