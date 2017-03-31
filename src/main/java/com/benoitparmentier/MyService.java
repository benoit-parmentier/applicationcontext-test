package com.coco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PC on 01/11/2016.
 */
@Service
public class MyService {


    MyService2 serviceProd;

    @Autowired
    public MyService(MyService2 serviceProd) {
        this.serviceProd = serviceProd;
    }

    public String doSomething(){
        return "youyou";
    }


}
