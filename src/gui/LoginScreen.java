package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.Controller;
import controller.MainFrame;
import data.Booking;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private MainFrame main;
	private JButton btnLogin;
	private JLabel lblCarImage;

	/**
	 * Create the panel.
	 */
	public LoginScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login to Account");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogin.setBounds(74, 142, 249, 48);
		add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(83, 229, 79, 13);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(83, 284, 79, 13);
		add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(83, 247, 213, 27);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(83, 301, 213, 27);
		add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				boolean loginStatus = main.getController().verifyLogin(username, password);
				boolean loginStatusStaff = main.getController().verifyStaffLogin(username, password);
				if (loginStatus) {
					String[] info = main.getController().getUserInfo(username);
					main.getProfileScreen().addProfileDetails(info[0], info[1], info[2], info[3], info[4], info[5]);
					main.getBrowserScreen().setWelcometxt(username);
					main.getBookingCartScreen().setWelcometxt(username);
					main.getBookingHistoryScreen().setWelcometxt(username);
					main.getCheckOutScreen().setWelcometxt(username);
					main.getBrowserScreen().removeAllCars();
					main.getBrowserScreen().populatePanel();
					main.getBookingCartScreen().removeAllCars();
					main.getBookingCartScreen().populatePanel();
					main.showPanel("browser");
					txtUsername.setText("");
					txtPassword.setText("");
				} else if (loginStatusStaff) {
					main.getAddCarScreen().setWelcometxt(username);
					main.getCarListingScreen().setWelcometxt(username);
					main.getStaffBookingScreen().setWelcometxt(username);
					main.getSalesLogScreen().setWelcometxt(username);
					main.getCustomerInfo().setWelcometxt(username);
					main.getReturnCarScreen().setWelcometxt(username);
					main.getCarListingScreen().removeAllCars();
					main.getCarListingScreen().populatePanel();
					main.showPanel("addcar");
					txtUsername.setText("");
					txtPassword.setText("");
				} else {
					String msg = "Login failure. Either username or password is incorrect.";
					JOptionPane.showMessageDialog(null, msg, "Login Failure", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(83, 397, 213, 38);
		add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("reg");
			}
		});
		btnRegister.setBounds(83, 477, 213, 38);
		add(btnRegister);
		
		JLabel lblRegister = new JLabel("Want to register an account?");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRegister.setBounds(103, 451, 193, 16);
		add(lblRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(372, 0, 629, 700);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCarRental = new JLabel("Welcome to MK Car Rental Service");
		lblCarRental.setForeground(new Color(0, 0, 0));
		lblCarRental.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblCarRental.setBounds(78, 117, 497, 97);
		panel.add(lblCarRental);


		ImageIcon icon = new ImageIcon(getClass().getResource("/img/car_grey_image.png"));
		Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		this.lblCarImage = new JLabel();
		lblCarImage.setBounds(174, 252, 300, 300);
		lblCarImage.setIcon(resizedIcon);
		panel.add(lblCarImage);
	}
}
