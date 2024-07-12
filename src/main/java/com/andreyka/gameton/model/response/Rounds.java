package com.andreyka.gameton.model.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Rounds {
    String gameName;
    LocalDateTime now;
    List<Round> rounds;

    @Data
    private static class Round {
        Integer duration;

        LocalDateTime endAt;
        String name;
        Integer repeat;

        LocalDateTime startAt;
        String status;
    }
}
