package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanF extends Bean {

    public BeanF(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    public BeanF() {
        System.out.println(this);
    }
}
