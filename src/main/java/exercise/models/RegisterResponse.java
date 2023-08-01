package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegisterResponse {

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("message")
    private String message;

}
