package com.kaisikk.java.springpagination;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class SpringpaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringpaginationApplication.class, args);
    }


}
