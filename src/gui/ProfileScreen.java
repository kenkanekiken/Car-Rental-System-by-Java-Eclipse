package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;

import controller.MainFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class ProfileScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblName, lblUsername, lblEmail, lblLicenseno, lblPhonenumber, lblAddress, lblCarImage, lblWelcome;
	private MainFrame main;
	/**
	 * Create the panel.
	 */
	public ProfileScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblProfile = new JLabel("My Profile");
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblProfile.setBounds(581, 37, 166, 43);
		add(lblProfile);
		
		JLabel lblNameLabel = new JLabel("Name:");
		lblNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNameLabel.setBounds(477, 258, 336, 25);
		add(lblNameLabel);
		
		lblName = new JLabel("-");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(647, 261, 268, 19);
		add(lblName);
		
		JLabel lblUsernameLabel = new JLabel("Username:");
		lblUsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsernameLabel.setBounds(477, 210, 336, 25);
		add(lblUsernameLabel);
		
		lblUsername = new JLabel("-");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(647, 213, 268, 19);
		add(lblUsername);
		
		JLabel lblEmailLabel = new JLabel("Email:");
		lblEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailLabel.setBounds(477, 312, 336, 25);
		add(lblEmailLabel);
		
		lblEmail = new JLabel("-");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(647, 315, 268, 19);
		add(lblEmail);
		
		JLabel lblLicenseLabel = new JLabel("LicenseNo: ");
		lblLicenseLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLicenseLabel.setBounds(477, 367, 336, 25);
		add(lblLicenseLabel);
		
		lblLicenseno = new JLabel("-");
		lblLicenseno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLicenseno.setBounds(647, 370, 268, 19);
		add(lblLicenseno);
		
		JLabel lblPhoneNumberLabel = new JLabel("PhoneNumber: ");
		lblPhoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNumberLabel.setBounds(477, 422, 336, 25);
		add(lblPhoneNumberLabel);
		
		lblPhonenumber = new JLabel("-");
		lblPhonenumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhonenumber.setBounds(647, 425, 268, 19);
		add(lblPhonenumber);
		
		JLabel lblAddressLabel = new JLabel("Address:");
		lblAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddressLabel.setBounds(477, 482, 336, 25);
		add(lblAddressLabel);
		
		lblAddress = new JLabel("-");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(647, 485, 268, 19);
		add(lblAddress);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(0, 0, 300, 700);
		add(panel);
		
		lblWelcome = new JLabel("Welcome, ");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcome.setBounds(75, 163, 215, 30);
		panel.add(lblWelcome);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/user-icon-leader.png"));
		Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		this.lblCarImage = new JLabel();
		lblCarImage.setBounds(95, 53, 100, 100);
		lblCarImage.setIcon(resizedIcon);
		panel.add(lblCarImage);
		
		JButton btnViewCarListing = new JButton("Book Cars");
		btnViewCarListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("browser");
			}
		});
		btnViewCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewCarListing.setBounds(43, 243, 219, 36);
		panel.add(btnViewCarListing);
		
		JButton btnGoCart = new JButton("Go to Cart");
		btnGoCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("bookingcart");
			}
		});
		btnGoCart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoCart.setBounds(43, 302, 219, 36);
		panel.add(btnGoCart);
		
		JButton btnBookingHistory = new JButton("Bookings History");
		btnBookingHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("bookingHistory");
			}
		});
		btnBookingHistory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBookingHistory.setBounds(43, 361, 219, 36);
		panel.add(btnBookingHistory);
		
		JButton btnProfile = new JButton("Your Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("profile");
			}
		});
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProfile.setBounds(43, 421, 219, 36);
		panel.add(btnProfile);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("login");
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(43, 594, 219, 36);
		panel.add(btnLogout);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);

	}
	public void addProfileDetails(String username, String name, String email, String license, String phonenumber, String address) {
		lblName.setText(name);
		lblUsername.setText(username);
		lblEmail.setText(email);
		lblLicenseno.setText(license);
		lblPhonenumber.setText(phonenumber);
		lblAddress.setText(address);
		lblWelcome.setText("Welcome, " + username);
	}
	public String getUsername() {
		return this.lblUsername.getText();
	}

}
