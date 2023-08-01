package exercise.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserResponse {

    @JsonProperty("responseCode")
    private Integer responseCode;

    @JsonProperty("user")
    private UserDetailsResponse user;

}
