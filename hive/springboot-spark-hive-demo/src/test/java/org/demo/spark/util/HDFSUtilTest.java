package org.demo.spark.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.val;

@ExtendWith(MockitoExtension.class)
public class HDFSUtilTest {

    /**
     * Failed on local exception:
     * com.google.protobuf.InvalidProtocolBufferException: Protocol message
     * end-group tag did not match expected tag.
     */
    @Test
    void testUploadFile() {
        val hdfsPath = "/data/openbeer/breweries/breweries.csv";
        HDFSUtil.uploadFile("breweries.csv", hdfsPath);
    }
}
