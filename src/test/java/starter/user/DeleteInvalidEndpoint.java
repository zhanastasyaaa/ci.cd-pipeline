package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteInvalidEndpoint {
    protected String url = "https://jsonplaceholder.typicode.com/";
    @Step("I set the DELETE Invalid endpoint")
    public String DELETEInvalidEndpoint() {
        return url + "/1";
    }

    @Step("I send a DELETE Invalid HTTP request")
    public void DELETEInvalidHTTPRequest() {
        SerenityRest.given().delete(DELETEInvalidEndpoint());
    }

    @Step("I received valid HTTP response code 404")
    public void ReceivedValidHTTPResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
