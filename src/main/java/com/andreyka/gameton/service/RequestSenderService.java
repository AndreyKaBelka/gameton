package com.andreyka.gameton.service;

import com.andreyka.gameton.config.UrlsConfig;
import com.andreyka.gameton.model.request.Command;
import com.andreyka.gameton.model.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Service
@Slf4j
public class RequestSenderService {

    @Autowired
    UrlsConfig urlsConfig;

    @Autowired
    HttpClient httpClient;

    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    public Optional<CommandResponse> sendCommand(Command command) {
        String json = objectMapper.writeValueAsString(command);
        try (InputStream response = httpClient.post()
                .uri(urlsConfig.getCommand())
                .send(ByteBufFlux.fromString(Mono.just(json)))
                .responseContent()
                .aggregate()
                .asInputStream()
                .block()) {
            return Optional.of(objectMapper.readValue(response, CommandResponse.class));
        } catch (IOException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }

    }

    public Optional<Registration> register() {
        try (InputStream response = httpClient.put().uri(urlsConfig.getRegistration()).responseContent().aggregate().asInputStream().block()) {
            return Optional.of(objectMapper.readValue(response, Registration.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<Rounds> getRounds() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getRounds()).responseContent().aggregate().asInputStream().block()) {
            return Optional.of(objectMapper.readValue(response, Rounds.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<World> getWorld() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getWorld()).responseContent().aggregate().asInputStream().block()) {
            return Optional.of(objectMapper.readValue(response, World.class));
        } catch (Exception e) {
            log.error("Something went wrong in getWorld", e);
            return Optional.empty();
        }
    }

    public Optional<Units> getUnits() {
        try (InputStream response = httpClient.get().uri(urlsConfig.getUnits()).responseContent().aggregate().asInputStream().block()) {
            return Optional.of(objectMapper.readValue(response, Units.class));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
}
