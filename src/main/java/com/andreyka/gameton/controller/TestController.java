package com.andreyka.gameton.controller;

import com.andreyka.gameton.model.request.Command;
import com.andreyka.gameton.service.RequestSenderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RequestSenderService requestSenderService;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    @SneakyThrows
    public void test() {
        String command = """
                {
                  "attack": [
                    {
                      "blockId": "f47ac10b-58cc-0372-8562-0e02b2c3d479",
                      "target": {
                        "x": 1,
                        "y": 1
                      }
                    }
                  ],
                  "build": [
                    {
                      "x": 1,
                      "y": 1
                    }
                  ],
                  "moveBase": {
                    "x": 1,
                    "y": 1
                  }
                }
                """;
        Command commandObj = objectMapper.readValue(command, Command.class);
        System.out.println(requestSenderService.sendCommand(commandObj));
    }
}
