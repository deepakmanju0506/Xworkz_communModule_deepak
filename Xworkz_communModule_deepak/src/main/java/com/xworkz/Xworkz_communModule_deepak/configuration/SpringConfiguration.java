package com.xworkz.Xworkz_communModule_deepak.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.Xworkz_communModule_deepak")
@Slf4j
public class SpringConfiguration {

    public SpringConfiguration(){
//        System.out.println("SpringConfiguration created");
        log.info("SpringConfiguration created");
    }
}
