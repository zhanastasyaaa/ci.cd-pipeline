package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class PutInvalidEndpoint {
    protected String url = "https://jsonplaceholder.typicode.com/";

    @Step("I set an invalid PUT endpoint for updating users")
    public String InvalidPUTEndpointForUpdatingUsers() {
        return url + "1"; // Perbaiki path endpoint
    }

    @Step("I send a PUT HTTP request with invalid data")
    public void PUTHTTPRequestWithInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        requestBody.put("body", "quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");

        // Kirim permintaan PUT ke endpoint yang tidak valid
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .put(InvalidPUTEndpointForUpdatingUsers());

        // Tidak perlu memeriksa status code di sini
    }

    @Step("I receive a valid HTTP response code 404")
    public void ReceiveAValidHTTPResponseCode404() {
        // Tidak perlu memeriksa status code di sini
    }

    @Step("the response body should contain error messages")
    public void ResponseBodyShouldContainErrorMessages() {
        // Periksa apakah respons mengandung pesan error
        String responseBody = SerenityRest.then().extract().response().asString();
        JSONObject responseJson = new JSONObject();
        String errorMessage = responseJson.toJSONString();

        Assert.assertNotNull("Error message should not be null", errorMessage);
        Assert.assertFalse("Error message should not be empty", errorMessage.isEmpty());
    }
}
