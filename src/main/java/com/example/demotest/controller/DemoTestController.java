package com.example.demotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/server/v1")
public class DemoTestController {
    @RequestMapping(value = "post", method = RequestMethod.POST)
    public void demoPost(){
        System.out.println("come in post");
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String demoGet(){
        return "devops push deploy success -- version 1.0.9";
    }
}
