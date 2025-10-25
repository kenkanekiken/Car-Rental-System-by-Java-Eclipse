package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MainFrame;
import data.Booking;
import data.CompletedBooking;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;

public class BookingHistoryScreen extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JLabel lblCarImage, lblWelcome;
	private Vector<CompletedBooking> booking;
	private MainFrame main;

	/**
	 * Create the panel.
	 */
	public BookingHistoryScreen(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(355, 137, 586, 366);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblBookingHistory = new JLabel("Booking History");
		lblBookingHistory.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBookingHistory.setBounds(547, 39, 232, 37);
		add(lblBookingHistory);
		
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
		populateBookingTable();
	}
	public void populateBookingTable() {
		booking = this.main.getBookingManager().getAllCompletedBookings();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"BookingID", "ModelName", "ModelID", "Price/Day", "DaysRented", "StartDate", "ReturnDate"});
		for (int i = 0; i < booking.size(); i++) {
			CompletedBooking temp = booking.get(i);
			if (temp.getCusUsername().equals(main.getProfileScreen().getUsername())) {
				model.addRow(new Object[] {
						temp.getBookingID(),
						temp.getModelName(),
						temp.getModelID(),
						"$" + temp.getCostPerDay(),
						temp.getRentingDays(),
						temp.getStartDate(),
						temp.getEndDate()
				});
			}
		}
		this.table.setModel(model);
	}
	public void setWelcometxt(String username) {
		lblWelcome.setText("Welcome, " + username);
	}
	public void removeBookings() {
		table.removeAll();
	}
}
