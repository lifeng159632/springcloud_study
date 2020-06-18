package com.lee.demospringboot.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Component
public class ZookeeperClient implements Watcher {

    private static String zookeeperServerPath;

    private ZooKeeper zooKeeper;

    private Stat stat = new Stat();
    CountDownLatch latch = new CountDownLatch(1);


    private static String path = "/test";

    public void initService() throws IOException {
        zooKeeper = new ZooKeeper(zookeeperServerPath, 10000, this);
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                try {
                    System.out.println(new String(zooKeeper.getData(watchedEvent.getPath(), true, stat)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()) {
                latch.countDown();
            }
        }
    }

    public String getChange() {
        try {
            initService();
            latch.await();
            return new String(this.zooKeeper.getData(path, true, stat));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Value("${zookeeper.path}")
    public void setZookeeperServerPath(String zookeeperServerPath) {
        ZookeeperClient.zookeeperServerPath = zookeeperServerPath;
    }
}
