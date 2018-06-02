package com.assurity.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.core.IsNull;

public class ApiExecutor {

    private Response response;

    public Response loadTheEndPoint_GetMethod(String endPoint) {
        response = RestAssured.get(endPoint);
        response.then().log().ifError();
        return response;
    }

    public Response getResponse() {
        if (response == null) {

        }
        return response;
    }

    public void checkResponseCodeIs(int expectedResponseCode) {
        response.then().assertThat().statusCode(expectedResponseCode);
    }

}
