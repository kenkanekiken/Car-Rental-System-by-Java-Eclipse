package controller;

import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.Car;
import data.CompletedBooking;
import data.Customer;
import data.DataStorage;
import data.Staff;


public class Controller {
	private DataStorage datastorage;
	public DataStorage getDataStorage() {
		return datastorage;
	}
	
	public void setDatastorage(DataStorage datastorage) { 
		 this.datastorage = datastorage; 
	}
	
	private DataStorage ds = new DataStorage();
	
	public Vector<Customer> getAllUsers() {
		return this.ds.getAllUsers();
	}
	
	public void regUser(String username, String password, String name, String email, 
			String licenseNo, String address, String phoneNumber) { 
		Customer customer = new Customer();
		customer.setName(name);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setLicenseNo(licenseNo);
		customer.setPhoneNumber(phoneNumber);
		this.ds.storeUser(customer);
	 }
	
	public boolean verifyLogin(String inputUsername, String inputPassword) {
		Customer username = ds.getUser(inputUsername);
		if (username != null) {
			if (inputPassword.equals(username.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public boolean verifyStaffLogin(String inputUsername, String inputPassword) {
		Staff username = ds.getStaff(inputUsername);
		if (username != null) {
			if (inputPassword.equals(username.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public void regStaff(String n, String p) {
		Staff staff = new Staff();
		staff.setUsername(n);
		staff.setPassword(p);
		this.ds.storeStaff(staff);
	}
	
	public String[] getUserInfo(String username) {
		Customer username2 = ds.getUser(username);
		String[] info = {username2.getUsername(), username2.getName(), 
					username2.getEmail(), username2.getLicenseNo(), username2.getPhoneNumber(), username2.getAddress()};
		return info;
	}
	
	public Vector<String> getUsername() {
		return this.ds.getUsername();
	}

	public void saveCustomerToFile() {
		this.ds.saveCustomerToFile();
	}
	
}
