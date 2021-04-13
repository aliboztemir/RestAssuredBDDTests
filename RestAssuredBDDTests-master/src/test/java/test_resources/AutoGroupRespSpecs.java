package test_resources;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class AutoGroupRespSpecs {

	//private static String[] serverHeader = {"server", "Apache/2.4.18 (Ubuntu)"};
	//private static ContentType contentType = ContentType.JSON;
	
	public static ResponseSpecification responseSpec(int statusCode)
	{
		// Create a generic ResponseSpecification that can be used for all AutoGroup API responses (and not just for AddUserAPI)
		ResponseSpecification placeRespSpec =	new ResponseSpecBuilder()
													.expectStatusCode(statusCode)
													//.expectContentType(contentType)
													//.expectHeader(serverHeader[0], serverHeader[1])
													.build();
		
		return placeRespSpec;
	}
	
	public static Response applyRespSpec(Response response, int statusCode)
	{
		Response appliedResponse = response.then()
				 				   .spec(responseSpec(statusCode))//.body("scope", equalTo("OK"))
				 				   .extract().response();
		
		return appliedResponse;
	}
}
