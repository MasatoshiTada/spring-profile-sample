package com.example;

import com.example.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("hoge")
@SpringJUnitConfig(classes = Config.class)
public class ProfilePriorityTest {

    @Autowired
    ApplicationContext context;

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
