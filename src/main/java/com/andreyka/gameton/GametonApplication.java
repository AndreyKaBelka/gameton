package com.andreyka.gameton;

import com.andreyka.gameton.service.RequestSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GametonApplication {

    @Autowired
    RequestSenderService requestSenderService;

    public static void main(String[] args) {
        SpringApplication.run(GametonApplication.class, args);
    }

}
