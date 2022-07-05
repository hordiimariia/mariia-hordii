package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanC extends Bean {

    public BeanC(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    private void beanInit() {
        System.out.println("BeanC init from @Bean initMethod");
    }

    private void beanDestroy() {
        System.out.println("BeanC destroy from @Bean destroyMethod");
    }
}
