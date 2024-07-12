package com.andreyka.gameton.controller;

import com.andreyka.gameton.service.RequestSenderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RequestSenderService requestSenderService;

    @PostConstruct
    public void test() {
        System.out.println(requestSenderService.getRounds());
    }
}
