package com.lee.demospringcloud.service;

import com.lee.demospringcloud.zookeeper.ZookeeperClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private ZookeeperClient zookeeperClient;

    public void doSomething() {
        zookeeperClient.initClient();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }

    public class Task implements Runnable {

        @Override
        public void run() {
            try {
                if (zookeeperClient.accqueLock("/test")) {
                    System.out.println(Thread.currentThread().getName() + " got the key");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 没有获得锁 ");
                }
                Thread.sleep(500);
                zookeeperClient.releaseLock("/test");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
