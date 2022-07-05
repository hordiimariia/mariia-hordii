package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanB extends Bean {

    public BeanB(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    private void beanInit() {
        System.out.println("BeanB init from @Bean initMethod");
    }

    private void bfppBeanInit() {
        System.out.println("BeanB init from BeanFactoryPostProcessor");
    }

    private void beanDestroy() {
        System.out.println("BeanB destroy from @Bean destroyMethod");
    }
}
