package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.models.RegisterRequest;
import exercise.models.RegisterResponse;
import exercise.models.UserResponse;
import exercise.restapi.RestController;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;


public class TestBase extends RestController {

    protected static final String validEmail = "automation_exercise" + System.currentTimeMillis() + "@test.com";

    //Registration
    public RegisterResponse registerUserAccount(RegisterRequest registerRequest){
        Response response = createUserAccount(registerRequest);

        RegisterResponse registerResponse = null;
        try {
            registerResponse = new ObjectMapper().readValue(response.getBody().print(), RegisterResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return registerResponse;
    }

    protected RegisterRequest createValidUserRequest(String email){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setTitle("Mr");
        registerRequest.setName("Automation Exercise");
        registerRequest.setEmail(email);
        registerRequest.setPassword("AutomationExercise123");
        registerRequest.setBirth_date("1");
        registerRequest.setBirth_month("1");
        registerRequest.setBirth_year("2020");
        registerRequest.setFirstname("Automation");
        registerRequest.setLastname("Exercise");
        registerRequest.setCompany("Florence");
        registerRequest.setAddress1("AutomationExercise1");
        registerRequest.setAddress2("AutomationExercise2");
        registerRequest.setCountry("India");
        registerRequest.setState("Serbia");
        registerRequest.setCity("Belgrade");
        registerRequest.setZipcode("11070");
        registerRequest.setMobile_number("123456789");

        return registerRequest;
    }

    protected void checkSuccessfulRegistrationResponse(RegisterResponse registerResponse) {

        Assert.assertTrue(registerResponse.getResponseCode().equals("201"));
        Assert.assertTrue(registerResponse.getMessage().equals("User created!"));

    }

    //GetUserDetailsByEmail
    public UserResponse getUserDetailsByEmail(String email) {

        Response response = getUserDetails(email);

        UserResponse user = null;
        try {
            user = new ObjectMapper().readValue(response.getBody().print(), UserResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    protected void checkUserDetailsResponse(UserResponse userResponse, RegisterRequest registerRequest) {

        Assert.assertTrue(userResponse.getResponseCode().equals(HttpStatus.SC_OK));
        Assert.assertNotNull(userResponse.getUser().getId());
        Assert.assertEquals(userResponse.getUser().getName(),registerRequest.getName());
        Assert.assertEquals(userResponse.getUser().getEmail(),registerRequest.getEmail());
        Assert.assertEquals(userResponse.getUser().getTitle(),registerRequest.getTitle());
        Assert.assertEquals(userResponse.getUser().getBirth_day(),registerRequest.getBirth_date());
        Assert.assertEquals(userResponse.getUser().getBirth_month(),registerRequest.getBirth_month());
        Assert.assertEquals(userResponse.getUser().getBirth_year(),registerRequest.getBirth_year());
        Assert.assertEquals(userResponse.getUser().getFirst_name(),registerRequest.getFirstname());
        Assert.assertEquals(userResponse.getUser().getLast_name(),registerRequest.getLastname());
        Assert.assertEquals(userResponse.getUser().getCompany(),registerRequest.getCompany());
        Assert.assertEquals(userResponse.getUser().getAddress1(),registerRequest.getAddress1());
        Assert.assertEquals(userResponse.getUser().getCountry(),registerRequest.getCountry());
        Assert.assertEquals(userResponse.getUser().getState(),registerRequest.getState());
        Assert.assertEquals(userResponse.getUser().getCity(),registerRequest.getCity());
        Assert.assertEquals(userResponse.getUser().getZipcode(),registerRequest.getZipcode());

    }

}
