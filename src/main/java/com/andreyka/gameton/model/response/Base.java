package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Base {

    @JsonProperty("attack")
    public Integer attack;
    @JsonProperty("health")
    public Integer health;
    @JsonProperty("id")
    public String id;
    @JsonProperty("isHead")
    public Boolean isHead;
    @JsonProperty("lastAttack")
    public LastAttack lastAttack;
    @JsonProperty("range")
    public Integer range;
    @JsonProperty("x")
    public Integer x;
    @JsonProperty("y")
    public Integer y;

}
