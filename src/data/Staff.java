package data;

import controller.CarManager;

public class Staff extends User {

	private String staffID;
	private CarManager carmanager;
	private DataStorage storage; // ADDED MANUALLY
	private boolean authentication;
	/**
	 * Getter of staffID
	 */
	public String getStaffID() {
	 	 return staffID; 
	}
	/**
	 * Setter of staffID
	 */
	public void setStaffID(String staffID) { 
		 this.staffID = staffID; 
	}
	/**
	 * Getter of carmanager
	 */
	public CarManager getCarmanager() {
	 	 return carmanager; 
	}
	/**
	 * Setter of carmanager
	 */
	public void setCarmanager(CarManager carmanager) { 
		 this.carmanager = carmanager; 
	}
	/**
	 * 
	 * @param inputPassword 
	 * @param inputUsername 
	 */
	public void login(String inputUsername, String inputPassword) { // MANUALLY EDITTED THIS
		authentication = verifyLogin(inputUsername, inputPassword);
		if (authentication) {
			// Approve login
		} else {
			// Denied login , display login error
		}
	 }
	/**
	 * 
	 * @param username 
	 * @param staffID 
	 * @param password 
	 * @param name 
	 * @param email 
	 */
	public Staff(String username, String staffID, String password, String name, String email) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public Staff() { 
		super();
		this.staffID = null;
	 }
	/**
	 * 
	 */
	public void getStaffInfo() { 
		//
	 } 

}
