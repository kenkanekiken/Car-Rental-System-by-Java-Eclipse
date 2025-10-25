package data;

public class User {

	private String email;
	private String username;
	private String name;
	private String password;
	/**
	 * Getter of email
	 */
	public String getEmail() {
	 	 return email; 
	}
	/**
	 * Setter of email
	 */
	public void setEmail(String email) { 
		 this.email = email; 
	}
	/**
	 * Getter of username
	 */
	public String getUsername() {
	 	 return username; 
	}
	/**
	 * Setter of username
	 */
	public void setUsername(String username) { 
		 this.username = username; 
	}
	/**
	 * Getter of name
	 */
	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(String name) { 
		 this.name = name; 
	}
	/**
	 * Getter of password
	 */
	public String getPassword() {
	 	 return password; 
	}
	/**
	 * Setter of password
	 */
	public void setPassword(String password) { 
		 this.password = password; 
	}
	/**
	 * 
	 * @return 
	 */
	public boolean verifyLogin(String inputUsername, String inputPassword) { //MANUALLY EDITTED THIS
		if (inputPassword.equals("0") && inputUsername.equals("0")) {
			return true;
		} else { 
			return false;
		}
	 } 
	public User() {
		this.email = null;
		this.name = null;
		this.password = null;
		this.username = null;
	}
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
}
