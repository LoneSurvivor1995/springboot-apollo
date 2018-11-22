package com.example.springbootapollo.common;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
public class AppConfig {
    @Bean
    public TestApolloAnnotationBean testApolloAnnotationBean() {
        return new TestApolloAnnotationBean();
    }
}
