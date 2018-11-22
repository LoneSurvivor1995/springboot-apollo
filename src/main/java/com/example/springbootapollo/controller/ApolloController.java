package com.example.springbootapollo.controller;

import com.example.springbootapollo.common.TestApolloAnnotationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApolloController {

    @Autowired
    TestApolloAnnotationBean testApolloAnnotationBean;

    @Value("${ip}")
    String ip;

    @Value("${port:6379}") //后面是定义默认值，如果没有就是默认值
    String port;

    @GetMapping("/ip")
    String getIp(){

        System.out.println("********** "+testApolloAnnotationBean.getTimeout());
        return ip;
    }

    @GetMapping("/port")
    String getPort(){
        return port;
    }
}
