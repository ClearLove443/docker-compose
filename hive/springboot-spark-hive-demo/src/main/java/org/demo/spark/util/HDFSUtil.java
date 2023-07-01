package org.demo.spark.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.util.StopWatch;

import lombok.val;

public class HDFSUtil {

    private HDFSUtil() {

    }

    static {
        System.setProperty("hadoop.home.dir", "D:/workspace_bigdata/hadoop/hadoop-2.6.0");
    }

    public static void uploadFile(String localFile, String hdfsPath) {
        val stopWatch = new StopWatch();
        stopWatch.start();
        val conf = new Configuration();
        try {
            val hdfsFileSystem = FileSystem.get(conf);
            val inputStream = new BufferedInputStream(new FileInputStream(localFile)); // NOSONAR
            val outputStream = hdfsFileSystem.create(new Path(hdfsPath),
                    () -> System.out.println("uploading 100m data")); // NOSONAR
            // IOUtils工具类写入输出流到输入流，完毕后关闭流
            IOUtils.copyBytes(inputStream, outputStream, 1024 * 1024 * 100, true);
            stopWatch.stop();
            System.out.println("end upLoad to hdfs, cost " + stopWatch.getTotalTimeSeconds() + " s"); // NOSONAR
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
