package com.dhm.client;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ZkClientApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ZkClientApplication.class, args);
    }
}
