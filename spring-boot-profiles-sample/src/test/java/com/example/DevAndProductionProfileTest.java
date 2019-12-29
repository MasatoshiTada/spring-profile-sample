package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles({"dev", "production"})
@SpringBootTest
public class DevAndProductionProfileTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void value1はProduction1(@Value("${sample.value1}") String value1) {
        assertEquals("Production1", value1);
    }

    @Test
    public void value2はDefault2(@Value("${sample.value2}") String value2) {
        assertEquals("Default2", value2);
    }

    @Test
    public void defaultBeanがDIコンテナに存在する() {
        assertTrue(context.containsBean("defaultBean"));
    }

    @Test
    public void devBeanがDIコンテナに存在するする() {
        assertTrue(context.containsBean("devBean"));
    }

    @Test
    public void productionBeanがDIコンテナに存在する() {
        assertTrue(context.containsBean("productionBean"));
    }
}
