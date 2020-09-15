package com.lee.demospringcloud.zookeeper;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ZookeeperClient {


//    private static String zookeeperpath = "192.168.1.253:2181";
    private static String zookeeperpath = "49.232.109.87:2181";

    private static String namespace = "business";

    private CuratorFramework client;

    private InterProcessMutex interProcessMutex;

    public void initClient() {
        client = CuratorFrameworkFactory
                .builder()
                .connectString(zookeeperpath)
                .namespace(namespace)
                .retryPolicy(new RetryNTimes(2,200))
                .build();
        client.start();
    }

    public boolean accqueLock(String businessKey) {
        if (StringUtils.isNotBlank(businessKey)) {
            try {
                interProcessMutex = new InterProcessMutex(client, businessKey);
                return interProcessMutex.acquire(3000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new RuntimeException("key can not be null");
        }
    }

    public boolean releaseLock(String businessKey) {
        if (StringUtils.isNotBlank(businessKey)) {
            try {
//                interProcessMutex = new InterProcessMutex(client, businessKey);
                interProcessMutex.release();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            throw new RuntimeException("key can not be null");
        }
    }
}
