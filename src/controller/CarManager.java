package controller;

import java.util.List;
import java.util.Vector;

import data.Car;
import data.CarsRentedOut;
import data.DataStorage;

public class CarManager {
	private DataStorage storage;
	private DataStorage ds = new DataStorage();
	
	public DataStorage getStorage() {
	 	 return storage; 
	}
	public void setStorage(DataStorage storage) { 
		 this.storage = storage; 
	}

	// Adding Car details part 
	public void addCar(String modelName, String fuelType, String LicensePlate, String brand, String transmission,
			String modelID, String registrationYear, String vehicleType, int costPerDay, String pathName) {
		Car car = new Car();
		car.setModelName(modelName);
		car.setFuelType(fuelType);
		car.setLicensePlate(LicensePlate);
		car.setBrand(brand);
		car.setTransmission(transmission);
		car.setModelID(modelID);
		car.setRegistrationYear(registrationYear);
		car.setVehicleType(vehicleType);
		car.setCostPerDay(costPerDay);
		car.setPathName(pathName);
		this.ds.storeCar(car);
	}
	
	public Vector<Car> getAllCar() {
		return this.ds.getAllCar();
	}
	public void editCar(int index, Car car) {
		this.ds.editCar(index, car);
	}
	public void deleteCar(int index) {
		this.ds.deleteCar(index);
	}
	
	// Rented out cars
	public void addRentedCar(String modelName, String fuelType, String LicensePlate, String brand, String transmission,
			String modelID, String registrationYear, String vehicleType, int costPerDay, String startDate, String endDate, String pathName) {
		CarsRentedOut rentedCar = new CarsRentedOut();
		rentedCar.setModelName(modelName);
		rentedCar.setFuelType(fuelType);
		rentedCar.setLicensePlate(LicensePlate);
		rentedCar.setBrand(brand);
		rentedCar.setTransmission(transmission);
		rentedCar.setModelID(modelID);
		rentedCar.setRegistrationYear(registrationYear);
		rentedCar.setVehicleType(vehicleType);
		rentedCar.setCostPerDay(costPerDay);
		rentedCar.setStartDate(startDate);
		rentedCar.setEndDate(endDate);
		rentedCar.setPathName(pathName);
		this.ds.storeRentedCar(rentedCar);
	}
	public Vector<CarsRentedOut> getAllRentedCar() {
		return this.ds.getAllRentedCar();
	}
	public void deleteRentedCar(int index) {
		this.ds.deleteRentedCar(index);
	}

	public void saveCarToFile() {
		this.ds.saveCarToFile();
	}
	public void saveRentedCarToFile() {
		this.ds.saveRentedCarToFile();
	}
}
