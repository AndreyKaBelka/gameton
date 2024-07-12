package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnemyBlock {

    @JsonProperty("attack")
    public Integer attack;
    @JsonProperty("health")
    public Integer health;
    @JsonProperty("isHead")
    public Boolean isHead;
    @JsonProperty("lastAttack")
    public LastAttack lastAttack;
    @JsonProperty("name")
    public String name;
    @JsonProperty("x")
    public Integer x;
    @JsonProperty("y")
    public Integer y;

}