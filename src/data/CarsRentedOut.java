package data;

public class CarsRentedOut {
	
	private String transmission;
	private String vehicleType;
	private int costPerDay;
	private String brand;
	private String fuelType;
	private String modelID;
	private String modelName;
	private String registrationYear;
	private String licensePlate;
	private String startDate;
	private String endDate;
	private String pathName;
	
	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getTransmission() {
	 	 return transmission; 
	}

	public void setTransmission(String transmission) { 
		 this.transmission = transmission; 
	}

	public String getVehicleType() {
	 	 return vehicleType; 
	}

	public void setVehicleType(String vehicleType) { 
		 this.vehicleType = vehicleType; 
	}

	public int getCostPerDay() {
	 	 return costPerDay; 
	}

	public void setCostPerDay(int costPerDay) { 
		 this.costPerDay = costPerDay; 
	}

	public String getBrand() {
	 	 return brand; 
	}

	public void setBrand(String brand) { 
		 this.brand = brand; 
	}

	public String getFuelType() {
	 	 return fuelType; 
	}

	public void setFuelType(String fuelType) { 
		 this.fuelType = fuelType; 
	}

	public String getModelID() {
	 	 return modelID; 
	}

	public void setModelID(String modelID) { 
		 this.modelID = modelID; 
	}

	public String getModelName() {
	 	 return modelName; 
	}

	public void setModelName(String modelName) { 
		 this.modelName = modelName; 
	}

	public String getRegistrationYear() {
	 	 return registrationYear; 
	}

	public void setRegistrationYear(String registrationYear) { 
		 this.registrationYear = registrationYear; 
	}

	public String getLicensePlate() {
	 	 return licensePlate; 
	}

	public void setLicensePlate(String licensePlate) { 
		 this.licensePlate = licensePlate; 
	}

	public CarsRentedOut() { 
		this.modelName = null;
		this.fuelType = null;
		this.licensePlate = null;
		this.brand = null;
		this.transmission = null;
		this.modelID = null;
		this.registrationYear = null;
		this.vehicleType = null;
		this.costPerDay = 0;
		this.pathName = null;
	 }

	public CarsRentedOut(String modelName, String fuelType, String licensePlate, String brand, String transmission, String modelID, String registrationYear, int costPerDay, String vehicleType, String startDate, String endDate, String pathName) { 
		this.modelName = modelName;
		this.fuelType = fuelType;
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.transmission = transmission;
		this.modelID = modelID;
		this.registrationYear = registrationYear;
		this.costPerDay = costPerDay;
		this.vehicleType = vehicleType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pathName = pathName;
	 }

}
