package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.beans.BeanFactoryPostProcessorForBeanB;
import com.epam.spring.homework2.beans.ValidationBeanPostProcessor;
import com.epam.spring.homework2.config.ConfigOne;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigOne.class);

        System.out.println("\nBeans in context:");
        for(String name: context.getBeanDefinitionNames()){
            System.out.println(name);
        }

        System.out.println("\nConfiguration:" + Arrays.asList(context.getBeanDefinitionNames()));


        System.out.println("\n" + context.getBean(BeanF.class) + "\n");

        context.close();
    }
}
