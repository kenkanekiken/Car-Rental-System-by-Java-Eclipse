package gui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Booking;
import data.CompletedBooking;
import data.Customer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class StaffBookingsScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox comboBox;
	private Vector<CompletedBooking> booking;
	private MainFrame main;
	private JLabel lblCarImage, lblWelcome;

	/**
	 * Create the panel.
	 */
	public StaffBookingsScreen(MainFrame main) {
		this.main = main;
		setLayout(null);

		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateTable();
			}
		});
		comboBox.setBounds(495, 160, 314, 34);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 272, 541, 337);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblUsername = new JLabel("Select Customer Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(526, 121, 260, 29);
		add(lblUsername);
		
		JLabel lblBooking = new JLabel("Booking Details");
		lblBooking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBooking.setBounds(572, 222, 159, 29);
		add(lblBooking);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(0, 0, 300, 700);
		add(panel);
		
		lblWelcome = new JLabel("Welcome, xxx");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWelcome.setBounds(75, 163, 161, 30);
		panel.add(lblWelcome);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/car_grey_image.png"));
		Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		this.lblCarImage = new JLabel();
		lblCarImage.setBounds(75, 25, 150, 150);
		lblCarImage.setIcon(resizedIcon);
		panel.add(lblCarImage);
		
		JButton btnAddCars = new JButton("Add Cars");
		btnAddCars.setBackground(new Color(255, 255, 255));
		btnAddCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("addcar");
			}
		});
		btnAddCars.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddCars.setBounds(43, 243, 219, 36);
		panel.add(btnAddCars);
		
		JButton btnCarListing = new JButton("View Cars Listing");
		btnCarListing.setBackground(new Color(255, 255, 255));
		btnCarListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("carlisting");
			}
		});
		btnCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarListing.setBounds(43, 302, 219, 36);
		panel.add(btnCarListing);
		
		JButton btnBooking = new JButton("View Bookings");
		btnBooking.setBackground(new Color(255, 255, 255));
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getStaffBookingScreen().populateTable();
				main.showPanel("bookingScreen");
			}
		});
		btnBooking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBooking.setBounds(43, 361, 219, 36);
		panel.add(btnBooking);
		
		JButton btnSalesReport = new JButton("Sales Report");
		btnSalesReport.setBackground(new Color(255, 255, 255));
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("saleslog");
			}
		});
		btnSalesReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalesReport.setBounds(43, 421, 219, 36);
		panel.add(btnSalesReport);
		
		JButton btnCustomerInfo = new JButton("Customers Info");
		btnCustomerInfo.setBackground(new Color(255, 255, 255));
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("customerInfo");
			}
		});
		btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCustomerInfo.setBounds(43, 479, 219, 36);
		panel.add(btnCustomerInfo);
		
		JButton btnReturnCar = new JButton("Return Cars");
		btnReturnCar.setBackground(new Color(255, 255, 255));
		btnReturnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getReturnCarScreen().populateList();
				main.getReturnCarScreen().populateTable();
				main.showPanel("returncar");
			}
		});
		btnReturnCar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnCar.setBounds(43, 537, 219, 36);
		panel.add(btnReturnCar);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 255, 255));
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
		
		JLabel lblNewLabel = new JLabel("View Bookings");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(555, 32, 252, 45);
		add(lblNewLabel);
		populateComboBox();
		populateTable();
	}
	public void populateComboBox() {
		comboBox.removeAllItems();
		Vector<String> usernames = main.getController().getUsername();
		for (String name: usernames) {
			comboBox.addItem(name);
		}
	}
	public void populateTable() {
		table.removeAll();
		booking = this.main.getBookingManager().getAllCompletedBookings();
		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(new String[] {"Username", "BookingID", "ModelName", "ModelID", "DaysRented", "StartDate", "ReturnDate"});
		if (comboBox.getSelectedItem() != null) {
			for (int i = 0; i < booking.size(); i++) {
				CompletedBooking temp = booking.get(i);
				if(comboBox.getSelectedItem().equals(temp.getCusUsername())) {
					model.addRow(new Object[] {
							temp.getCusUsername(),
							temp.getBookingID(),
							temp.getModelName(),
							temp.getModelID(),
							temp.getRentingDays(),
							temp.getStartDate(),
							temp.getEndDate()
					});
				}
			}
		}
		this.table.setModel(model);
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
}
