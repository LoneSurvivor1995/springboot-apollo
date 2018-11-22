package com.example.springbootapollo.common;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

public class Demo {
    public static void main(String[] args) {
        System.setProperty("apollo.meta","localhost:8080");
        System.setProperty("env","ENV");
        System.setProperty("apollo.cluster","redis");
        System.setProperty("idc","redis-1");

        Config config = ConfigService.getConfig("rpc");
        System.out.println(config.getProperty("ip","localhost"));
    }
}
