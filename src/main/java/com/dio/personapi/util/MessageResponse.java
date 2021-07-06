package com.dio.personapi.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.server.ResponseStatusException;

@Data
public class MessageResponse {

    private String message;

    public MessageResponse(ResponseStatusException exception) {
        this.message = exception.getReason();
    }

    public MessageResponse(String message, Long id) {
        this.message = String.format("%s %s", message, id);
    }

}
