package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetDataByIdInvalidEndpoint {
    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set the GET by ID endpoint")
    public static String GETByIDEndpoint() {
        return url + "/1";
    }
    @Step("I send GET by ID HTTP request")
    public void GETByIDHTTPRequest() {
        SerenityRest.given()
                .when()
                .get(GETByIDEndpoint());
    }

    @Step("I receive a valid HTTP response code 404")
    public void ValidHTTPResponseCode400() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
