package data;

import java.util.List;

import controller.Controller;

public class Customer extends User {

	private String licenseNo;
	private String address;
	private List<Booking> bookings;
	private String phoneNumber;
	private boolean authentication;
	/**
	 * Getter of licenseNo
	 */
	public String getLicenseNo() {
	 	 return licenseNo; 
	}
	/**
	 * Setter of licenseNo
	 */
	public void setLicenseNo(String licenseNo) { 
		 this.licenseNo = licenseNo; 
	}
	/**
	 * Getter of address
	 */
	public String getAddress() {
	 	 return address; 
	}
	/**
	 * Setter of address
	 */
	public void setAddress(String address) { 
		 this.address = address; 
	}
	/**
	 * Getter of bookings
	 */
	public List<Booking> getBookings() {
	 	 return bookings; 
	}
	/**
	 * Setter of bookings
	 */
	public void setBookings(List<Booking> bookings) { 
		 this.bookings = bookings; 
	}
	/**
	 * Getter of phoneNumber
	 */
	public String getPhoneNumber() {
	 	 return phoneNumber; 
	}
	/**
	 * Setter of phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) { 
		 this.phoneNumber = phoneNumber; 
	}
	/**
	 * 
	 */
	public void getCustomerInfo() { 
		// TODO Auto-generated method
	 }

	
	public Customer(String address, String licenseNo, String username, String email, String password, String name, String phoneNumber) { 
		super(username,password,name,email);
		this.licenseNo = licenseNo;
		this.address = address;
		this.phoneNumber = phoneNumber;
	 }
	/**
	 * 
	 */
	public Customer() { 
		this.licenseNo = null;
		this.address = null;
		this.phoneNumber = null;
	 } 

}
