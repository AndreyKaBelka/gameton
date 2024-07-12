package com.andreyka.gameton.model.response;

import com.andreyka.gameton.model.request.Command;
import lombok.Data;

import java.util.List;

@Data
public class CommandResponse {
    Command acceptedCommands;
    List<String> errors;
}
