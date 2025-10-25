package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Car;
import data.CarsRentedOut;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class ReturnCarScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JList list;
	private JLabel lblCarImage, lblWelcome;
	private Vector<Car> car;
	private Vector<CarsRentedOut> rentedCar;
	private MainFrame main;
	private int index, costPerDay;
	private String brand, modelName, modelID, fuelType, transmission, licensePlate, regYear, vehicleType, pathName;

	/**
	 * Create the panel.
	 */
	public ReturnCarScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(353, 156, 270, 395);
		add(scrollPane);
		
		list = new JList();
		list.setForeground(new Color(251, 4, 79));
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(673, 156, 270, 395);
		add(scrollPane_1);
		
		table = new JTable();
		table.setBackground(new Color(0, 255, 64));
		scrollPane_1.setViewportView(table);
		
		JLabel lblCarRentedOut = new JLabel("Cars Rented Out");
		lblCarRentedOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarRentedOut.setBounds(411, 121, 157, 25);
		add(lblCarRentedOut);
		
		JLabel lblCarAvaliable = new JLabel("Cars On Listings");
		lblCarAvaliable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCarAvaliable.setBounds(747, 121, 152, 25);
		add(lblCarAvaliable);

		JButton btnReturnCar = new JButton("Return Car");
		btnReturnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = list.getSelectedIndex();
				if (index == -1) {
					return;
				}
				for (int i = 0; i < rentedCar.size(); i++) {
					CarsRentedOut temp = rentedCar.get(index);
					brand = temp.getBrand();
					modelName = temp.getModelName();
					modelID = temp.getModelID();
					fuelType = temp.getFuelType();
					licensePlate = temp.getLicensePlate();
					transmission = temp.getTransmission();
					regYear = temp.getRegistrationYear();
					vehicleType = temp.getVehicleType();
					costPerDay = Integer.valueOf(temp.getCostPerDay());
					pathName = temp.getPathName();
				}
				main.getCarManager().addCar(modelName, fuelType, licensePlate, brand, transmission, modelID, regYear, vehicleType, costPerDay, pathName);
				main.getCarManager().saveCarToFile();
				main.getCarManager().deleteRentedCar(index);
				main.getCarManager().saveRentedCarToFile();
				populateTable();
				populateList();
				main.getCarListingScreen().removeAllCars();
				main.getCarListingScreen().populatePanel();
			}
		});
		btnReturnCar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnCar.setBounds(353, 600, 590, 37);
		add(btnReturnCar);
		
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
				main.getSalesLogScreen().populateCompletedBookingTable();
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
		
		JButton btnReturnCar_1 = new JButton("Return Cars");
		btnReturnCar_1.setBackground(new Color(255, 255, 255));
		btnReturnCar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("returncar");
			}
		});
		btnReturnCar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturnCar_1.setBounds(43, 537, 219, 36);
		panel.add(btnReturnCar_1);
		
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
		separator.setForeground(new Color(128, 128, 128));
		separator.setBackground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);
		
		JLabel lblReturnCar = new JLabel("Return of Cars");
		lblReturnCar.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReturnCar.setBounds(556, 44, 230, 32);
		add(lblReturnCar);
	}
	public void populateTable() {
		car = this.main.getCarManager().getAllCar();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"ModelName", "ModelID", "LicensePlate"});
		for (int i = 0; i < car.size(); i++) {
			Car temp = car.get(i);
			model.addRow(new Object[] {
				    temp.getModelName(), 
					temp.getModelID(), 
					temp.getLicensePlate()
			});
		}
		this.table.setModel(model);
	}
	public void populateList() {
		rentedCar = this.main.getCarManager().getAllRentedCar();
		DefaultListModel modelList = new DefaultListModel();
		for (int i = 0; i < rentedCar.size(); i++) {
			CarsRentedOut temp = rentedCar.get(i);
			String display = "ModelID: " + temp.getModelID() + " StartDate: " + temp.getStartDate() + " ReturnDate: " + temp.getEndDate();
			modelList.addElement(display);
		}
		this.list.setModel(modelList);
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
}
