package com.restfulbooker.bookinginfo;

import com.restfulbooker.constants.EndPoints;
import com.restfulbooker.model.AuthPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;


public class AuthSteps {

    @Step
    public ValidatableResponse createToken(String userName, String password) {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUserName(userName);
        authPojo.setPassword(password);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(authPojo)
                .when()
                .post(EndPoints.GET_TOKEN)
                .then().log().all();


    }
}
