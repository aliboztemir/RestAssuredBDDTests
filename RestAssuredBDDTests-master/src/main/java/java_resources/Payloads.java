package java_resources;

import java.util.UUID;

import pojo.AddCar;
import pojo.AddUser;
import pojo.PutCar;

public class Payloads {

	public static AddUser addUserPayload(String email,String name)
	{
		AddUser addUser = new AddUser();
		
		addUser.setEmail(email);
		addUser.setName(name);
		
		return addUser;
	}
	
	public static AddCar addCarPayload(String manufacture,String model, String imageUrl, UUID userId)
	{
		AddCar addCar = new AddCar();
		
		addCar.setManufacture(manufacture);
		addCar.setModel(model);
		addCar.setImageUrl(imageUrl);
		addCar.setUserId(userId);
		
		return addCar;
	}
	
	public static PutCar putCarPayload(String manufacture,String model, String imageUrl, UUID userId)
	{
		PutCar putCar = new PutCar();
		
		putCar.setManufacture(manufacture);
		putCar.setModel(model);
		putCar.setImageUrl(imageUrl);
		putCar.setUserId(userId);
		
		return putCar;
	}
	
}
