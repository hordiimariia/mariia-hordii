package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends Bean implements InitializingBean, DisposableBean {

    public BeanA(String name, int value) {
        super(name, value);
    }

    public BeanA() {
        System.out.println(this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA init from InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA destroy from DisposableBean");
    }
}
