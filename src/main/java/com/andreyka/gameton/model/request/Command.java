package com.andreyka.gameton.model.request;

import lombok.Data;

import java.util.List;

@Data
public class Command {
    List<AttackCommand> attack;
    List<BuildCommand> build;
    MoveBase moveBase;
}
