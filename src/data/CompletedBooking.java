package data;

public class CompletedBooking {
	private int costPerDay;
	private int rentingDays;
	private String bookingID;
	private String cusUsername; 
	private String modelID;
	private String modelName;
	private String startDate;
	private String endDate;
	private Car car;
	private DataStorage storage;
	
	public int getRentingDays() {
		return rentingDays;
	}

	public void setRentingDays(int rentingDays) {
		this.rentingDays = rentingDays;
	}
	public int getCostPerDay() {
	 	 return costPerDay; 
	}

	public void setCostPerDay(int costPerDay) { 
		 this.costPerDay = costPerDay; 
	}

	public Car getCar() {
	 	 return car; 
	}

	public void setCar(Car car) { 
		 this.car = car; 
	}

	public String getBookingID() {
	 	 return bookingID; 
	}

	public void setBookingID(String bookingID) { 
		 this.bookingID = bookingID; 
	}

	public DataStorage getStorage() {
	 	 return storage; 
	}

	public void setStorage(DataStorage storage) { 
		 this.storage = storage; 
	}

	public double displayRentalCost() { 
		// TODO Auto-generated method
		return 0;
	 }
	public String generateBookingID() { 
		// TODO Auto-generated method
		return null;
	 }
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCusUsername() {
		return cusUsername;
	}

	public void setCusUsername(String cusUsername) {
		this.cusUsername = cusUsername;
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String modelID) {
		this.modelID = modelID;
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

	public CompletedBooking() { 
		this.costPerDay = 0;
		this.rentingDays = 0;
		this.bookingID = null;
		this.cusUsername = null;
		this.modelID = null;
		this.modelName = null;
		this.startDate = null;
		this.endDate = null;
	 }
	public CompletedBooking(String bookingID, int costPerDay, int rentingDays, String cusUsername, String modelID, String modelName, String startDate, String endDate) { 
		this.bookingID = bookingID;
		this.costPerDay = costPerDay;
		this.cusUsername = cusUsername;
		this.modelID = modelID;
		this.modelName = modelName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rentingDays = rentingDays;
	 }
}
