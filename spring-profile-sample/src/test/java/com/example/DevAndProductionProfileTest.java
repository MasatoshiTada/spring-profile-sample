package com.example;

import com.example.config.Config;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles({"dev", "production"})
@SpringJUnitConfig(classes = Config.class)
public class DevAndProductionProfileTest {

    @Autowired
    ApplicationContext context;

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
