package controller;

import java.util.List;
import java.util.Vector;

import data.Booking;
import data.CompletedBooking;
import data.Customer;
import data.DataStorage;

public class BookingManager {

	private Vector<Booking> bookings;
	private DataStorage ds = new DataStorage();

	
	public Vector<Booking> getAllBookings() {
	 	 return this.ds.getAllBookings();
	}

	public void setBookings(Vector<Booking> bookings) { 
		 this.bookings = bookings; 
	}

	public void addBooking(String bookingID, String modelID, String modelName, String cusUsername, int costPerDay, int rentingDays, String startDate, String endDate, String pathName) { 
		Booking booking = new Booking();
		booking.setBookingID(bookingID);
		booking.setModelID(modelID);
		booking.setModelName(modelName);
		booking.setCusUsername(cusUsername);
		booking.setCostPerDay(costPerDay);
		booking.setRentingDays(rentingDays);
		booking.setStartDate(startDate);
		booking.setEndDate(endDate);
		booking.setPathName(pathName);
		this.ds.addBooking(booking);
	 }


	public void editBooking(int index, Booking booking) { 
		this.ds.editBooking(index, booking);
	 }

	public void deleteBooking(int index) {
		this.ds.deleteBooking(index);
	}

	public void addCompletedBooking(String bookingID, String modelID, String modelName, String cusUsername, int costPerDay, int rentingDays, String startDate, String endDate) {
		CompletedBooking complete = new CompletedBooking();
		complete.setBookingID(bookingID);
		complete.setModelID(modelID);
		complete.setModelName(modelName);
		complete.setCusUsername(cusUsername);
		complete.setCostPerDay(costPerDay);
		complete.setRentingDays(rentingDays);
		complete.setStartDate(startDate);
		complete.setEndDate(endDate);
		this.ds.addCompletedBooking(complete);
	}

	public Vector<CompletedBooking> getAllCompletedBookings() {
		return this.ds.getAllCompletedBookings();
	}

	public void saveBookingToFile() {
		this.ds.saveBookingToFile();
	}

	public void saveCompletedBookingToFile() {
		this.ds.saveCompletedBookingToFile();
	}

}
