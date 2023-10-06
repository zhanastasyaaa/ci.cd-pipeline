package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetDataById {

    protected static String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set the GET by ID endpoint with user ID ")
    public String GETByIDEndpointwithuserId() {
        return url + "posts/1";
    }

    @Step("I send a GET by ID HTTP request")
    public void sendGETByIDHTTPRequest() {
        SerenityRest.given()
                .when()
                .get(GETByIDEndpointwithuserId() );
    }
    @Step("I receives valid HTTP response code 200")
    public void ReceivesAValidHTTPResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for detail user")
    public void ReceiveValidDataForDetailUser() {
        restAssuredThat(response -> response.body("'userId'", equalTo(1)));
        restAssuredThat(response -> response.body("'id'", equalTo(1)));
        restAssuredThat(response -> response.body("'title'", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
        restAssuredThat(response -> response.body("'body'", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")));
    }



}
