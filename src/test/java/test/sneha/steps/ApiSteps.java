package test.sneha.steps;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.sneha.ApiManager;


public class ApiSteps {
	Response response;
	ApiManager apiManager;

	public ApiSteps(ApiManager diApiManager) {
		this.apiManager = diApiManager;
	}

	@When("^I execute get request on \"([^\"]*)\"$")
	public void i_execute_get_request_on(String URI) {
		this.response = apiManager.getQuary(URI);
	}

	@Then("^I expect \"([^\"]*)\"$")
	public void i_expect(int statusCode) {
		response.then().statusCode(statusCode);
	}
}
