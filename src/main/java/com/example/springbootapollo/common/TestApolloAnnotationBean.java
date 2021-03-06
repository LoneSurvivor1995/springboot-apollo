package com.example.springbootapollo.common;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.ApolloJsonValue;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class TestApolloAnnotationBean {
//    @ApolloConfig
//    private Config config; //inject config for namespace application
//    @ApolloConfig("application")
//    private Config anotherConfig; //inject config for namespace application
    @ApolloConfig("rpc")
    private Config config; //inject config for namespace FX.apollo

    /**
     * ApolloJsonValue annotated on fields example, the default value is specified as empty list - []
     * <br />
     * jsonBeanProperty=[{"someString":"hello","someInt":100},{"someString":"world!","someInt":200}]
     */
//    @ApolloJsonValue("${jsonBeanProperty:[]}")
//    private List<JsonBean> anotherJsonBeans;

//    @Value("${timeout:1000}")
//    private int timeout;

    //config change listener for namespace application
//    @ApolloConfigChangeListener
//    private void someOnChange(ConfigChangeEvent changeEvent) {
//        //update injected value of batch if it is changed in Apollo
//        if (changeEvent.isChanged("timeout")) {
//            timeout = config.getIntProperty("timeout", 100);
//        }
//    }

    private int timeout;

    //config change listener for namespace application
    @ApolloConfigChangeListener("redis")
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        if (changeEvent.isChanged("timeout")) {
            timeout = config.getIntProperty("timeout", 100);
            System.out.println("***************  timeout= "+timeout);
        }
    }

    //config change listener for namespaces application and FX.apollo
//    @ApolloConfigChangeListener({"application", "FX.apollo"})
//    private void yetAnotherOnChange(ConfigChangeEvent changeEvent) {
//        //do something
//    }

    //example of getting config from Apollo directly
    //this will always return the latest value of timeout
    public int getTimeout() {
        return config.getIntProperty("timeout", 200);
    }

    public void getAll(){

    }

    //example of getting config from injected value
    //the program needs to update the injected value when batch is changed in Apollo using @ApolloConfigChangeListener shown above
//    public int getTimeout() {
//        return this.timeout;
//    }

    private static class JsonBean{
        private String someString;
        private int someInt;
    }
}