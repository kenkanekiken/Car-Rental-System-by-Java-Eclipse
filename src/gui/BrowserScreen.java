package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.MainFrame;
import data.Booking;
import data.Car;
import javax.swing.SpringLayout;
import javax.swing.JSeparator;

public class BrowserScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainFrame main;
	private int index, rentingDays, price, priceIndex, checkRentingDate;
	private Vector<Car> car;
	private String modelName, modelID, cusUsername, bookingID, startDate, endDate, modelNameIndex, modelIDIndex, pathNameIndex;
	private Date selectedStartDate, selectedEndDate, today;
	private long diffInMillies, days, daysBetween, diff, calculateDay;
	private JPanel panel;
	private JLabel lblCarImage, lblWelcome;
	private JButton btnViewCarListing;
	private JButton btnGoCart;
	private JButton btnBookingHistory;
	private JButton btnProfile;
	private JButton btnLogout;
	private JPanel carListPanel;
	private JDatePickerImpl startDatePicker, endDatePicker;
	private JSeparator separator;
	private String resourcePath = null;

	/**
	 * Create the panel.
	 */
	public BrowserScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		

        UtilDateModel modelStart = new UtilDateModel();
        LocalDate todayDate = LocalDate.now();
        modelStart.setDate(todayDate.getYear(), todayDate.getMonthValue() - 1, todayDate.getDayOfMonth());
        Properties p = new Properties();
        JDatePanelImpl startDatePanel = new JDatePanelImpl(modelStart, p);
        startDatePicker = new JDatePickerImpl(startDatePanel, new DateLabelFormatter());
        startDatePicker.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedStartDate = (Date) startDatePicker.getModel().getValue();
        		
        		if (selectedStartDate != null) {
        			Instant instant = selectedStartDate.toInstant();
        		    LocalDate selectedStartLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        		    daysBetween = ChronoUnit.DAYS.between(todayDate, selectedStartLocalDate);
        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        			String formatted = formatter.format(selectedStartDate);
        			startDate = formatted;
        			System.out.println(daysBetween);
        		}
        	}
        });
        add(startDatePicker);


        UtilDateModel modelEnd = new UtilDateModel();
        JDatePanelImpl endDatePanel = new JDatePanelImpl(modelEnd, p);
        endDatePicker = new JDatePickerImpl(endDatePanel, new DateLabelFormatter());
        SpringLayout springLayout = (SpringLayout) endDatePicker.getLayout();
        springLayout.putConstraint(SpringLayout.WEST, endDatePicker.getJFormattedTextField(), 0, SpringLayout.WEST, endDatePicker);
        endDatePicker.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		selectedEndDate = (Date) endDatePicker.getModel().getValue();
        		today = new Date();
        		if (selectedStartDate != null && selectedEndDate != null) {
        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        			String formatted = formatter.format(selectedEndDate);
        			endDate = formatted;
        			diff = selectedStartDate.getTime() - today.getTime();//
        			calculateDay = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//
        			checkRentingDate = (int) calculateDay;//
        			if (today != selectedStartDate) {
            			diffInMillies = selectedEndDate.getTime() - selectedStartDate.getTime();
            			days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            			rentingDays = (int) days;
        			} else {
            			diffInMillies = selectedEndDate.getTime() - today.getTime();
            			days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            			rentingDays = (int) days;
        			}
        		}
        	}
        });
        add(endDatePicker);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(104, 104, 104));
		panel.setBounds(0, 0, 300, 700);
		add(panel);

		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(360, 133, 583, 508);
		add(panelContainer);
		panelContainer.setLayout(new BorderLayout(0, 0));
		
		carListPanel = new JPanel();
		carListPanel.setLayout(new BoxLayout(carListPanel, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane(carListPanel);
		panelContainer.add(scrollPane);
		
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
		
		btnViewCarListing = new JButton("Book Cars");
		btnViewCarListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("browser");
			}
		});
		btnViewCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewCarListing.setBounds(43, 243, 219, 36);
		panel.add(btnViewCarListing);
		
		btnGoCart = new JButton("Go to Cart");
		btnGoCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("bookingcart");
			}
		});
		btnGoCart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoCart.setBounds(43, 302, 219, 36);
		panel.add(btnGoCart);
		
		btnBookingHistory = new JButton("Bookings History");
		btnBookingHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getBookingHistoryScreen().populateBookingTable();
				main.showPanel("bookingHistory");
			}
		});
		btnBookingHistory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBookingHistory.setBounds(43, 361, 219, 36);
		panel.add(btnBookingHistory);
		
		btnProfile = new JButton("Your Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("profile");
			}
		});
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProfile.setBounds(43, 421, 219, 36);
		panel.add(btnProfile);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("login");
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(43, 594, 219, 36);
		panel.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Book Cars");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(585, 37, 155, 39);
		add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);
		populatePanel();
	}
	
	public void populatePanel() {
		car = main.getCarManager().getAllCar();
		for (int i = 0; i < car.size(); i++) {
			Car temp = car.get(i);
			String brand = temp.getBrand();
			modelName = temp.getModelName();
			modelID = temp.getModelID();
			price = temp.getCostPerDay();
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
			singleCarPanel.add(Box.createRigidArea(new Dimension(0, 10))); // spacing
			singleCarPanel.add(new JLabel("LicensePlate: " + license));
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 30)));
			
			
			JButton btnAdd = new JButton("Add to Cart");
			singleCarPanel.add(btnAdd);
			singleCarPanel.add(Box.createRigidArea(new Dimension(10, 30)));
			
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        index = carListPanel.getComponentZOrder(singleCarPanel);
			        System.out.println("Clicked panel index: " + index);
					final JComponent[] inputs = new JComponent[] {
							new JLabel("Start Date"),
							startDatePicker,
							new JLabel("Return Date"),
							endDatePicker,
					};
					cusUsername = main.getProfileScreen().getUsername();
					bookingID = randomID();
					int result = JOptionPane.showConfirmDialog(null, inputs, "Adding to Cart", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						if (startDate != null && endDate != null && rentingDays > 0 && daysBetween < 5 && checkRentingDate >= 0) {
							car = main.getCarManager().getAllCar();
							Car temp1 = car.get(index); //
							priceIndex = temp1.getCostPerDay(); //
							modelNameIndex = temp1.getModelName();
							modelIDIndex = temp1.getModelID();
							pathNameIndex = temp1.getPathName(); 
							main.getBookingManager().addBooking(bookingID, modelIDIndex, modelNameIndex, cusUsername, priceIndex, rentingDays, startDate, endDate, pathNameIndex);
							main.getBookingManager().saveBookingToFile();
							main.getBookingCartScreen().populatePanel(cusUsername, bookingID, modelNameIndex, modelIDIndex, priceIndex, rentingDays, startDate, endDate, pathNameIndex);
							main.showPanel("bookingcart");
						} else {
							JOptionPane.showMessageDialog(null, "Either start date or end date is not selected or start date is more than 3 working days or invalid date!");
						}
					}
				}
			});
		
			carListPanel.add(singleCarPanel);
			carListPanel.revalidate();
			carListPanel.repaint();
		}
	}
	public String randomID() {
		Random random = new Random();
		String bookingID = "BKG" + (100000 + random.nextInt(900000));
		return bookingID;
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
	public void removeAllCars() {
		carListPanel.removeAll();
	}
}
