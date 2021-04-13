package pojo;

import java.util.UUID;

public class PutCar 
{
		private String manufacture;
		private String model;
		private String imageUrl;
		private UUID userId;
		
		public String getManufacture() 
		{
			return manufacture;
		}
		
		public void setManufacture(String manufacture) 
		{
			this.manufacture = manufacture;
		}
		
		public String getModel() 
		{
			return model;
		}
		
		public void setModel(String model) 
		{
			this.model = model;
		}
		
		public String getImageUrl() 
		{
			return imageUrl;
		}
		
		public void setImageUrl(String imageUrl) 
		{
			this.imageUrl = imageUrl;
		}
		
		
		public UUID getUserId() 
		{
			return userId;
		}
		
		public void setUserId(UUID userId) 
		{
			this.userId = userId;
		}
}