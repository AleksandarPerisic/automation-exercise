package exercise.testcases.backend;

import exercise.TestBase;
import exercise.models.RegisterRequest;
import exercise.models.UserResponse;
import org.testng.annotations.Test;

public class CustomerDetails extends TestBase {

    @Test()
    public void getUserDetailsByEmailTest(){

        RegisterRequest registerRequest = createValidUserRequest(validEmail);

        registerUserAccount(registerRequest);

        UserResponse userResponse = getUserDetailsByEmail(validEmail);

        checkUserDetailsResponse(userResponse,registerRequest);
    }
}
