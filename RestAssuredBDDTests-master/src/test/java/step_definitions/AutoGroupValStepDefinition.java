package step_definitions;

import static org.junit.Assert.*;

import java.util.UUID;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test_resources.Utilities;
import test_resources.AutoGroupReqSpecs;
import test_resources.AutoGroupRespSpecs;

public class AutoGroupValStepDefinition {

	private RequestSpecification autoGroupReqSpec = null;
	private Response autoGroupResponse = null;
	private static String user_id = "";
	private static String car_id = "";

	public static String getUserId() {
		return user_id;
	}

	public static String getCarId() {
		return car_id;
	}

	@Given("a valid AddUserAPI payload with data {string} {string}")
	public void a_valid_add_user_apı_payload_with_data(String email, String name) {
		
		autoGroupReqSpec = AutoGroupReqSpecs.addUserReqSpec(email, name);
	}
	
	@When("{word} request is sent as {word} HTTP request")
	public void request_is_sent_as_http_request(String api, String requestType) {
		// When() part of request
		autoGroupResponse = Utilities.getResource(autoGroupReqSpec, api, requestType);

		// Set user_id using response from AddUserAPI request
		if (api.equalsIgnoreCase("AddUserAPI")) {
			user_id = Utilities.getResponseValue(autoGroupResponse, "id");
		}

		// Set user_id using response from AddCarAPI request
		if (api.equalsIgnoreCase("AddCarAPI")) {
			car_id = Utilities.getResponseValue(autoGroupResponse, "id");
		}
	}

	@Then("success/fail response is sent back with status code {int}")
	public void response_is_sent_back_with_status_code(int code) {
		// Then() part of request
		autoGroupResponse = AutoGroupRespSpecs.applyRespSpec(autoGroupResponse, code);
	}

	@Then("{word} value in response is {string}")
	public void value_in_response_is(String data, String expectedValue) {
		// Retrieve actual value from response
		String actualValue = Utilities.getResponseValue(autoGroupResponse, data);

		// Check actual data value matches expected data value in response
		assertEquals(actualValue, expectedValue);
	}

	@Then("place_id maps to {word} {string} using GetPlaceAPI")
	public void place_id_maps_to_data_using_get_place_api(String data, String expectedValue) {
		// Get data from GetUserAPI response
		String actualValue = Utilities.getResponseValue(autoGroupResponse, data);

		// Check actual data value matches expected data value in response
		assertEquals(actualValue, expectedValue);
	}

	@Then("length of {word} value in response must be greater than zero")
	public void length_of_id_value_in_response_must_be_greater_than_zero(String data) {
		// Get data from GetUserAPI response
		String actualValue = Utilities.getResponseValue(autoGroupResponse, data);
		assertTrue(actualValue.length() > 0);
	}

	@Given("a {word} GetUserAPI request")
	public void a_valid_get_user_api_request(String data) {
		// Given() part of GetUserAPI request
		autoGroupReqSpec = AutoGroupReqSpecs.getUserReqSpec(user_id, data);
	}

	@Given("a {word} GetCarAPI request")
	public void a_valid_get_car_api_request(String data) {
		// Given() part of GetUserAPI request
		autoGroupReqSpec = AutoGroupReqSpecs.getCarReqSpec(getCarId(), data);
	}

	@Given("a {word} DeleteUserAPI request")
	public void a_valid_delete_user_apı_request(String data) {
		// Given() part of DeleteUserAPI request
		autoGroupReqSpec = AutoGroupReqSpecs.deleteUserReqSpec(user_id, data);
	}

	@Given("a valid AddCarAPI payload with data {string} {string} {string}")
	public void a_valid_add_car_apı_payload_with_data(String manufacture, String model, String imageUrl) {
		// Given() part of AddCarAPI request
		UUID userId = UUID.fromString(getUserId());
		autoGroupReqSpec = AutoGroupReqSpecs.addCarReqSpec(manufacture, model, imageUrl, userId);
	}

	@Given("a invalid AddCarAPI payload with data {string} {string} {string}")
	public void a_invalid_add_car_apı_payload_with_data(String manufacture, String model, String imageUrl) {
		// Get data from GetCar response invalid
		UUID userId = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		autoGroupReqSpec = AutoGroupReqSpecs.addCarReqSpec(manufacture, model, imageUrl, userId);
	}

	@Given("a valid PutCarAPI payload with data {string} {string} {string}")
	public void a_valid_put_car_apı_payload_with_data(String manufacture, String model, String imageUrl) {
		// Given() part of PutCarAPI request
		UUID userId = UUID.fromString(getUserId());
		UUID carId = UUID.fromString(getCarId());
		autoGroupReqSpec = AutoGroupReqSpecs.putCarReqSpec(manufacture, model, imageUrl, userId, carId);
	}

	@Given("a invalid PutCarAPI payload with data {string} {string} {string}")
	public void a_invalid_put_car_apı_payload_with_data(String manufacture, String model, String imageUrl) {
		// Given() part of PutCarAPI request invalid
		UUID userId = UUID.fromString(getUserId());
		UUID carId = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		autoGroupReqSpec = AutoGroupReqSpecs.putCarReqSpec(manufacture, model, imageUrl, userId, carId);
	}

	@Given("a {word} DeleteCarAPI request")
	public void a_valid_delete_car_apı_request(String data) {
		// Given() part of DeleteCarAPI request
		autoGroupReqSpec = AutoGroupReqSpecs.deleteCarReqSpec(getCarId(), data);
	}
}
