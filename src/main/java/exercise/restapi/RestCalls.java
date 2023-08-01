package exercise.restapi;

import exercise.models.RegisterRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.ZonedDateTime;

public class RestCalls {

    protected static Response postRequest(String uriString, Object requestBody) {

        RequestSpecification specification = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestBody);

        Response response = specification.post(uriString);
        logResponseInfo(response);

        return response;
    }

    protected static Response getRequest(String uriString) {
        RequestSpecification specification = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON);

        Response response = specification.get(uriString);
        logResponseInfo(response);

        return response;
    }

    protected static Response putRequest(String uriString, Object requestBody) {
        RequestSpecification specification = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(requestBody);

        Response response = specification.put(uriString);
        logResponseInfo(response);

        return response;
    }

    protected static Response createUserRequest(String uriString, RegisterRequest requestBody) {

        RequestSpecification specification = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.MULTIPART)
                .multiPart("title",requestBody.getTitle())
                .multiPart("name",requestBody.getName())
                .multiPart("email",requestBody.getEmail())
                .multiPart("password",requestBody.getPassword())
                .multiPart("birth_date",requestBody.getBirth_date())
                .multiPart("birth_month",requestBody.getBirth_month())
                .multiPart("birth_year",requestBody.getBirth_year())
                .multiPart("firstname",requestBody.getFirstname())
                .multiPart("lastname",requestBody.getLastname())
                .multiPart("company",requestBody.getCompany())
                .multiPart("address1",requestBody.getAddress1())
                .multiPart("country",requestBody.getCountry())
                .multiPart("state",requestBody.getState())
                .multiPart("city",requestBody.getCity())
                .multiPart("zipcode",requestBody.getZipcode())
                .multiPart("mobile_number",requestBody.getMobile_number());

        Response response = specification.post(uriString);
        logResponseInfo(response);

        return response;
    }


    protected static void logResponseInfo(Response response) {
        System.out.println("Response timestamp: " + ZonedDateTime.now());

        String statusCode = String.valueOf(response.statusCode());
        System.out.println("Response status code: " + statusCode);

        if (statusCode.startsWith("4") || statusCode.startsWith("5")) {
            response.prettyPrint();
        }
    }

}
