package com.benoitparmentier;

import com.benoitparmentier.config.AppConfig;
import com.benoitparmentier.MyServiceProd;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by PC on 01/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("prod")
public class CApplicationContextPropertiesTest {

    @Autowired
    private MyServiceProd myServiceProd;

    @Test
    public void setup(){

        Assert.assertSame(myServiceProd.doSomething(), "youyouProd");

    }
}
