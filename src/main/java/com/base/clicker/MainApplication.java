package com.base.clicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {	
    public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

        // If our application is an event consumer
        // EventConsumer consumer = new EventConsumer(
        //     config.getBootstrapServer(), 
        //     config.getGroupId(), 
        //     config.getTopic());

        // consumer.consume();
    }
}