package com.xworkz.Xworkz_communModule_deepak.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.Xworkz_communModule_deepak")
public class SpringConfiguration {

    public SpringConfiguration(){
        System.out.println("SpringConfiguration created");
    }
}
