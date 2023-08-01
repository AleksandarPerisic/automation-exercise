package exercise.testcases.backend;

import exercise.TestBase;
import exercise.models.RegisterRequest;
import exercise.models.RegisterResponse;
import org.testng.annotations.Test;

public class UserRegistration extends TestBase {

    @Test()
    public void registerUser() {

        RegisterRequest registerRequest = createValidUserRequest(validEmail);

        RegisterResponse response = registerUserAccount(registerRequest);

        checkSuccessfulRegistrationResponse(response);
    }
}
