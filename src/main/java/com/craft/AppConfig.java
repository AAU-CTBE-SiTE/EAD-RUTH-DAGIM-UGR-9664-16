package com.craft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.craft")
public class AppConfig {

    @Bean
    public Subject mathematics() {
        Subject subject = new Subject();
        subject.setSubjectName("Mathematics");
        return subject;
    }

    @Bean
    public Subject javaProgramming() {
        Subject subject = new Subject();
        subject.setSubjectName("Java Programming");
        return subject;
    }

    @Bean
    public Subject springFramework() {
        Subject subject = new Subject();
        subject.setSubjectName("Spring Framework");
        return subject;
    }
}