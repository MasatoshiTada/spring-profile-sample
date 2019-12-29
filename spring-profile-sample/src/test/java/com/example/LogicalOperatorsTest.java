package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"profile2", "profile3"})
@SpringJUnitConfig
public class LogicalOperatorsTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void test() {
        assertTrue(context.containsBean("bean1"));
    }

    @Configuration
    static class Config {

        @Profile("profile1 | (profile2 & profile3)")
        @Bean
        public String bean1() {
            return new String();
        }
    }
}
