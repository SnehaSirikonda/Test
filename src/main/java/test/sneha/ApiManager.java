package test.sneha;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;

public class ApiManager {

	final String BASE_URL = "http://jsonplaceholder.typicode.com";

	public Response getQuary(String URI) {
		return given().when().get(BASE_URL+URI);
	}
	
	public Response deleteQuary(String URI) {
		return given().when().put(BASE_URL+URI);
	}
}
