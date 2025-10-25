package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.Booking;
import data.Car;
import data.CompletedBooking;

import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JSeparator;

public class BookingCartScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private Vector<Booking> booking;
	private MainFrame main;
	private long diffInMillies, days, daysBetween, diff, calculateDay;
	private int rentingDays, price, checkRentingDate;
	private String cusUsername, modelName, modelID, bookingID, startDate, endDate, pathName;
	private JLabel lblCarImage, lblWelcome;
	private JDatePickerImpl startDatePicker, endDatePicker;
	private Date selectedStartDate, selectedEndDate, today;
	private JPanel bookingListPanel;
	private String resourcePath = null;
	private LocalDate todayDate;
	/**
	 * Create the panel.
	 */
	public BookingCartScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JPanel panelContainer = new JPanel(); // 485 513
		panelContainer.setBounds(354, 127, 590, 502); // Width 338
		add(panelContainer);
		panelContainer.setLayout(new BorderLayout(0, 0));
		
		bookingListPanel = new JPanel();
		bookingListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bookingListPanel.setPreferredSize(new Dimension(0, Short.MAX_VALUE));

		JScrollPane scrollPane = new JScrollPane(bookingListPanel);
		panelContainer.add(scrollPane);
		
		
        UtilDateModel modelStart = new UtilDateModel();
        todayDate = LocalDate.now();
        modelStart.setDate(todayDate.getYear(), todayDate.getMonthValue() - 1, todayDate.getDayOfMonth());
        Properties p = new Properties();
        JDatePanelImpl startDatePanel = new JDatePanelImpl(modelStart, p);
        startDatePicker = new JDatePickerImpl(startDatePanel, new DateLabelFormatter());
        add(startDatePicker);


        UtilDateModel modelEnd = new UtilDateModel();
        // Create a date panel and picker
        JDatePanelImpl endDatePanel = new JDatePanelImpl(modelEnd, p);
        endDatePicker = new JDatePickerImpl(endDatePanel, new DateLabelFormatter());
        SpringLayout springLayout = (SpringLayout) endDatePicker.getLayout();
        springLayout.putConstraint(SpringLayout.WEST, endDatePicker.getJFormattedTextField(), 0, SpringLayout.WEST, endDatePicker);
        add(endDatePicker); 
		
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
		
		JLabel lblBookingCart = new JLabel("Your Booking Cart");
		lblBookingCart.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBookingCart.setBounds(531, 37, 265, 36);
		add(lblBookingCart);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);
	}
	public void populatePanel(String username, String bookingID1, String modelName1, String modelID1, int price1, int rentingDays1, String startDate1, String endDate1, String pathName1) {
		

		final JPanel singleBookingPanel = new JPanel();
		singleBookingPanel.setPreferredSize(new Dimension(560, 135)); //112
		singleBookingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mouse Cursor
		singleBookingPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		singleBookingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		switch (pathName1) {
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
	        System.out.println("Unknown path: " + pathName1);
	        break;
	    }

	    if (resourcePath != null) {
	    	ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
	        Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(scaledImage);
	    
	        this.lblCarImage = new JLabel();
	        lblCarImage.setBounds(85, 34, 200, 200);
	        lblCarImage.setIcon(resizedIcon);
	    
	        singleBookingPanel.add(lblCarImage);
	    }
		

		singleBookingPanel.add(lblCarImage);
		singleBookingPanel.add(Box.createRigidArea(new Dimension(50, 0)));
		singleBookingPanel.add(new JLabel("BookingID: " + bookingID1));
		singleBookingPanel.add(new JLabel("ModelName: " + modelName1));
		singleBookingPanel.add(new JLabel("ModelID: " + modelID1));
		singleBookingPanel.add(new JLabel("Username: " + username));
		singleBookingPanel.add(Box.createRigidArea(new Dimension(134, 0))); // spacing
		singleBookingPanel.add(new JLabel("Price/Day: $" + price1));
		singleBookingPanel.add(new JLabel("Renting days: " + rentingDays1));
		singleBookingPanel.add(new JLabel("Start Date: " + startDate1));
		singleBookingPanel.add(new JLabel("Return Date: " + endDate1));
		JButton btnEdit = new JButton("Edit");
		singleBookingPanel.add(btnEdit);
		JButton btnDelete = new JButton("Delete");
		singleBookingPanel.add(btnDelete);
		JButton btnCheckout = new JButton("Checkout");
		singleBookingPanel.add(btnCheckout);
		
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        startDatePicker.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		selectedStartDate = (Date) startDatePicker.getModel().getValue();
		        		if (selectedStartDate != null) {
		        			Instant instant = selectedStartDate.toInstant();
		        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		        		    LocalDate selectedStartLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		        		    daysBetween = ChronoUnit.DAYS.between(todayDate, selectedStartLocalDate);
		        			String formatted = formatter.format(selectedStartDate);
		        			startDate = formatted;
		        			}
		        	}
		        });
		        endDatePicker.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent e) {
		        		selectedEndDate = (Date) endDatePicker.getModel().getValue();
		        		today = new Date();
		        		if (selectedStartDate != null && selectedEndDate != null) {
		        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		        			String formatted = formatter.format(selectedEndDate);
		        			endDate = formatted;
		        			diff = selectedStartDate.getTime() - today.getTime();
		        			calculateDay = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		        			checkRentingDate = (int) calculateDay;
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
				final JComponent[] inputs = new JComponent[] {
						new JLabel("startDate"),
						startDatePicker,
						new JLabel("endDate"),
						endDatePicker,
				};
				int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
				int result = JOptionPane.showConfirmDialog(null, inputs, "Edit Bookings Details", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					if (startDate != null && endDate != null && rentingDays > 0 && daysBetween < 5 && checkRentingDate >= 0) {
						booking = main.getBookingManager().getAllBookings();
						for (int i = 0; i < booking.size(); i++ ) {
							Booking temp = booking.get(index);
							cusUsername = temp.getCusUsername();
							bookingID = temp.getBookingID();
							modelName = temp.getModelName();
							modelID = temp.getModelID();
							price = temp.getCostPerDay();
							pathName = temp.getPathName();
						}
						String newStartDate = startDate;
						String newEndDate = endDate;
						Booking newBooking = new Booking(rentingDays, newStartDate, newEndDate, cusUsername, bookingID, modelName, modelID, price, pathName);
						main.getBookingManager().editBooking(index, newBooking);
						main.getBookingManager().saveBookingToFile();
						bookingListPanel.removeAll();
						populatePanel();
					} else {
						JOptionPane.showMessageDialog(null, "Either start date or end date is not selected!");
						System.out.println("Startdate: " + startDate);
						System.out.println("Enddate: " + endDate);
						System.out.println("rentingDays: " + rentingDays);
						System.out.println("daysBetween: " + daysBetween);
						System.out.println("checkRentingDate: " + checkRentingDate);
					}
				}
			}
		});
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
				main.getCheckOutScreen().populateCheckOutTable(index);
				String totalBill  = String.valueOf(main.getCheckOutScreen().totalBill(index));
				main.getCheckOutScreen().setBillLabel(totalBill);
				main.getCheckOutScreen().setReturnLabel();
				main.showPanel("checkout");
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this booking?", "Confirm Delete?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (index == 0 && result == JOptionPane.OK_OPTION) {
					bookingListPanel.remove(index);
					bookingListPanel.revalidate();
					bookingListPanel.repaint();
					main.getBookingManager().deleteBooking(index);
					main.getBookingManager().saveBookingToFile();
				} else if (result == JOptionPane.OK_OPTION) {
					main.getBookingManager().deleteBooking(index);
					main.getBookingManager().saveBookingToFile();
					bookingListPanel.removeAll();
					populatePanel();
				} 
			}
		});
		
		bookingListPanel.add(singleBookingPanel);
		bookingListPanel.revalidate();
		bookingListPanel.repaint();
	}

	public void populatePanel() {
		booking = main.getBookingManager().getAllBookings();
		for (int i = 0; i < booking.size(); i++) {
			Booking temp = booking.get(i);
			String cusUsername1 = temp.getCusUsername();
			String bookingID1 = temp.getBookingID();
			String modelName1 = temp.getModelName();
			String modelID1 = temp.getModelID();
			int price1 = temp.getCostPerDay();
			int rentingDays1 = temp.getRentingDays();
			String startDate1 = temp.getStartDate();
			String endDate1 = temp.getEndDate();
			String pathName1 = temp.getPathName();
			
			final JPanel singleBookingPanel = new JPanel();
			singleBookingPanel.setPreferredSize(new Dimension(560, 135)); //
			singleBookingPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Mouse Cursor
			singleBookingPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
			singleBookingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			// Keep getting last index image 
			switch (pathName1) {
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
			        System.out.println("Unknown path: " + pathName1);
			        break;
			}

			if (resourcePath != null) {
			    ImageIcon icon = new ImageIcon(getClass().getResource(resourcePath));
			    Image scaledImage = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			    ImageIcon resizedIcon = new ImageIcon(scaledImage);
			    
			    this.lblCarImage = new JLabel();
			    lblCarImage.setBounds(85, 34, 200, 200);
			    lblCarImage.setIcon(resizedIcon);
			    
			    singleBookingPanel.add(lblCarImage);
			}
			
			
			singleBookingPanel.add(Box.createRigidArea(new Dimension(50, 0)));
			singleBookingPanel.add(new JLabel("BookingID: " + bookingID1));
			singleBookingPanel.add(new JLabel("ModelName: " + modelName1));
			singleBookingPanel.add(new JLabel("ModelID: " + modelID1));
			singleBookingPanel.add(new JLabel("Username: " + cusUsername1));
			singleBookingPanel.add(Box.createRigidArea(new Dimension(134, 0))); // spacing
			singleBookingPanel.add(new JLabel("Price/Day: $" + price1));
			singleBookingPanel.add(new JLabel("Renting days: " + rentingDays1));
			singleBookingPanel.add(new JLabel("Start Date: " + startDate1));
			singleBookingPanel.add(new JLabel("End Date: " + endDate1));
			JButton btnEdit = new JButton("Edit");
			singleBookingPanel.add(btnEdit);
			JButton btnDelete = new JButton("Delete");
			singleBookingPanel.add(btnDelete);
			JButton btnCheckout = new JButton("Checkout");
			singleBookingPanel.add(btnCheckout);
			
			
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        startDatePicker.addActionListener(new ActionListener() {
			        	public void actionPerformed(ActionEvent e) {
			        		selectedStartDate = (Date) startDatePicker.getModel().getValue();
			        		if (selectedStartDate != null) {
			        			Instant instant = selectedStartDate.toInstant();
			        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			        		    LocalDate selectedStartLocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
			        		    daysBetween = ChronoUnit.DAYS.between(todayDate, selectedStartLocalDate);
			        			String formatted = formatter.format(selectedStartDate);
			        			startDate = formatted;
			        			}
			        	}
			        });
			        endDatePicker.addActionListener(new ActionListener() {
			        	public void actionPerformed(ActionEvent e) {
			        		selectedEndDate = (Date) endDatePicker.getModel().getValue();
			        		today = new Date();
			        		if (selectedStartDate != null && selectedEndDate != null) {
			        			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			        			String formatted = formatter.format(selectedEndDate);
			        			endDate = formatted;
			        			diff = selectedStartDate.getTime() - today.getTime();
			        			calculateDay = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			        			checkRentingDate = (int) calculateDay;
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
					final JComponent[] inputs = new JComponent[] {
							new JLabel("startDate"),
							startDatePicker,
							new JLabel("endDate"),
							endDatePicker,
					};
					 int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
					int result = JOptionPane.showConfirmDialog(null, inputs, "Edit Bookings Details", JOptionPane.PLAIN_MESSAGE);
					if (result == JOptionPane.OK_OPTION) {
						if (startDate != null && endDate != null && rentingDays > 0 && daysBetween < 5 && checkRentingDate >= 0) {
							booking = main.getBookingManager().getAllBookings();
							for (int i = 0; i < booking.size(); i++ ) {
								Booking temp = booking.get(index);
								cusUsername = temp.getCusUsername();
								bookingID = temp.getBookingID();
								modelName = temp.getModelName();
								modelID = temp.getModelID();
								price = temp.getCostPerDay();
								pathName = temp.getPathName();
							}
							String newStartDate = startDate;
							String newEndDate = endDate;
							Booking newBooking = new Booking(rentingDays, newStartDate, newEndDate, cusUsername, bookingID, modelName, modelID, price, pathName);
							main.getBookingManager().editBooking(index, newBooking);
							main.getBookingManager().saveBookingToFile();
							bookingListPanel.removeAll();
							populatePanel();
						} else {
							JOptionPane.showMessageDialog(null, "Either start date or end date is not selected!");
							System.out.println("Startdate: " + startDate);
							System.out.println("Enddate: " + endDate);
							System.out.println("rentingDays: " + rentingDays);
							System.out.println("daysBetween: " + daysBetween);
							System.out.println("checkRentingDate: " + checkRentingDate);
						}
					}
				}
			});
			btnCheckout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
					main.getCheckOutScreen().populateCheckOutTable(index);
					String totalBill  = String.valueOf(main.getCheckOutScreen().totalBill(index));
					main.getCheckOutScreen().setBillLabel(totalBill);
					main.getCheckOutScreen().setReturnLabel();
					main.showPanel("checkout");
				}
			});
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = bookingListPanel.getComponentZOrder(singleBookingPanel);
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this booking?", "Confirm Delete?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (index == 0 && result == JOptionPane.OK_OPTION) {
						bookingListPanel.remove(index);
						bookingListPanel.revalidate();
						bookingListPanel.repaint();
						main.getBookingManager().deleteBooking(index);
						main.getBookingManager().saveBookingToFile();
					} else if (result == JOptionPane.OK_OPTION) {
						main.getBookingManager().deleteBooking(index);
						main.getBookingManager().saveBookingToFile();
						bookingListPanel.removeAll();
						populatePanel();
					} 
				}
			});
			bookingListPanel.add(singleBookingPanel);
			bookingListPanel.revalidate();
			bookingListPanel.repaint();
		}
	}
	
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
	public void removeAllCars() {
		bookingListPanel.removeAll();
	}
}