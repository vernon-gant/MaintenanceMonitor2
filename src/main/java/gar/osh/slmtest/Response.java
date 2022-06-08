package gar.osh.slmtest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

public class Response {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    @JsonProperty
    private final String message;

    public Response(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Map<String, Object> toAttributeMap() {
        return Map.of(
            "timestamp", timestamp,
            "message", message
        );
    }
}
