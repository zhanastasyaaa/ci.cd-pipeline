package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.*;


public class UserSteps {

    @Steps
    GetAllData getAllData;

    @Steps
    PostCreateData postCreateData;

    @Steps
    PostInvalidEndpoint postInvalidEndpoint;

    @Steps
    GetDataById getDataById;

    @Steps
    GetDataByIdInvalidEndpoint getDataByIdInvalidEndpoint;

    @Steps
    PutData putData;

    @Steps
    PutInvalidEndpoint putInvalidEndpoint;

    @Steps
    DeleteByID deleteByID;

    @Steps
    DeleteInvalidEndpoint deleteInvalidEndpoint;

    //GET All Data - positive
    @Given("I set the GET endpoint for user list")
    public void GETEndpointForUserList() {
        getAllData.GETEndpointForUserList();
    }

    @When("I send a GET HTTP request")
    public void SendAGETHTTPRequest() {
        getAllData.SendAGETHTTPRequest();

    }

    @Then("I receive a valid HTTP response code 200")
    public void ReceiveAValidHTTPResponseCode200() {
        getAllData.ReceiveAValidHTTPResponseCode200();
    }

    //GET All Data - negative
    @Given("I set the GET endpoint for an empty user list")
    public void GETEndpointForAnEmptyUserList() {
        getAllData.GETEndpointForAnEmptyUserList();
    }

    @And("the response body should be empty")
    public void theResponseBodyShouldBeEmpty() {
        getAllData.ResponseBodyShouldBeEmpty();
    }

    //POST - positive
    @Given("I set the POST endpoint for creating users")
    public void POSTEndpointForCreatingUsers() {
        postCreateData.POSTEndpointForCreatingUsers();
    }

    @And("I have valid user data")
    public void ValidUserData() {
        postCreateData.ValidUserData();
    }

    @When("I send a POST HTTP request with valid data")
    public void POSTHTTPRequestWithValidData() {
        postCreateData.POSTHTTPRequestWithValidData();
    }

    @Then("I receive a valid HTTP response code 201")
    public void ReceiveAValidHTTPResponseCode201() {
        postCreateData.ReceiveAValidHTTPResponseCode201();
    }

    @And("the response body should contain the newly created user details")
    public void ResponseBodyShouldContainTheNewlyCreatedUserDetails() {
        postCreateData.ResponseBodyShouldContainTheNewlyCreatedUserDetails();
    }

    //POST - Negative
    @Given("I set POST Invalid endpoints")
    public void POSTInvalidEndpoints() {
        postInvalidEndpoint.POSTInvalidEndpoints();
    }

    @When("I send POST Invalid HTTP request")
    public void POSTInvalidHTTPRequest() {
        postInvalidEndpoint.POSTInvalidHTTPRequest();
    }

    @Then("I receive valid HTTP response code 404")
    public void ReceiveValidHTTPResponseCode404() {
        postInvalidEndpoint.ReceiveValidHTTPResponseCode404();
    }

    //GET BY ID - POSITIVE
    @Given("I set the GET by ID endpoint with user ID")
    public void GETByIDEndpointwithuserId() {
        getDataById.GETByIDEndpointwithuserId();
    }

    @When("I send a GET by ID HTTP request")
    public void GETByIDHTTPRequest() {
        getDataById.sendGETByIDHTTPRequest();
    }

    @Then("I receives a valid HTTP response code 200")
    public void ReceivesAValidHTTPResponseCode200() {
        getDataById.ReceivesAValidHTTPResponseCode200();
    }

    @And("I receive valid data for detail user")
    public void ReceiveValidDataForDetailUser() {
        getDataById.ReceiveValidDataForDetailUser();
    }

    //GET BY ID - NEGATIVE
    @Given("I set the GET by ID endpoint")
    public void GETByIDEndpoint() {
        GetDataByIdInvalidEndpoint.GETByIDEndpoint();
    }
    @When("I send GET by ID HTTP request")
    public void sendGETByIDHTTPRequest() {
        getDataByIdInvalidEndpoint.GETByIDHTTPRequest();
    }
    @Then("I receive a valid HTTP response code 404")
    public void ValidHTTPResponseCode400() {
        getDataByIdInvalidEndpoint.ValidHTTPResponseCode400();
    }

    //PUT BY ID - POSITIVE
    @Given("I set the PUT endpoint for updating users")
    public void PUTEndpointForUpdatingUsers() {
        putData.PUTEndpointForUpdatingUsers();
    }

    @When("I send a PUT HTTP request with valid data")
    public void PUTHTTPRequestWithValidData()  {
        putData.PUTHTTPRequestWithValidData();
    }

    @Then("I receive valid HTTP response code 200")
    public void ReceiveValidHTTPResponseCode200() {
        putData.ReceiveValidHTTPResponseCode200();
    }

    //PUT BY ID - NEGATIVE

    @Given("I set an invalid PUT endpoint for updating users")
    public void InvalidPUTEndpointForUpdatingUsers() {
       putInvalidEndpoint.InvalidPUTEndpointForUpdatingUsers();
    }

    @When("I send a PUT HTTP request with invalid data")
    public void PUTHTTPRequestWithInvalidData() {
        putInvalidEndpoint.PUTHTTPRequestWithInvalidData();
    }

    @Then("I received a valid HTTP response code 404")
    public void ReceivedAValidHTTPResponseCode404() {
        putInvalidEndpoint.ReceiveAValidHTTPResponseCode404();
    }

    @And("the response body should contain error messages")
    public void ResponseBodyShouldContainErrorMessages() {
        putInvalidEndpoint.ResponseBodyShouldContainErrorMessages();
    }

    //DELETE BY ID - POSITIVE
    @Given("I set the DELETE endpoint for deleting users")
    public void DELETEEndpointForDeletingUsers() {
        deleteByID.DELETEEndpointForDeletingUsers();
    }

    @When("I send a DELETE HTTP request")
    public void DELETEHTTPRequest() {
        deleteByID.DELETEHTTPRequest();
    }
    @Then("I received valid HTTP response code 200")
    public void ReceivedValidHTTPResponseCode200() {
        deleteByID.ReceivedValidHTTPResponseCode200();
    }

    //DELETE BY ID - NEGATIVE

    @Given("I set the DELETE Invalid endpoint")
    public void DELETEInvalidEndpoint() {
        deleteInvalidEndpoint.DELETEInvalidEndpoint();
    }
    @When("I send a DELETE Invalid HTTP request")
    public void DELETEInvalidHTTPRequest() {
        deleteInvalidEndpoint.DELETEInvalidHTTPRequest();
    }
    @Then("I received valid HTTP response code 404")
    public void ReceivedValidHTTPResponseCode404() {
        deleteInvalidEndpoint.ReceivedValidHTTPResponseCode404();
    }


}


