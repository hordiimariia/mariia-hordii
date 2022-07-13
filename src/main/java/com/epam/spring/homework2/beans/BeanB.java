package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanB extends Bean {

    public BeanB(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    private void bfppBeanInit() {
        System.out.println("BeanB init from BeanFactoryPostProcessor");
    }
}
