package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanD extends Bean {

    public BeanD(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    private void beanInit() {
        System.out.println("BeanD init from @Bean initMethod");
    }

    private void beanDestroy() {
        System.out.println("BeanD destroy from @Bean destroyMethod");
    }

}
