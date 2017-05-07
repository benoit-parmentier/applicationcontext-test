package com;

import com.benoitparmentier.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by PC on 01/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CApplicationContextEnvironmentTest {


    @Autowired
    private Environment env;

    @Test
    public void setup(){

        System.out.println("env : " + env.getProperty("java.version"));
        System.out.println("env : " + env.getProperty("USERNAME"));

    }
}
