package com.coco;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by PC on 01/11/2016.
 */
@Service
@Profile("prod")
public class MyServiceProd {

    public String doSomething(){
        return "youyouProd";
    }
}
