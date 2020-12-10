package org.joseph.log.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class MainController {

    Logger logger = Logger.getLogger("MainController");

    @GetMapping("/")
    public String hello(){
        logger.info("hello");
        return "hello world";
    }
}
