package com.example;

import com.example.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("DefaultBean : " + context.containsBean("defaultBean"));
        System.out.println("DevBean : " + context.containsBean("devBean"));
        System.out.println("ProductionBean : " + context.containsBean("productionBean"));
    }
}
