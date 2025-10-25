package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.Car;
import data.Customer;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;

public class CustomerInfoScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame main;
	private Vector<Customer> cus;
	private JTable table;
	private JLabel lblCarImage, lblWelcome;
	/**
	 * Create the panel.
	 */
	public CustomerInfoScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(361, 133, 569, 422);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblCustomerInfo = new JLabel("All Customer Information");
		lblCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCustomerInfo.setBounds(491, 43, 369, 37);
		add(lblCustomerInfo);
		
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
		btnAddCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("addcar");
			}
		});
		btnAddCars.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddCars.setBounds(43, 243, 219, 36);
		panel.add(btnAddCars);
		
		JButton btnCarListing = new JButton("View Cars Listing");
		btnCarListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("carlisting");
			}
		});
		btnCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarListing.setBounds(43, 302, 219, 36);
		panel.add(btnCarListing);
		
		JButton btnBooking = new JButton("View Bookings");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("bookingScreen");
			}
		});
		btnBooking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBooking.setBounds(43, 361, 219, 36);
		panel.add(btnBooking);
		
		JButton btnSalesReport = new JButton("Sales Report");
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("saleslog");
			}
		});
		btnSalesReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalesReport.setBounds(43, 421, 219, 36);
		panel.add(btnSalesReport);
		
		JButton btnCustomerInfo = new JButton("Customers Info");
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("customerInfo");
			}
		});
		btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCustomerInfo.setBounds(43, 479, 219, 36);
		panel.add(btnCustomerInfo);
		
		JButton btnReturnCar = new JButton("Return Cars");
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
		populateTable();
	}
	public void populateTable() {
		cus = this.main.getController().getAllUsers();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"Username", "Name", "Email", "PhoneNum", "LicenseNo", "Address"});
		for (int i = 0; i < cus.size(); i++) {
			Customer temp = cus.get(i);
			model.addRow(new Object[] {
					temp.getUsername(),
					temp.getName(),
					temp.getEmail(),
					temp.getPhoneNumber(),
					temp.getLicenseNo(),
					temp.getAddress()
			});
		}
		this.table.setModel(model);
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
}
