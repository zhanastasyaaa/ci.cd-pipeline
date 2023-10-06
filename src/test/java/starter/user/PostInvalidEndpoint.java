package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostInvalidEndpoint {
    protected String url = "https://jsonplaceholder.typicode.com/Post123";


    // POST - Negative

    @Step("I set POST Invalid endpoints")
    public String POSTInvalidEndpoints() {
        return url ;
    }

    @Step("I send POST Invalid HTTP request")
    public void POSTInvalidHTTPRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "id minus libero illum nam ad officiis");
        requestBody.put("body", "earum voluptatem facere provident blanditiis velit laboriosam"
        );

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url);
    }

    @Step("I receive valid HTTP response code 404")
    public void ReceiveValidHTTPResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
