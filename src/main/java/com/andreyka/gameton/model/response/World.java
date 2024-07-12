package com.andreyka.gameton.model.response;

import lombok.Data;

import java.util.List;

@Data
public class World {
    String realmName;
    List<Zpot> zpots;

    @Data
    private static class Zpot {
        Integer x;
        Integer y;
        String type;
    }
}
