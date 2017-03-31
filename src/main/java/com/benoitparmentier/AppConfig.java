package com.coco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by PC on 01/11/2016.
 */
@Configuration
@ComponentScan("com.coco")
@PropertySource("classpath:/config/app.properties")
@EnableAutoConfiguration
public class AppConfig {

    @Bean
    public TotoBean1 totoBean1(){
        System.out.println("totoBean1()");
        return new TotoBean1();
    }

    @Bean
    public TotoBean1 totoBean2(){
        System.out.println("totoBean2()");
        return this.totoBean1();
    }


}
