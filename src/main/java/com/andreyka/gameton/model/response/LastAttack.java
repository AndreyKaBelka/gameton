package com.andreyka.gameton.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LastAttack {
    @JsonProperty("x")
    public Integer x;
    @JsonProperty("y")
    public Integer y;
}
