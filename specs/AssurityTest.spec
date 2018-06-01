# Assurity API Tests

This specification file has tests about Category Details API

Tags : Smoke-API-CategoryDetails, Regression-API-Tests

    |Base_Url|API_EndPoint|
    |--------|------------|
    |BaseApiUrlTest|/v1/Categories/6327/Details.json?catalogue=false|

## Category Details API Test

* I make a call to <Base_Url> with endpoint <API_EndPoint>
* When I found the API is working well with out any error
* Then I see the attribute "Name" is "Carbon credits"
* And I see the attribute "CanRelist" is "true"
* And I check the promotions with name "Gallery" has a description and the description contains "2x larger image"







