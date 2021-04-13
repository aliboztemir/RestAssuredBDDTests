package java_resources;

// Enum is a special class in Java which is a collection of constants and methods
public enum APIResources{
	AddUserAPI("/api/user"),
	GetUserAPI("/api/user/{id}"),
	DeleteUserAPI("/api/user/{id}"),
	AddCarAPI("/api/car"),
	GetCarAPI("/api/car/{id}"),
	PutCarAPI("/api/car/{id}"),
	DeleteCarAPI("/api/car/{id}"),
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	PutPlaceAPI("/maps/api/place/update/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
