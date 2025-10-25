package data;

import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;

public class DataStorage {
	
	private XStream xstream; 
	// Customer 
	Vector<Customer> customer = new Vector<Customer>();
	
	public void storeUser(Customer u) {
		this.customer.add(u);
	}
	
	public Vector<Customer> getAllUsers() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public Customer getUser(String n) {
		for (int i = 0; i < customer.size(); i++) {
			Customer temp = customer.get(i);
			if (temp.getUsername().equals(n)) {
				return temp;
			}
		}
		return null;
	}
	
	// Staff 
	Vector<Staff> staff = new Vector<Staff>();
	
	public void storeStaff(Staff s) {
		this.staff.add(s);
	}
	
	public Vector<Staff> getAllStaff() {
		return staff;
	}
	
	public Staff getStaff(String n) {
		for (int i = 0; i < staff.size(); i ++) {
			Staff temp = staff.get(i);
			if (temp.getUsername().equals(n)) {
				return temp;
			}
		}
		return null;
	}

	// Car 
	Vector<Car> car = new Vector<Car>();
	
	public void storeCar(Car car) {
		this.car.add(car);
	}
	
	public Vector<Car> getAllCar() {
		return car;
	}
	
	public Car getCar(String id) {
		for (int i = 0; i < car.size(); i++) {
			Car temp = car.get(i);
			if (temp.getModelID().equals(id)) {
				return temp;
			}
		}
		return null;
	}
	

	public void editCar(int index, Car newcar) {
		this.car.set(index, newcar);
	}

	public void deleteCar(int index) {
		this.car.remove(index);
	}

	// Bookings
	Vector<Booking> bookings = new Vector<Booking>();
	
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}

	public Customer getUserUsername(String n) {
		for (int i = 0; i < customer.size(); i++) {
			Customer temp = customer.get(i);
			if (temp.getUsername().equals(n)) {
				return temp;
			}
		}
		return null;
	}

	public Vector<Booking> getAllBookings() {
		return bookings;
	}
	public void editBooking(int index, Booking booking) {
		this.bookings.set(index, booking);
	}

	public void deleteBooking(int index) {
		this.bookings.remove(index);
	}

	
	// Completed Bookings
	Vector<CompletedBooking> completedBooking = new Vector<CompletedBooking>();
	
	public void addCompletedBooking(CompletedBooking complete) {
		this.completedBooking.add(complete);
	}

	public Vector<CompletedBooking> getAllCompletedBookings() {
		return completedBooking;
	}
	
	public Vector<String> getUsername() {
		Vector<String> username = new Vector<String>();
		for (int i = 0; i < customer.size(); i++) {
			Customer temp = customer.get(i);
			username.add(temp.getUsername());
		}
		return username;
	}

	// Rented Cars 
	Vector<CarsRentedOut> rentedCar = new Vector<CarsRentedOut>();
	
	public void storeRentedCar(CarsRentedOut rentedCar) {
		this.rentedCar.add(rentedCar);
	}
	public Vector<CarsRentedOut> getAllRentedCar() {
		return rentedCar;
	}

	public void deleteRentedCar(int index) {
		this.rentedCar.remove(index);
	}
	
	// Constructor
	public DataStorage() {
		this.xstream = new XStream();
		this.xstream.allowTypesByWildcard(new String[] { "data.*"});
		
		try {
			
			Customer[] customerArr = (Customer[]) this.xstream.fromXML(new File("saves/customers.xml"));
			for (int i = 0; i < customerArr.length; i++) {
				this.customer.add(customerArr[i]);
			}
			
			Staff[] staffArr = (Staff[]) this.xstream.fromXML(new File("saves/staffs.xml"));
			for (int i = 0; i < staffArr.length; i++) {
				this.staff.add(staffArr[i]);
			}
			
			Car[] carArr = (Car[]) this.xstream.fromXML(new File("saves/cars.xml"));
			for (int i = 0; i < carArr.length; i++) {
				this.car.add(carArr[i]);
			}
			
			Booking[] bookingArr = (Booking[]) this.xstream.fromXML(new File("saves/bookings.xml"));
			for (int i = 0; i < bookingArr.length; i++) {
				this.bookings.add(bookingArr[i]);
			}
			
			CompletedBooking[]  completedBookingArr = (CompletedBooking[]) this.xstream.fromXML(new File("saves/completedbookings.xml"));
			for (int i = 0; i < completedBookingArr.length; i++) {
				this.completedBooking.add(completedBookingArr[i]);
			}
			
			CarsRentedOut[]  rentedCarArr = (CarsRentedOut[]) this.xstream.fromXML(new File("saves/rentedcars.xml"));
			for (int i = 0; i < rentedCarArr.length; i++) {
				this.rentedCar.add(rentedCarArr[i]);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	// Save To File XML
	public void saveCarToFile() {
		Car[] carArr = new Car[this.car.size()];
		this.car.toArray(carArr);	
		String carXML = this.xstream.toXML(carArr);
		
		try {
			FileWriter carFW = new FileWriter("saves/cars.xml");
			carFW.write(carXML);
			carFW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveBookingToFile() {
		Booking[] bookingArr = new Booking[this.bookings.size()];
		this.bookings.toArray(bookingArr);	
		String bookingXML = this.xstream.toXML(bookingArr);
		
		try {
			FileWriter bookingFW = new FileWriter("saves/bookings.xml");
			bookingFW.write(bookingXML);
			bookingFW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveCompletedBookingToFile() {
		CompletedBooking[] completedBookingArr = new CompletedBooking[this.completedBooking.size()];
		this.completedBooking.toArray(completedBookingArr);	
		String completedBookingXML = this.xstream.toXML(completedBookingArr);
		
		try {
			FileWriter completedBookingFW = new FileWriter("saves/completedbookings.xml");
			completedBookingFW.write(completedBookingXML);
			completedBookingFW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveRentedCarToFile() {
		CarsRentedOut[] rentedCarArr = new CarsRentedOut[this.rentedCar.size()];
		this.rentedCar.toArray(rentedCarArr);	
		String rentedCarXML = this.xstream.toXML(rentedCarArr);
		
		try {
			FileWriter rentedCarFW = new FileWriter("saves/rentedcars.xml");
			rentedCarFW.write(rentedCarXML);
			rentedCarFW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveCustomerToFile() {
		Customer[] customerArr = new Customer[this.customer.size()];
		this.customer.toArray(customerArr);
		String customerXML = this.xstream.toXML(customerArr);
		
		try {
			FileWriter customerFW = new FileWriter("saves/customers.xml");
			customerFW.write(customerXML);
			customerFW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
