package test_resources;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java_resources.ExternalData;
import java_resources.Payloads;

public class AutoGroupReqSpecs {

	private static String baseUri = ExternalData.getGlobalData("baseUri");
	private static ContentType contentType = ContentType.JSON;
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private static LocalDateTime time;
	
	public static RequestSpecification autoGroupReqSpec()
	{
		PrintStream log = null;
		try
		{
			log = new PrintStream(new FileOutputStream("logging.txt", true));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		time = LocalDateTime.now();
		log.append("\n******************************************************\n");
		log.append("***   AutoGroup Request Sent at: " + dtf.format(time).toString() + "   ***\n");
		log.append("******************************************************\n\n");
		
		// Create a generic RequestSpecification that can be used for all AutoGroup API requests (and not just for AddUserAPI)
		RequestSpecification autoGroupReqSpec =	new RequestSpecBuilder()
												.addFilter(RequestLoggingFilter.logRequestTo(log))
												.addFilter(ResponseLoggingFilter.logResponseTo(log))
												.setBaseUri(baseUri)
												//.addQueryParam(keyQueryParam[0], keyQueryParam[1])
												.setContentType(contentType)
												.build();
		
		return autoGroupReqSpec;
	}
	
	public static RequestSpecification addUserReqSpec(String email, String name)
	{
		RequestSpecification addUserReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec()).body(Payloads.addUserPayload(email, name));
		return addUserReqSpec;
	}
	
	public static RequestSpecification addCarReqSpec(String manufacture, String model, String imageUrl, UUID userId)
	{
		RequestSpecification addCarReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec()).body(Payloads.addCarPayload(manufacture, model, imageUrl, userId));
		return addCarReqSpec;
	}
	
	public static RequestSpecification putCarReqSpec(String manufacture, String model, String imageUrl, UUID userId, UUID car_id)
	{
		RequestSpecification putCarReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec()).body(Payloads.putCarPayload(manufacture, model, imageUrl, userId)).pathParam("id", car_id);
		return putCarReqSpec;
	}
	
	public static RequestSpecification getUserReqSpec(String user_id, String data)
	{
		if (data.equals("invalid")) {
			user_id = "invaliduserid";
		} 
		
		RequestSpecification getUserReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec().pathParam("id", user_id));
		return getUserReqSpec;
		
	}
	
	public static RequestSpecification getCarReqSpec(String car_id, String data)
	{
		if (data.equals("invalid")) {
			car_id = "invalidcarid";
		} 
		
		RequestSpecification getCarReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec().pathParam("id", car_id));
		return getCarReqSpec;
		
	}
	
	public static RequestSpecification deleteCarReqSpec(String car_id, String data)
	{
		if (data.equals("invalid")) {
			car_id = "invalidcarid";
		} 
		
		RequestSpecification deleteCarReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec().pathParam("id", car_id));
		return deleteCarReqSpec;
		
	}
	
	public static RequestSpecification deleteUserReqSpec(String user_id, String data)
	{
		if (data.equals("invalid")) {
			user_id = "invaliduserid";
		} 
		
		RequestSpecification deleteUserReqSpec = given().spec(AutoGroupReqSpecs.autoGroupReqSpec().pathParam("id", user_id));
		return deleteUserReqSpec;
		
	}
}
