package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONString;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class PutData {
    protected static String url = "https://jsonplaceholder.typicode.com/";
    private JSONString requestBodyJson;

    @Step("I set the PUT endpoint for updating users")
    public String PUTEndpointForUpdatingUsers() {
        return url + "posts/1";
    }

    @Step("I have valid user data for update")
    public JSONObject validUserDataForUpdate() {
        JSONObject requestBodyJson = new JSONObject();
        requestBodyJson.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        requestBodyJson.put("body", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        return requestBodyJson;
    }

    @Step("I send a PUT HTTP request with valid data")
    public void PUTHTTPRequestWithValidData() {
        JSONObject requestBodyJson = validUserDataForUpdate(); // Mendapatkan data JSON yang valid
        if (requestBodyJson != null) {
            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .body(requestBodyJson.toJSONString())
                    .put(PUTEndpointForUpdatingUsers());
        } else {
            Assert.fail("Request body is null");
        }
    }

    @Step("I receive valid HTTP response code 200")
    public void ReceiveValidHTTPResponseCode200() {
        SerenityRest.then().statusCode(200);
    }
}
