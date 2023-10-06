package starter.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class PostCreateData {
    protected static String url = "https://jsonplaceholder.typicode.com/posts";
    private RequestSpecification request;
    private Response response;

    // POST - positive
    @Step("I set the POST endpoint for creating users")
    public void POSTEndpointForCreatingUsers() {
        request = RestAssured.given().baseUri(url);
    }

    @Step("I have valid user data")
    public void ValidUserData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "dolorem eum magni eos aperiam quia");
        requestBody.put("body", "repudiandae veniam quaerat sunt sed");

        request.body(requestBody.toJSONString()).contentType(ContentType.JSON);
    }

    @Step("I send a POST HTTP request with valid data")
    public void POSTHTTPRequestWithValidData() {
        response = request.when().post();
    }

    @Step("I receive a valid HTTP response code 201")
    public void ReceiveAValidHTTPResponseCode201() {
        response.then().statusCode(201);
    }

    @Step("the response body should contain the newly created user details")
    public void ResponseBodyShouldContainTheNewlyCreatedUserDetails() {
        response.then().body("title", equalTo("dolorem eum magni eos aperiam quia"));
        response.then().body("body", equalTo("repudiandae veniam quaerat sunt sed"));
    }


}
