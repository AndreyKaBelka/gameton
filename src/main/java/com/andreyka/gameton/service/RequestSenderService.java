package com.andreyka.gameton.service;

import com.andreyka.gameton.config.UrlsConfig;
import com.andreyka.gameton.model.request.Command;
import com.andreyka.gameton.model.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.netty.http.client.HttpClient;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class RequestSenderService {

    @Autowired
    UrlsConfig urlsConfig;

    @Autowired
    HttpClient httpClient;

    @Autowired
    ObjectMapper objectMapper;

    public CommandResponse sendCommand(Command command) {
        try (InputStream response = httpClient.post().uri(urlsConfig.getCommand()).send((req, out) -> out.sendObject(command)).responseContent().aggregate().asInputStream().block()) {
            return objectMapper.readValue(response, CommandResponse.class);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public Registration register() {
        try (InputStream response = httpClient.put().uri(urlsConfig.getRegistration()).responseContent().aggregate().asInputStream().block()) {
            return objectMapper.readValue(response, Registration.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Rounds getRounds() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getRounds()).responseContent().aggregate().asInputStream().block()) {
            return objectMapper.readValue(response, Rounds.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public World getWorld() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getWorld()).responseContent().aggregate().asInputStream().block()) {
            return objectMapper.readValue(response, World.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Units getUnits() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getUnits()).responseContent().aggregate().asInputStream().block()) {
            return objectMapper.readValue(response, Units.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
