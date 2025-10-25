package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import controller.MainFrame;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JSeparator;

public class RegisterScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JTextField txtName;
	private JTextField txtLicenseNo;
	private JTextField txtPhoneNo;
	private MainFrame main;
	private JTextField txtAddress;
	private JLabel lblCarImage;
	/**
	 * Create the panel.
	 */
	public RegisterScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblRegister = new JLabel("Register Account");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegister.setBounds(551, 85, 228, 48);
		add(lblRegister);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(675, 225, 73, 13);
		add(lblEmail);
		
		this.txtEmail = new JTextField();
		txtEmail.setBounds(675, 248, 177, 28);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(473, 164, 85, 13);
		add(lblUsername);
		
		this.txtUsername = new JTextField();
		txtUsername.setBounds(473, 187, 177, 28);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		this.txtPassword = new JPasswordField();
		txtPassword.setBounds(675, 187, 177, 28);
		add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(675, 164, 79, 13);
		add(lblPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(473, 225, 70, 13);
		add(lblName);
		
		this.txtName = new JTextField();
		txtName.setBounds(473, 248, 175, 28);
		add(txtName);
		txtName.setColumns(10);
		
		this.txtLicenseNo = new JTextField();
		txtLicenseNo.setBounds(473, 309, 175, 27);
		add(txtLicenseNo);
		txtLicenseNo.setColumns(10);
		
		JLabel lblLicenseNo = new JLabel("LicenseNo");
		lblLicenseNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicenseNo.setBounds(473, 286, 85, 13);
		add(lblLicenseNo);
		
		this.txtPhoneNo = new JTextField();
		txtPhoneNo.setBounds(675, 309, 177, 27);
		add(txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("PhoneNumber");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhoneNumber.setBounds(675, 286, 83, 13);
		add(lblPhoneNumber);
			
		this.txtAddress = new JTextField();
		txtAddress.setBounds(473, 375, 379, 27);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(473, 346, 85, 19);
		add(lblAddress);

		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				String name = txtName.getText();
				String email = txtEmail.getText();
				String license = txtLicenseNo.getText();
				String address = txtAddress.getText();
				String phone = txtPhoneNo.getText();
				//!modelName.trim().isEmpty() && !modelID.trim().isEmpty() && !regYear.trim().isEmpty() && !license.trim().isEmpty() && brand != null && fuelType != null && vehicleType != null && transmission != null && price > 0
				if (!username.trim().isEmpty() && !password.trim().isEmpty() && !name.trim().isEmpty() && !email.trim().isEmpty() && !license.trim().isEmpty() && !address.trim().isEmpty() && !phone.trim().isEmpty()) {
					main.getController().regUser(username, password, name, email, license, address, phone);
					main.getController().saveCustomerToFile();
					main.showPanel("login");
					txtUsername.setText("");
					txtPassword.setText("");
					txtName.setText("");
					txtEmail.setText("");
					txtLicenseNo.setText("");
					txtAddress.setText("");
					txtPhoneNo.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Please fill in all the blanks!");
				}
			}
		});
		btnRegister.setBounds(473, 468, 379, 34);
		add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("login");
			}
		});
		btnBack.setBounds(473, 512, 379, 34);
		add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(0, 0, 300, 700);
		add(panel);
		
		JLabel lblCarRental = new JLabel("Welcome to MK Car Rental Service");
		lblCarRental.setForeground(new Color(0, 0, 0));
		lblCarRental.setFont(new Font("Agency FB", Font.BOLD, 23));
		lblCarRental.setBounds(20, 112, 280, 119);
		panel.add(lblCarRental);
		
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/car_grey_image.png"));
		Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		this.lblCarImage = new JLabel();
		lblCarImage.setBounds(0, 195, 300, 300);
		lblCarImage.setIcon(resizedIcon);
		panel.add(lblCarImage);
		
	}
}
