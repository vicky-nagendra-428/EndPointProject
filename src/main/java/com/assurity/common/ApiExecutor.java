package com.assurity.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiExecutor {

    private Response response;

    public Response loadTheEndPointGetMethod(String endPoint) {
        response = RestAssured.get(endPoint);
        response.then().log().ifError();
        return response;
    }

    public Response getResponse() {
        return response;
    }

    public void checkResponseCodeIs(int expectedResponseCode) {
        response.then().assertThat().statusCode(expectedResponseCode);
    }

}
