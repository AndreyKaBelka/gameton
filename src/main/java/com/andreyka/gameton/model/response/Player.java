package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player {
    @JsonProperty("enemyBlockKills")
    public Integer enemyBlockKills;
    @JsonProperty("gameEndedAt")
    public String gameEndedAt;
    @JsonProperty("gold")
    public Integer gold;
    @JsonProperty("name")
    public String name;
    @JsonProperty("points")
    public Integer points;
    @JsonProperty("zombieKills")
    public Integer zombieKills;
}
