package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Units {
    @JsonProperty("base")
    public List<Base> base;
    @JsonProperty("enemyBlocks")
    public List<EnemyBlock> enemyBlocks;
    @JsonProperty("player")
    public Player player;
    @JsonProperty("realmName")
    public String realmName;
    @JsonProperty("turn")
    public Integer turn;
    @JsonProperty("turnEndsInMs")
    public Integer turnEndsInMs;
    @JsonProperty("zombies")
    public List<Zombie> zombies;

}
