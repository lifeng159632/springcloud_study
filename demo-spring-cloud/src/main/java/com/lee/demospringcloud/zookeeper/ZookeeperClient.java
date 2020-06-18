package com.lee.demospringcloud.zookeeper;

import org.springframework.beans.factory.annotation.Value;


public class ZookeeperClient {


    private static String zookeeperpath;

    public String getZookeeperpath() {
        return zookeeperpath;
    }

//    @Value("zookeeper.path")
    public void setZookeeperpath(String zookeeperpath) {
        ZookeeperClient.zookeeperpath = zookeeperpath;
    }
}
