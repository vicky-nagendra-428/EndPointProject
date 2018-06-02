package com.assurity.apiObjects;

import com.assurity.common.ApiExecutor;
import com.assurity.util.EnvironmentSetup;
import com.thoughtworks.gauge.Gauge;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CategoryDetailsAPI {

    ApiExecutor apiExecutor = new ApiExecutor();

    public void loadTheCategoryDetailsApi(String domainOfCategotyDetails, String categoryDetailsEndPoint) {
        apiExecutor.loadTheEndPoint_GetMethod(EnvironmentSetup.getBaseAddress(domainOfCategotyDetails) + categoryDetailsEndPoint);
        Gauge.writeMessage("Loaded the end point successfully : " + categoryDetailsEndPoint);
    }

    public void checkTheApiIsWorking() {

        apiExecutor.checkResponseCodeIs(200);
        Gauge.writeMessage("The response code is 200");
    }

    public void checkTheResponseForAttributeAndValue(String attribute, Object expectedValue) {
        assertEquals(expectedValue, apiExecutor.getResponse().then().extract().path(attribute));
    }

    public void checkTheDescriptionForTheGivenPromotion(String promotionName, String valueToCheckInDescription) {

        boolean foundTheRequiredPromotion = false;
        List<HashMap<String, Object>> promotionsList = apiExecutor.getResponse().jsonPath().getList("Promotions");

        for (HashMap<String, Object> promotion : promotionsList) {

            if (!promotion.containsKey("Name")) {
                continue;
            }
            else if (promotion.get("Name").toString().equalsIgnoreCase(promotionName)) {
                assertTrue("The Promotion : " + promotionName + " expected to have description. But no description attribute found " , promotion.containsKey("Description"));

                String actualDescription = promotion.get("Description").toString();
                assertTrue("The Promotion : " + promotionName + " expected to contain : " + valueToCheckInDescription + " in \n" + actualDescription,
                        actualDescription.contains(valueToCheckInDescription));
                foundTheRequiredPromotion = true;
                break;
            }

        }

        assertTrue("Could not found a Promotion with the name : " + promotionName, foundTheRequiredPromotion);
    }

}
