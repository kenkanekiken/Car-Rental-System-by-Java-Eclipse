package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.Booking;
import data.Car;
import data.CarsRentedOut;
import data.CompletedBooking;

import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

public class SalesLogScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private Vector<CompletedBooking> completedBooking;
	private Vector<Car> car;
	private Vector<CarsRentedOut> rentedCar;
	private MainFrame main;
	private JTable table;
	private JLabel lblTotalSales;
	private JPanel panel;
	private JLabel lblWelcome;
	private JLabel lblCarImage;
	private JButton btnAddCars;
	private JButton btnCarListing;
	private JButton btnBooking;
	private JButton btnSalesReport;
	private JButton btnCustomerInfo;
	private JButton btnReturnCar;
	private JButton btnLogout;
	private JPanel salesPanel;
	private JLabel lblSales, lblOrders, lblAverage;
	private JPanel panelChart;
	private String[] chartType = {"Bar Chart", "Pie Chart"};
	/**
	 * Create the panel.
	 */
	public SalesLogScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(361, 539, 580, 107);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
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
		
		btnAddCars = new JButton("Add Cars");
		btnAddCars.setBackground(new Color(255, 255, 255));
		btnAddCars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("addcar");
			}
		});
		btnAddCars.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddCars.setBounds(43, 243, 219, 36);
		panel.add(btnAddCars);
		
		btnCarListing = new JButton("View Cars Listing");
		btnCarListing.setBackground(new Color(255, 255, 255));
		btnCarListing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("carlisting");
			}
		});
		btnCarListing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCarListing.setBounds(43, 302, 219, 36);
		panel.add(btnCarListing);
		
		btnBooking = new JButton("View Bookings");
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
		
		btnSalesReport = new JButton("Sales Report");
		btnSalesReport.setBackground(new Color(255, 255, 255));
		btnSalesReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("saleslog");
			}
		});
		btnSalesReport.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalesReport.setBounds(43, 421, 219, 36);
		panel.add(btnSalesReport);
		
		btnCustomerInfo = new JButton("Customers Info");
		btnCustomerInfo.setBackground(new Color(255, 255, 255));
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("customerInfo");
			}
		});
		btnCustomerInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCustomerInfo.setBounds(43, 479, 219, 36);
		panel.add(btnCustomerInfo);
		
		btnReturnCar = new JButton("Return Cars");
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
		
		btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showPanel("login");
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBounds(43, 594, 219, 36);
		panel.add(btnLogout);
		
		salesPanel = new JPanel();
		salesPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		salesPanel.setBackground(new Color(215, 40, 106));
		salesPanel.setBounds(351, 118, 150, 102);
		add(salesPanel);
		
		salesPanel.add(Box.createRigidArea(new Dimension(15, 0))); //
		lblSales = new JLabel("Total Sales");
		salesPanel.add(lblSales);
		lblSales.setFont(new Font("Tahoma", Font.BOLD, 15));
		salesPanel.add(Box.createRigidArea(new Dimension(15, 0))); // spacing
		lblTotalSales = new JLabel("");
		salesPanel.add(lblTotalSales);
		lblTotalSales.setFont(new Font("Arial Black", Font.BOLD, 25));
		
		JPanel carRentedPanel = new JPanel();
		carRentedPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		carRentedPanel.setBackground(new Color(0, 255, 64));
		carRentedPanel.setBounds(791, 118, 150, 102);
		add(carRentedPanel);
		carRentedPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		carRentedPanel.add(Box.createRigidArea(new Dimension(20, 0))); //
		JLabel lblAverageSales = new JLabel("Average");
		carRentedPanel.add(lblAverageSales);
		lblAverageSales.setFont(new Font("Tahoma", Font.BOLD, 15));
		carRentedPanel.add(Box.createRigidArea(new Dimension(20, 0))); //
		lblAverage = new JLabel("");
		carRentedPanel.add(lblAverage);
		lblAverage.setFont(new Font("Arial Black", Font.PLAIN, 25));
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		orderPanel.setBackground(new Color(128, 128, 255));
		orderPanel.setBounds(572, 118, 150, 102);
		add(orderPanel);
		
		orderPanel.add(Box.createRigidArea(new Dimension(20, 0))); //
		JLabel lblTotalOrder = new JLabel("Total Order");
		orderPanel.add(lblTotalOrder);
		lblTotalOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
		orderPanel.add(Box.createRigidArea(new Dimension(20, 0))); //
		lblOrders = new JLabel("");
		orderPanel.add(lblOrders);
		lblOrders.setFont(new Font("Arial Black", Font.BOLD, 25));
		
		JLabel lblDashboard = new JLabel("MK Rental Dashboard");
		lblDashboard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDashboard.setBounds(512, 48, 319, 25);
		add(lblDashboard);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(128, 128, 128));
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(337, 83, 632, 18);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 128, 128));
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(337, 255, 632, 18);
		add(separator_1);
		
		JLabel lblCompletedOrders = new JLabel("All Completed Orders");
		lblCompletedOrders.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCompletedOrders.setBounds(561, 511, 215, 25);
		add(lblCompletedOrders);
		
		panelChart = new JPanel();
		panelChart.setBounds(361, 317, 580, 179);
		add(panelChart);
		populateBarChart();
		JComboBox comboBox = new JComboBox(chartType);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Bar Chart")) {
					panelChart.removeAll();
					populateBarChart();
				} else if (comboBox.getSelectedItem().equals("Pie Chart")) {
					panelChart.removeAll();
					populatePieChart();
				}
			}
		});
		comboBox.setBounds(545, 276, 215, 31);
		add(comboBox);
		populateCompletedBookingTable();
	}
	public void populateCompletedBookingTable() {
		completedBooking = main.getBookingManager().getAllCompletedBookings();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Username", "BookingID", "ModelName", "DaysRented", "Price/Day", "StartDate", "ReturnDate"});
		for (int i = 0; i < completedBooking.size(); i++) {
			CompletedBooking temp = completedBooking.get(i);
			model.addRow(new Object[] {
				temp.getCusUsername(),
				temp.getBookingID(),
				temp.getModelName(),
				temp.getRentingDays(),
				"$"+ temp.getCostPerDay(),
				temp.getStartDate(),
				temp.getEndDate()
			});
			table.setModel(model);
			float totalBill = totalBill();
			lblTotalSales.setText("$" + String.valueOf(totalBill));
			lblOrders.setText(String.valueOf(completedBooking.size()));
			float average = totalBill() / completedBooking.size();
			lblAverage.setText("$" + String.valueOf(average));
		}
	}
	public void populateBarChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		completedBooking = main.getBookingManager().getAllCompletedBookings();
		int averageSales = 0;
		String tSales = String.valueOf(totalBill());
		averageSales = totalBill() / completedBooking.size();
		String aSales = String.valueOf(averageSales);
	    dataset.addValue(totalBill(), "Total Sales: " + tSales, "");
	    dataset.addValue(averageSales, "Average Sales: " + aSales, "");
        
        JFreeChart barChart = ChartFactory.createBarChart(
            "Total/Average Sales Chart",
            null,
            "$Amount",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        barChart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 18));
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(580, 167));
        panelChart.add(chartPanel);
        panelChart.revalidate();
        panelChart.repaint();		
	}
	public void populatePieChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		car = main.getCarManager().getAllCar();
		rentedCar = main.getCarManager().getAllRentedCar();
		int totalAvailableCar = car.size();
		int totalRentedCar = rentedCar.size();
		int totalCar = totalAvailableCar + totalRentedCar;
		String aCar = String.valueOf(totalAvailableCar);
		String rCar = String.valueOf(totalRentedCar);
		String tCar = String.valueOf(totalCar);
		dataset.setValue("Cars Avaliable: " + aCar, totalAvailableCar);
		dataset.setValue("Cars Rented Out: "+ rCar, totalRentedCar);
		dataset.setValue("Total Cars: " + tCar, totalCar);
		JFreeChart pieChart = ChartFactory.createPieChart("Cars Availability Pie Chart", dataset, true, true, false);
        pieChart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 18));
		ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(580, 167));
		panelChart.add(chartPanel);
		panelChart.revalidate();
		panelChart.repaint();
	}
	public int totalBill() {
		completedBooking = main.getBookingManager().getAllCompletedBookings();
		int totalbill = 0;
		for (int i = 0; i < completedBooking.size(); i++) {
			CompletedBooking temp = completedBooking.get(i);
			totalbill += temp.getCostPerDay() * temp.getRentingDays();
		}
		return totalbill;
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
}
