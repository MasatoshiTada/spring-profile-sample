package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DefaultProfileTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void value1はDefault1(@Value("${sample.value1}") String value1) {
        assertEquals("Default1", value1);
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
    public void devBeanはDIコンテナに存在しない() {
        assertFalse(context.containsBean("devBean"));
    }

    @Test
    public void productionBeanはDIコンテナに存在しない() {
        assertFalse(context.containsBean("productionBean"));
    }
}
