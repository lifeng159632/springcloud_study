package com.lee.springcloudfeign.service.impl;

import com.lee.springcloudfeign.service.FallBackService;
import com.lee.springcloudfeign.service.HiService;
import org.springframework.stereotype.Service;

@Service
public class FallBackServiceImpl implements FallBackService, HiService {


    @Override
    public String defaultFallback() {
        return "service error";
    }

    @Override
    public String hi(String name) {
        return defaultFallback();
    }
}
