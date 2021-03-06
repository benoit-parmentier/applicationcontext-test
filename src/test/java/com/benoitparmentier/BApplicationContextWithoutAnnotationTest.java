package com.benoitparmentier;

import com.benoitparmentier.config.AppConfig;
import com.benoitparmentier.MyService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BApplicationContextWithoutAnnotationTest {

    @Autowired
    private MyService myService;

    @Test
    public void setup(){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        com.benoitparmentier.MyService myService = context.getBean(com.benoitparmentier.MyService.class);
        Assert.assertSame(myService.doSomething(), "youyou");

    }

}
