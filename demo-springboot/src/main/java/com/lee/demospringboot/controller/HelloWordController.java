package com.lee.demospringboot.controller;

import com.lee.demospringboot.model.Student;
import com.lee.demospringboot.zookeeper.ZookeeperClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HelloWordController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        Student st = new Student();
        st.setAge(21);
        st.setName("lee");
        st.setSex("fm");
        return st.toString();
    }

    @RequestMapping("getZoo")
    @ResponseBody
    public String getZoo() {
        return new ZookeeperClient().getChange();
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "index";
    }
}
