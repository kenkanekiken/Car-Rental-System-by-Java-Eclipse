package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.Booking;
import data.Car;
import data.CompletedBooking;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class CheckOutScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private Vector<Booking> booking;
	private Vector<Car> car;
	private MainFrame main;
	private JLabel lblBill, lblReturnDate, lblCarImage, lblWelcome;
	private String endDate, startDate;
	private int index;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public CheckOutScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblCheckout = new JLabel("Checking Out");
		lblCheckout.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCheckout.setBounds(557, 35, 204, 48);
		add(lblCheckout);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
			}
		});
		scrollPane.setBounds(362, 128, 573, 319);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(0, 0, 300, 700);
		add(panel);
		
		lblWelcome = new JLabel("Welcome, xxx");
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
				main.getBookingHistoryScreen().populateBookingTable();
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
		
		lblBill = new JLabel("Your total bill is: ");
		lblBill.setBounds(362, 480, 318, 21);
		add(lblBill);
		lblBill.setForeground(new Color(0, 0, 0));
		lblBill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		lblReturnDate = new JLabel("Return the car by: ");
		lblReturnDate.setBounds(362, 530, 318, 21);
		add(lblReturnDate);
		lblReturnDate.setForeground(new Color(0, 0, 0));
		lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBounds(774, 528, 161, 27);
		add(btnPay);
		btnPay.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Have to complete all logic here.
				Booking temp = booking.get(index); 
				String username = temp.getCusUsername();
				main.getBookingManager().addCompletedBooking(temp.getBookingID(), temp.getModelID(), temp.getModelName(), temp.getCusUsername(),
						temp.getCostPerDay(), temp.getRentingDays(), temp.getStartDate(), temp.getEndDate());
				main.getBookingManager().saveCompletedBookingToFile();
				main.getBookingManager().deleteBooking(index); 
				main.getBookingManager().saveBookingToFile();
				main.getSalesLogScreen().populateCompletedBookingTable();
				car = main.getCarManager().getAllCar();
				for (int i = 0; i < car.size(); i++) {
					Car temp2 = car.get(i);
					if (temp2.getModelID().equals(temp.getModelID())) {
						main.getCarManager().addRentedCar(temp2.getModelName(), temp2.getFuelType(), temp2.getLicensePlate(), temp2.getBrand(), 
								temp2.getTransmission(), temp2.getModelID(), temp2.getRegistrationYear(), temp2.getVehicleType(), 
								temp2.getCostPerDay(), temp.getStartDate(), temp.getEndDate(), temp.getPathName());
						main.getCarManager().saveRentedCarToFile();
						main.getCarManager().deleteCar(i);
						main.getCarManager().saveCarToFile();
					}
				}
				int result = JOptionPane.showConfirmDialog(null, "You have succesfully make a payment, kindly come down to MK Rental on " + startDate + " to collect the car and return the car by " + endDate, "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				main.getBookingHistoryScreen().populateBookingTable();
				main.getCarListingScreen().removeAllCars();
				main.getCarListingScreen().populatePanel();
				main.getBrowserScreen().removeAllCars();
				main.getBrowserScreen().populatePanel();
				main.getBookingCartScreen().removeAllCars();
				main.getBookingCartScreen().populatePanel();
				table.removeAll();
				main.showPanel("bookingHistory");
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(337, 83, 632, 18);
		add(separator);
	}
	
	public void populateCheckOutTable(int index) {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"BookingID", "ModelName","ModelID", "Price/Day", "DaysRented", "StartDate", "ReturnDate"});
		booking = main.getBookingManager().getAllBookings();
		Booking temp = booking.get(index);
		endDate = temp.getEndDate();
		startDate = temp.getStartDate();
		model.addRow(new Object[] {
				temp.getBookingID(),
				temp.getModelName(),
				temp.getModelID(),
				"$" + temp.getCostPerDay(),
				temp.getRentingDays(),
				startDate,
				endDate
			});
			this.table.setModel(model);
	}
	public int totalBill(int i) {
		booking = main.getBookingManager().getAllBookings();
		System.out.println(booking);
		Booking temp = booking.get(i);
		int totalbill = 0;
		totalbill = temp.getCostPerDay() * temp.getRentingDays();
		return totalbill;
	}
	public void setBillLabel(String bill) {
		lblBill.setText("Your total bill is: $" + bill);
	}
	public void setReturnLabel() {
		lblReturnDate.setText("Please return the car by: " + endDate);
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
}
