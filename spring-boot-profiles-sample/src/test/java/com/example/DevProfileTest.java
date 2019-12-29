package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"dev"})
@SpringBootTest
public class DevProfileTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void value1はDev1(@Value("${sample.value1}") String value1) {
        assertEquals("Dev1", value1);
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
    public void devBeanがDIコンテナに存在する() {
        assertTrue(context.containsBean("devBean"));
    }

    @Test
    public void productionBeanはDIコンテナに存在しない() {
        assertFalse(context.containsBean("productionBean"));
    }
}
