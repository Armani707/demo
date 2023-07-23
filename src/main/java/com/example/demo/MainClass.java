package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.demo");
        RestService bean = applicationContext.getBean(RestService.class);
        System.out.println(bean.getRainyDaysCount());

    }
}
