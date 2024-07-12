package com.andreyka.gameton.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "url")
@Configuration
public class UrlsConfig {
    String main;
    String test;
    String registration;
    String command;
    String units;
    String world;
    String rounds;

    String token;
}
