package com.coco;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by PC on 01/11/2016.
 */
@Service
@Aspect
public class MyService2 {

    @Before("execution(* doSomething())")
    public String doSomething(){
        return "youyou";
    }


}
