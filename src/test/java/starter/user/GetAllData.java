package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllData {
    private Response response;

    protected static String url = "https://jsonplaceholder.typicode.com/posts";

    @Step("I set the GET endpoint for user list")
    public String GETEndpointForUserList() {
        return url;
    }
    @Step("I send a GET HTTP request")
    public void SendAGETHTTPRequest() {
         response = SerenityRest.given()
                .when()
                .get(GETEndpointForUserList());
    }
    @Step("I receive a valid HTTP response code 200")
    public void ReceiveAValidHTTPResponseCode200() {

     restAssuredThat(response -> response.statusCode(200));
}
    @Step("I set the GET endpoint for an empty user list")
    public void GETEndpointForAnEmptyUserList() {

    }
    @Step("the response body should be empty")
    public void ResponseBodyShouldBeEmpty() {
        String actualResponseBody = response.getBody().asString();
        System.out.println("Actual Response Body: " + actualResponseBody);
    }


}
