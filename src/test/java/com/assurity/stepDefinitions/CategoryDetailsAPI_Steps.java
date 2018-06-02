package com.assurity.stepDefinitions;

import com.assurity.apiObjects.CategoryDetailsAPI;
import com.thoughtworks.gauge.Step;

public class CategoryDetailsAPI_Steps {

    CategoryDetailsAPI categoryDetailsAPI = new CategoryDetailsAPI();

    @Step ("I make a call to <API_Name> with endpoint <API_EndPoint>")
    public void makeCallToApi(String domainName, String endPoint) {
        categoryDetailsAPI.loadTheCategoryDetailsApi(domainName, endPoint);
    }

    @Step ("When I found the API is working well with out any error")
    public void apiIsWorking() {
        categoryDetailsAPI.checkTheApiIsWorking();
    }

    @Step ("Then I see the attribute <Attribute> is <value>")
    public void validateTheAttributeWithValue(String attribute, String value) {
        categoryDetailsAPI.checkTheResponseForAttributeAndValue(attribute, value);
    }

    @Step ("And I see the attribute <Attribute> is <value>")
    public void validateTheAttributeWithValue(String attribute, boolean value) {
        categoryDetailsAPI.checkTheResponseForAttributeAndValue(attribute, value);
    }

    @Step ("And I check the promotions with name <promotionName> has a description and the description contains <expectedValueInDescription>")
    public void checkThePromotionAndTheDescription(String promotionName, String valueToCheckInDescription) {
        categoryDetailsAPI.checkTheDescriptionForTheGivenPromotion(promotionName, valueToCheckInDescription);
    }
}
