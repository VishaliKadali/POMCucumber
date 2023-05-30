package steps;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {

	RequestSpecification request = null;
	Response response = null;
	public static String sys_id = null;
	public static String randomDesc = null;

	@Given("set the endpoint")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev104781.service-now.com/api/now/table/";

	}

	@And("add the auth")
	public void addAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "Us/xZ85k@IyN");
	}

	@When("send the request")
	public void sendRequest() {
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
		response = request.get("incident");
	}

	@Then("validate the response")
	public void validateResponse() {
		response.then().log().all().assertThat().statusCode(200);
	}

	@Then("validate the response as {int}")
	public void validate_response(int code) {
		response.then().log().all().assertThat().statusCode(code);
	}

	/*
	 * @And("add the queryParams as {string} and {string}") public void
	 * setQueryParams(String key, String value) { request =
	 * RestAssured.given().log().all().queryParam(key, value); }
	 */

	@And("add the queryParams as {string} and {string}")
	public void setQueryParams(String key, String value) {
		request = RestAssured.given().log().all().queryParam(key, value);
	}

	@When("send the request with QP")
	public void sendRequestwithQP() {
		response = request.get("incident");
	}

	@And("add the queryParams")
	public void addQueryParams(DataTable dt) {
		/*
		 * Map<String,String> new_map=new HashedMap<String, String>();
		 * new_map.put("sysparm_fields", "sys_id,category"); new_map.put("category",
		 * "software");
		 */

		Map<String, String> map_values = dt.asMap();
		request = RestAssured.given().log().all().queryParams(map_values);
	}

	@When("post the request with short description as {string} and category as {string}")
	public void post_the_request_with_short_description_as_and_category_as(String short_desc, String category) {
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
		response= request.body("{\r\n" + "    \"short_description\": \"" + short_desc + "\",\r\n" + "    \"category\": \""
				+ category + "\"\r\n" + "}").post("incident");
	}

	@Then("validate the response for {string} and {string} and {string}")
	public void validate_the_response_for_and_and(String value, String short_desc, String category) {

		response.then().log().all();

		if (value == "1") {
			response.then().assertThat().body("result.category", Matchers.equalTo(category));
		} else if (value == "2") {
			response.then().assertThat().body("result.category", Matchers.not("software,inquiry"));
		} else if (value == "3") {
			response.then().assertThat().body("result.category", Matchers.not("software"));
		} else {
			response.then().assertThat().body("result.short_description", Matchers.notNullValue());
		}

	}

	@When("send the post request")
	public void send_the_post_request() {
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
		response = request
				.body("{\r\n" + "    \"short_description\": \"Cucumber Tags Request incident creation\",\r\n"
						+ "    \"description\": \"Tags incident creation for cucumber assignment 2.\"\r\n" + "}")
				.post("incident");
	}

	// Code for Change request table
	@When("send the request for crTable")
	public void send_the_request_for_crTable() {
		RestAssured.given().body("{\r\n" + "    \"short_description\": \"This short descp for chg req table\",\r\n"
				+ "    \"description\": \"Description given for chg req table.\"\r\n" + "}");
		response = request.post("change_request");
	}

	// code for change req table
	@Then("validate the response for crTable")
	public void validate_the_response_for_crTable() {
		response.then().assertThat().statusCode(201).log().all();
	}

	// send get request
	@Given("send the get request")
	public void send_the_get_request() {
		response = request.get("incident/" + sys_id);

	}

	// validate get request
	@Then("validate the response for get")
	public void validate_the_response_for_get() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Given("send the get request for all incidents")
	public void send_the_get_request_for_all_incidents() {
		response = request.get("incident");
	}

	@Then("validate the response for getAll")
	public void validate_the_response_for_get_all() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Given("send the put request")
	public void send_the_put_request() {
		request.given().body("{\r\n" + "    \"short_description\": \"Put update on Cucumber tags request.\"\r\n" + "}");
		response = request.put("incident/" + sys_id);
	}

	@Then("validate the response for put")
	public void validate_the_response_for_put() {
		response.then().assertThat().statusCode(200).log().all();
	}

	@Given("send the delete request")
	public void send_the_delete_request() {
		response = request.delete("incident/" + sys_id);
	}

	@Then("validate the response for delete")
	public void validate_the_response_for_delete() {
		response.then().assertThat().statusCode(204).log().all();
	}

}
