package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC extends Bean {

    public BeanC(String name, int value) {
        super(name, value);
        System.out.println(this);
    }
}
