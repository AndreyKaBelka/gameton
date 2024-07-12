package com.andreyka.gameton.model.response;

import lombok.Data;

@Data
public class ErrorResponse {
    Integer errorCode;
    String error;
}
