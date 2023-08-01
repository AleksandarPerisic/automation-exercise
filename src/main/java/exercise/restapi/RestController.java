package exercise.restapi;

import exercise.config.Paths;
import exercise.models.RegisterRequest;
import io.restassured.response.Response;

public class RestController extends RestCalls{

    private static final String USER_DETAILS_BY_EMAIL_URI = Paths.BASE_URL + Paths.BACKEND_API + Paths.GET_USER_DETAILS_BY_EMAIL;
    private static final String CREATE_USER_ACCOUNT = Paths.BASE_URL + Paths.BACKEND_API + Paths.CREATE_ACCOUNT;

    protected Response getUserDetails(String email){

        String URL = USER_DETAILS_BY_EMAIL_URI+"?email="+email;
        return RestCalls.getRequest(URL);
    }

    protected Response createUserAccount(RegisterRequest registerRequest){

        return RestCalls.createUserRequest(CREATE_USER_ACCOUNT,registerRequest);

    }



}
