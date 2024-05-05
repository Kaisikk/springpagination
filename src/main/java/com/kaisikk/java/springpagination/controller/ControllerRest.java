package com.kaisikk.java.springpagination.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerRest {

    @GetMapping(value = "/async")
    @Async
    public void doAsync() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("DONE");
    }

}
