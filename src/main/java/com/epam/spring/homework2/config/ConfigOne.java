package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@Import(ConfigTwo.class)
@Component
@PropertySource("classpath:application.properties")
public class ConfigOne {

    @Autowired
    private Environment env;

    @Bean
    public BeanA beanA(){
        return new BeanA();
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    @DependsOn({"beanD"})
    public BeanB beanB(){
        return new BeanB(env.getProperty("beanB.name"), Integer.parseInt(env.getProperty("beanB.value", "0")));
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    @DependsOn({"beanD", "beanB"})
    public BeanC beanC(){
        return new BeanC(env.getProperty("beanC.name"), Integer.parseInt(env.getProperty("beanC.value", "0")));
    }

    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    public BeanD beanD(){
        return new BeanD(env.getProperty("beanD.name"), Integer.parseInt(env.getProperty("beanD.value", "0")));
    }

    @Bean
    public BeanE beanE(){
        return new BeanE();
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF();
    }
}
