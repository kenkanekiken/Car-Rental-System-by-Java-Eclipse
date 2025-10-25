package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import controller.MainFrame;
import data.Booking;
import data.Car;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

public class StaffCarListingScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtbrand, txtmodelName, txtfuelType, txtlicensePlate, txttransmission, txtmodelID, txtregYear, txtvehicleType, txtcostPerDay;
	private MainFrame main;
	private Vector<Car> car;
	private int index;
	private JPanel carListPanel;
	private JLabel lblCarImage, lblWelcome;
	private String resourcePath = null;
	/**
	 * Create the panel.
	 */
	public StaffCarListingScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(360, 133, 583, 508);
		add(panelContainer);
		panelContainer.setLayout(new BorderLayout(0, 0));
		
		carListPanel = new JPanel();
		carListPanel.setLayout(new BoxLayout(carListPanel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane(carListPanel);
		panelContainer.add(scrollPane);

		txtbrand = new JTextField();
		txtmodelName = new JTextField();
		txtfuelType = new JTextField();
		txtlicensePlate = new JTextField();
		txttransmission = new JTextField();
		txtmodelID = new JTextField();
		txtregYear = new JTextField();
		txtvehicleType = new JTextField();
		txtcostPerDay = new JTextField();
	
		
		JLabel lblCarsListings = new JLabel("All Cars Listing");
		lblCarsListings.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCarsListings.setBounds(549, 38, 217, 46);
		add(lblCarsListings);
		
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
				main.showPanel("browswer");
			}
		});
		btnCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarListing.setBounds(43, 302, 219, 36);
		panel.add(btnCarListing);
		
		JButton btnBooking = new JButton("View Bookings");
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
	}
	
	public void populatePanel(String brand, String modelName, String modelID, int price, String regYear, String Trans, String vehType, String fuel, String license, String pathName) {
		
		final JPanel singleCarPanel = new JPanel();
		singleCarPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mouse Cursor
		singleCarPanel.setLayout(new BoxLayout(singleCarPanel, BoxLayout.Y_AXIS));
		singleCarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		

		switch (pathName) {
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\audi-image.png":
		        resourcePath = "/img/audi-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\bmw-image.png":
		        resourcePath = "/img/bmw-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\porsche-image.png":
		        resourcePath = "/img/porsche-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\volkswagen-image.png":
		        resourcePath = "/img/volkswagen-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\mini-image.png": 
		        resourcePath = "/img/mini-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\chrysler-image.png":
		        resourcePath = "/img/chrysler-image.png";
		        break;
		    case "C:\\Users\\kenne\\OneDrive\\Desktop\\lamborghini-image.png":
		        resourcePath = "/img/lamborghini-image.png";
		        break;
		    default:
		        System.out.println("Unknown path: " + pathName);
		        break;
		}

		if (resourcePath != null) {
		    ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
		    Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		    ImageIcon resizedIcon = new ImageIcon(scaledImage);
		    
		    this.lblCarImage = new JLabel();
		    lblCarImage.setBounds(85, 34, 200, 200);
		    lblCarImage.setIcon(resizedIcon);
		    
		    singleCarPanel.add(lblCarImage);
		}
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("Brand: " + brand));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("ModelName: " + modelName));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("ModelID: " + modelID));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("Price: " + price));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("RegYear: " + regYear));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("Trans: " + Trans));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("vehType: " + vehType));
		singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
		singleCarPanel.add(new JLabel("Fuel: " + fuel));
		singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10))); // spacing
		singleCarPanel.add(new JLabel("LicensePlate: " + license));
		singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		JButton btnEdit = new JButton("Edit Car");
		singleCarPanel.add(btnEdit);
		singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10)));
		JButton btnDelete = new JButton("Delete Car");
		singleCarPanel.add(btnDelete);
		singleCarPanel.add(Box.createRigidArea(new Dimension(10, 18)));
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = carListPanel.getComponentZOrder(singleCarPanel);
			    System.out.println("Clicked panel index: " + index);
			    car = main.getCarManager().getAllCar();
			    Car temp = car.get(index);
				txtbrand.setText(temp.getBrand());
				txtmodelName.setText(temp.getModelName());
				txtmodelID.setText(temp.getModelID());
				txtcostPerDay.setText(String.valueOf(temp.getCostPerDay()));
				txtregYear.setText(temp.getRegistrationYear());
				txttransmission.setText(temp.getTransmission());
				txtvehicleType.setText(temp.getVehicleType());
				txtfuelType.setText(temp.getFuelType());
				txtlicensePlate.setText(temp.getLicensePlate());
				final JComponent[] inputs = new JComponent[] {
						new JLabel("brand"),
						txtbrand,
						new JLabel("modelName"),
						txtmodelName,
						new JLabel("fuelType"),
						txtfuelType,
						new JLabel("licensePlate"),
						txtlicensePlate,
						new JLabel("transmission"),
						txttransmission,
						new JLabel("modelID"),
						txtmodelID,
						new JLabel("registrationYear"),
						txtregYear,
						new JLabel("vehicleType"),
						txtvehicleType,
						new JLabel("costPerDay"),
						txtcostPerDay
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Edit Car Details", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					String newBrand = txtbrand.getText();
					String newName = txtmodelName.getText();
					String newFuelType = txtfuelType.getText();
					String newLicensePlate = txtlicensePlate.getText();
					String newTransmission = txttransmission.getText();
					String newID = txtmodelID.getText();
					String newRegYear = txtregYear.getText();
					String newVehicleType = txtvehicleType.getText();
					int newCostPerDay = Integer.valueOf(txtcostPerDay.getText());
					Car temp2 = car.get(index);
					temp2.setBrand(newBrand);
					temp2.setModelName(newName);
					temp2.setFuelType(newFuelType);
					temp2.setLicensePlate(newLicensePlate);
					temp2.setTransmission(newTransmission);
					temp2.setModelID(newID);
					temp2.setRegistrationYear(newRegYear);
					temp2.setVehicleType(newVehicleType);
					temp2.setCostPerDay(newCostPerDay);
					main.getCarManager().editCar(index, temp2); // 3 panel here
					Car test = car.get(index);
					System.out.println(test.getModelName());
					main.getCarManager().saveCarToFile();
					carListPanel.removeAll();
					populatePanel(); 
			        JOptionPane.showMessageDialog(null, "You have edited a car!");
				} 
			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = carListPanel.getComponentZOrder(singleCarPanel);
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the car?", "Confirm Delete?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (index == 0 && car.size() == 1 && result == JOptionPane.OK_OPTION) {
					main.getCarManager().deleteCar(index);
					main.getCarManager().saveCarToFile();
					carListPanel.removeAll();
					carListPanel.revalidate();
					carListPanel.repaint();
				} else if (result == JOptionPane.OK_OPTION){
					main.getCarManager().deleteCar(index);
					main.getCarManager().saveCarToFile();
					carListPanel.removeAll();
					populatePanel();
				} 
			}
		});

		carListPanel.add(singleCarPanel);
		carListPanel.revalidate();
		carListPanel.repaint();
	}
	public void populatePanel() {
		car = main.getCarManager().getAllCar();
		for (int i = 0; i < car.size(); i++) {
			Car temp = car.get(i);
			String brand = temp.getBrand();
			String modelName = temp.getModelName();
			String modelID = temp.getModelID();
			int price = temp.getCostPerDay();
			String regYear = temp.getRegistrationYear();
			String Trans = temp.getTransmission();
			String vehType = temp.getVehicleType();
			String fuel = temp.getFuelType();
			String license = temp.getLicensePlate();
			String pathName = temp.getPathName();
			
			final JPanel singleCarPanel = new JPanel();
			singleCarPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mouse Cursor
			singleCarPanel.setLayout(new BoxLayout(singleCarPanel, BoxLayout.Y_AXIS));
			singleCarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			

			switch (pathName) {
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\audi-image.png":
			        resourcePath = "/img/audi-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\bmw-image.png":
			        resourcePath = "/img/bmw-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\porsche-image.png":
			        resourcePath = "/img/porsche-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\volkswagen-image.png":
			        resourcePath = "/img/volkswagen-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\mini-image.png": 
			        resourcePath = "/img/mini-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\chrysler-image.png":
			        resourcePath = "/img/chrysler-image.png";
			        break;
			    case "C:\\Users\\kenne\\OneDrive\\Desktop\\lamborghini-image.png":
			        resourcePath = "/img/lamborghini-image.png";
			        break;
			    default:
			        System.out.println("Unknown path: " + pathName);
			        break;
			}

			if (resourcePath != null) {
			    ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
			    Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			    ImageIcon resizedIcon = new ImageIcon(scaledImage);
			    
			    this.lblCarImage = new JLabel();
			    lblCarImage.setBounds(85, 34, 200, 200);
			    lblCarImage.setIcon(resizedIcon);
			    
			    singleCarPanel.add(lblCarImage);
			}
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("Brand: " + brand));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("ModelName: " + modelName));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("ModelID: " + modelID));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("Price: " + price));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("RegYear: " + regYear));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("Trans: " + Trans));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("vehType: " + vehType));
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("Fuel: " + fuel));
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10))); // spacing
			singleCarPanel.add(new JLabel("LicensePlate: " + license));
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			JButton btnEdit = new JButton("Edit Car");
			singleCarPanel.add(btnEdit);
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			JButton btnDelete = new JButton("Delete Car");
			singleCarPanel.add(btnDelete);
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 18)));
			
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					index = carListPanel.getComponentZOrder(singleCarPanel);
				    System.out.println("Clicked panel index: " + index);
				    car = main.getCarManager().getAllCar();
				    Car temp = car.get(index);
					txtbrand.setText(temp.getBrand());
					txtmodelName.setText(temp.getModelName());
					txtmodelID.setText(temp.getModelID());
					txtcostPerDay.setText(String.valueOf(temp.getCostPerDay()));
					txtregYear.setText(temp.getRegistrationYear());
					txttransmission.setText(temp.getTransmission());
					txtvehicleType.setText(temp.getVehicleType());
					txtfuelType.setText(temp.getFuelType());
					txtlicensePlate.setText(temp.getLicensePlate());
					final JComponent[] inputs = new JComponent[] {
							new JLabel("brand"),
							txtbrand,
							new JLabel("modelName"),
							txtmodelName,
							new JLabel("fuelType"),
							txtfuelType,
							new JLabel("licensePlate"),
							txtlicensePlate,
							new JLabel("transmission"),
							txttransmission,
							new JLabel("modelID"),
							txtmodelID,
							new JLabel("registrationYear"),
							txtregYear,
							new JLabel("vehicleType"),
							txtvehicleType,
							new JLabel("costPerDay"),
							txtcostPerDay
					};
					int result = JOptionPane.showConfirmDialog(null, inputs, "Edit Car Details", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						String newBrand = txtbrand.getText();
						String newName = txtmodelName.getText();
						String newFuelType = txtfuelType.getText();
						String newLicensePlate = txtlicensePlate.getText();
						String newTransmission = txttransmission.getText();
						String newID = txtmodelID.getText();
						String newRegYear = txtregYear.getText();
						String newVehicleType = txtvehicleType.getText();
						int newCostPerDay = Integer.valueOf(txtcostPerDay.getText());
						Car temp2 = car.get(index);
						temp2.setBrand(newBrand);
						temp2.setModelName(newName);
						temp2.setFuelType(newFuelType);
						temp2.setLicensePlate(newLicensePlate);
						temp2.setTransmission(newTransmission);
						temp2.setModelID(newID);
						temp2.setRegistrationYear(newRegYear);
						temp2.setVehicleType(newVehicleType);
						temp2.setCostPerDay(newCostPerDay);
						main.getCarManager().editCar(index, temp2); // 3 panel here
						main.getCarManager().saveCarToFile();
						carListPanel.removeAll();
						populatePanel(); 
				        JOptionPane.showMessageDialog(null, "You have edited a car!");
					} 
				}
			});
			
			
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					index = carListPanel.getComponentZOrder(singleCarPanel);
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the car?", "Confirm Delete?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (index == -1) {
						return;
					}
					if (index == 0 && car.size() == 1 && result == JOptionPane.OK_OPTION) {
						main.getCarManager().deleteCar(index);
						main.getCarManager().saveCarToFile();
						carListPanel.removeAll();
						carListPanel.revalidate();
						carListPanel.repaint();
					} else if (result == JOptionPane.OK_OPTION){
						main.getCarManager().deleteCar(index);
						main.getCarManager().saveCarToFile();
						carListPanel.removeAll();
						populatePanel();
					} 
				}
			});
			
			carListPanel.add(singleCarPanel);
			carListPanel.revalidate();
			carListPanel.repaint();
		}
	}
	
	
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
	public void removeAllCars() {
		carListPanel.removeAll();
	}
}
