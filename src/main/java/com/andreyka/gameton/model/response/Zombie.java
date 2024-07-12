package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Zombie {
    @JsonProperty("attack")
    public Integer attack;
    @JsonProperty("direction")
    public String direction;
    @JsonProperty("health")
    public Integer health;
    @JsonProperty("id")
    public String id;
    @JsonProperty("speed")
    public Integer speed;
    @JsonProperty("type")
    public String type;
    @JsonProperty("waitTurns")
    public Integer waitTurns;
    @JsonProperty("x")
    public Integer x;
    @JsonProperty("y")
    public Integer y;
}
