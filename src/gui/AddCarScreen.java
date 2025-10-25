package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MainFrame;

import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class AddCarScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtModelID;
	private JTextField txtLicense;
	private JTextField txtPrice;
	private JLabel lblCarImage, lblWelcome, lblAddCarImage;
	private JRadioButton rdbtnAuto, rdbtnManual;
	private JComboBox cbBrand, cbFuelType, cbVehicleType, cbYear;
	private MainFrame main;
	private String modelID, modelName, regYear, license, brand, fuel, vehicle, transmission;
	private String[] brands = {"Audi", "BYD", "Porsche", "Mercedes", "BMW", "MiniCooper", "Tesla", "Lamborghini", "Volkswagen", "Chrysler", "Ferrari", "McLaren", "Maserati",
			"Rolls Royce", "Toyoto", "Honda", "Mazda", "Nissan", "Hyundai", "Kia", "Mitsubishi", "Subaru", "Suzuki"};
	private String[] fuelType = {"Petrol", "Diesel", "Hybrid", "Electric"};
	private String[] vehicleType = {"Sports", "Sedan", "Hatchback", "SUV", "Coupe", "Van", "Lorry"};
	private String[] year = {"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
	private int price;
	private Path path;
	private String photoName = "no-photos.png", pathName;
	/**
	 * Create the panel.
	 * @param carListing 
	 */
	public AddCarScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JLabel lblCarsDetail = new JLabel("Add Cars");
		lblCarsDetail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCarsDetail.setBounds(591, 36, 142, 47);
		add(lblCarsDetail);
		
		JLabel lblBrand = new JLabel("Car Brand");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBrand.setBounds(474, 116, 66, 20);
		add(lblBrand);
		
		this.cbBrand = new JComboBox(brands);
		cbBrand.setBounds(474, 138, 349, 26);
		add(cbBrand);
		
		JLabel lblModelName = new JLabel("Model Name");
		lblModelName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelName.setBounds(474, 181, 94, 20);
		add(lblModelName);
		
		this.txtName = new JTextField();
		txtName.setBounds(474, 204, 169, 26);
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblModelID = new JLabel("Model ID");
		lblModelID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblModelID.setBounds(653, 185, 71, 13);
		add(lblModelID);
		
		this.txtModelID = new JTextField();
		txtModelID.setBounds(653, 204, 170, 26);
		add(txtModelID);
		txtModelID.setColumns(10);
		
		JLabel lblRegistrationYear = new JLabel("Registration Year");
		lblRegistrationYear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistrationYear.setBounds(474, 254, 94, 20);
		add(lblRegistrationYear);
		
		JLabel lblLicensePlate = new JLabel("License Plate");
		lblLicensePlate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLicensePlate.setBounds(653, 259, 81, 13);
		add(lblLicensePlate);
		
		this.txtLicense = new JTextField();
		txtLicense.setBounds(653, 278, 170, 26);
		add(txtLicense);
		txtLicense.setColumns(10);
		
		JLabel lblFuelType = new JLabel("Fuel Type");
		lblFuelType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFuelType.setBounds(474, 332, 66, 13);
		add(lblFuelType);
		
		this.cbFuelType = new JComboBox(fuelType);
		cbFuelType.setBounds(474, 355, 169, 26);
		add(cbFuelType);
		
		JLabel lblTransmission = new JLabel("Transmission");
		lblTransmission.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTransmission.setBounds(653, 333, 94, 13);
		add(lblTransmission);
		

		this.rdbtnAuto = new JRadioButton("Automatic");
		rdbtnAuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnAuto.setBounds(653, 358, 87, 21);
		add(rdbtnAuto);
		
		this.rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnManual.setBounds(742, 358, 103, 21);
		add(rdbtnManual);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnAuto);
		group.add(rdbtnManual);
		

		JLabel lblVehicleType = new JLabel("Vehicle Type");
		lblVehicleType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehicleType.setBounds(474, 408, 81, 13);
		add(lblVehicleType);
		
		this.cbVehicleType = new JComboBox(vehicleType);
		cbVehicleType.setBounds(474, 426, 169, 26);
		add(cbVehicleType);
		
		JLabel lblPrice = new JLabel("$Price/Day");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(653, 409, 71, 13);
		add(lblPrice);
		
		this.txtPrice = new JTextField();
		txtPrice.setBounds(653, 426, 170, 26);
		add(txtPrice);
		txtPrice.setColumns(10);
		
		JButton btnAdd = new JButton("Add Car");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transmission = null;
				if (rdbtnAuto.isSelected()) {
					transmission = rdbtnAuto.getText(); 
				} else if (rdbtnManual.isSelected()) {
					transmission = rdbtnManual.getText();
				}
				modelName = txtName.getText();
				modelID = txtModelID.getText();
				regYear = (String) cbYear.getSelectedItem();
				license = txtLicense.getText();
				brand = (String) cbBrand.getSelectedItem();
				fuel = (String) cbFuelType.getSelectedItem();
				vehicle = (String) cbVehicleType.getSelectedItem();
				price = 0;
				try {
					price = Integer.valueOf(txtPrice.getText());
				} catch (NumberFormatException error) {
					price = 0;
				}
				if (!modelName.trim().isEmpty() && !modelID.trim().isEmpty() && !regYear.trim().isEmpty() && !license.trim().isEmpty() && brand != null && fuelType != null && vehicleType != null && transmission != null && price > 0) {
					main.getCarManager().addCar(modelName, fuel, license, brand, transmission, modelID, regYear, vehicle, price, pathName);
					main.getCarListingScreen().populatePanel(brand, modelName, modelID, price, regYear, transmission, vehicle, fuel, license, pathName);
					main.getCarManager().saveCarToFile();
					int result = JOptionPane.showConfirmDialog(null, "You have added the car into cars listings", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				} else {
					int throwError = JOptionPane.showConfirmDialog(null, "Either certain field is empty or price is invalid", "Input Error", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(473, 609, 349, 40);
		add(btnAdd);
		
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
		btnAddCars.setForeground(new Color(0, 0, 0));
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
				main.getCarListingScreen().removeAllCars();
				main.getCarListingScreen().populatePanel();
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
				main.getStaffBookingScreen().populateComboBox();
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
				main.getCustomerInfo().populateTable();
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
		separator.setForeground(new Color(128, 128, 128));
		separator.setBackground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);
		
		JButton btnAddImage = new JButton("Add Image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Select a text file");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG and PNG images", "jpg", "png");
				jfc.addChoosableFileFilter(filter);
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedSourceFile = jfc.getSelectedFile();
					path = selectedSourceFile.toPath();
					BufferedImage image = new BufferedImage(lblAddCarImage.getWidth(), lblAddCarImage.getHeight(),
							BufferedImage.TYPE_INT_ARGB);
					try {
						image = ImageIO.read(selectedSourceFile);
						ImageIcon img = new ImageIcon(image.getScaledInstance(lblAddCarImage.getWidth(),
								lblAddCarImage.getHeight(), Image.SCALE_SMOOTH));
						lblAddCarImage.setIcon(img);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					pathName = String.valueOf(path);
					System.out.println(path); // C:\Users\kenne\OneDrive\Desktop\eclipse-workspace\Project\src\img\bmw-image.png
				}
			}
		});
		btnAddImage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddImage.setBounds(665, 549, 158, 32);
		add(btnAddImage);
		
		JLabel lblDirectory = new JLabel("File Directory");
		lblDirectory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDirectory.setBounds(496, 570, 91, 20);
		add(lblDirectory);

		
		lblAddCarImage = new JLabel("");
		lblAddCarImage.setBounds(486, 478, 147, 103);
		Image icon2 = new ImageIcon(this.getClass().getResource("/img/" + photoName)).getImage() // PathName
				.getScaledInstance(lblAddCarImage.getWidth(), lblAddCarImage.getHeight(), Image.SCALE_SMOOTH);
		lblAddCarImage.setIcon(new ImageIcon(icon2));
		add(lblAddCarImage);
		
		this.cbYear = new JComboBox(year);
		cbYear.setBounds(474, 278, 169, 26);
		add(cbYear);
	

	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
	public String getPath() {
		return String.valueOf(path);
	}
}
