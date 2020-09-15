package com.lee.service;

import com.lee.util.RedisDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class KeyDBService {

    @Autowired
    private RedisDaoImpl redisDao;

    public void writeIntoKeyDB() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            new Runnable() {
                @Override
                public void run() {
                    redisDao.set("key.index_"+ index, index+"");
                }
            }.run();
        }
        System.out.println(System.currentTimeMillis() - start);
//        Set<String> keySet = redisDao.getMembers("*key*");
//        System.out.println(keySet.toString());
//        if (keySet != null) {
//            for (String key : keySet) {
//                redisDao.del(key);
//            }
//        }
    }
}
