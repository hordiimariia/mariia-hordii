package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE extends Bean {

    public BeanE(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    public BeanE() {
        System.out.println(this);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("BeanE postConstruct method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("BeanE preDestroy method");
    }
}
