package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;

@Configuration
@Import(ConfigTwo.class)
@PropertySource("classpath:application.properties")
public class ConfigOne {

    @Bean
    public BeanA beanA(){
        return new BeanA("beanA", 5);
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    @DependsOn({"beanD"})
    public BeanB beanB(@Value("${beanB.name}") final String name, @Value("${beanB.value}") final int value){
        return new BeanB(name, value);
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    @DependsOn({"beanD", "beanB"})
    public BeanC beanC(@Value("${beanC.name}") final String name, @Value("${beanC.value}") final int value){
        return new BeanC(name, value);
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    public BeanD beanD(@Value("${beanD.name}") final String name, @Value("${beanD.value}") final int value){
        return new BeanD(name, value);
    }

    @Bean
    public BeanE beanE(){
        return new BeanE("beanE", 1);
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF("beanF", 6);
    }
}
