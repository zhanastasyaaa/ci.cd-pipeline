package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteByID {
    protected String url = "https://jsonplaceholder.typicode.com/";
    @Step("I set the DELETE endpoint for deleting users")
    public String DELETEEndpointForDeletingUsers() {
        return url + "posts/1";
    }
    @Step("I send a DELETE HTTP request")
    public void DELETEHTTPRequest() {
        SerenityRest.given().delete(DELETEEndpointForDeletingUsers());
    }
    @Step("I received valid HTTP response code 200")
    public void ReceivedValidHTTPResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
