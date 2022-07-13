package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class BeanA extends Bean implements InitializingBean, DisposableBean {

    public BeanA(String name, int value) {
        super(name, value);
        System.out.println(this);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("BeanA init from InitializingBean");
    }

    @Override
    public void destroy() {
        System.out.println("BeanA destroy from DisposableBean");
    }
}
