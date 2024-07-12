package com.andreyka.gameton.model.request;

import lombok.Data;

@Data
public class AttackCommand {
    String blockId;
    Target target;

    @Data
    private static class Target {
        Integer x;
        Integer y;
    }
}
