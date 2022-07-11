package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.config.ConfigOne;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigOne.class);
        BeanF beanF = context.getBean(BeanF.class);

        for(String name: context.getBeanDefinitionNames()){
            System.out.println(name);
        }

        System.out.println(context.getBean(BeanF.class));

        ((AnnotationConfigApplicationContext) context).close();
    }
}
