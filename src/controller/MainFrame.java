package controller;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.AddCarScreen;
import gui.BookingCartScreen;
import gui.BookingHistoryScreen;
import gui.BrowserScreen;
import gui.CheckOutScreen;
import gui.CustomerInfoScreen;
import gui.LoginScreen;
import gui.ProfileScreen;
import gui.RegisterScreen;
import gui.ReturnCarScreen;
import gui.SalesLogScreen;
import gui.StaffBookingsScreen;
import gui.StaffCarListingScreen;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout card;
	
	//Controller
	private Controller controller;
	private CarManager carmanager;
	private BookingManager bookingmanager;
	
	//Gui
	private AddCarScreen addcar;
	private BrowserScreen browser;
	private LoginScreen login;
	private RegisterScreen reg;
	private StaffCarListingScreen carlisting;
	private CustomerInfoScreen customerInfo;
	private ProfileScreen profilescreen;
	private BookingCartScreen bookingcart;
	private CheckOutScreen checkout;
	private SalesLogScreen saleslog;
	private StaffBookingsScreen bookingScreen;
	private BookingHistoryScreen bookingHistory;
	private ReturnCarScreen returncar;
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
				    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Import classes from the Swing package and set it to look like the UI
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("MK Car Rental");
		setBounds(100, 100, 1000, 720);
		card = new CardLayout();
		setLayout(this.card);
		contentPane = new JPanel(card);
		setContentPane(contentPane);
		controller = new Controller();
		carmanager = new CarManager();
		bookingmanager = new BookingManager();
		browser = new BrowserScreen(this);
		login = new LoginScreen(this);
		addcar = new AddCarScreen(this);
		carlisting = new StaffCarListingScreen(this);
		reg = new RegisterScreen(this);
		customerInfo = new CustomerInfoScreen(this);
		profilescreen = new ProfileScreen(this);
		bookingcart = new BookingCartScreen(this);
		checkout = new CheckOutScreen(this);
		saleslog = new SalesLogScreen(this);
		bookingScreen = new StaffBookingsScreen(this);
		bookingHistory = new BookingHistoryScreen(this);
		returncar = new ReturnCarScreen(this);
		contentPane.add(login, "login");
		contentPane.add(browser, "browser");
		contentPane.add(addcar, "addcar");
		contentPane.add(carlisting, "carlisting");
		contentPane.add(reg, "reg");
		contentPane.add(customerInfo, "customerInfo");
		contentPane.add(profilescreen, "profile");
		contentPane.add(bookingcart, "bookingcart");
		contentPane.add(checkout, "checkout");
		contentPane.add(saleslog, "saleslog");
		contentPane.add(bookingScreen, "bookingScreen");
		contentPane.add(bookingHistory, "bookingHistory");
		contentPane.add(returncar, "returncar");
		// Administrator is creating a Staff account for staff
		getController().regStaff("staff","123");
	}
	public void showPanel(String name) {
		card.show(contentPane, name);
	}
	public AddCarScreen getAddCarScreen() {
		return addcar;
	}
	public CustomerInfoScreen getCustomerInfo() {
		return customerInfo;
	}
	public StaffCarListingScreen getCarListingScreen() {
		return carlisting;
	}
	public ProfileScreen getProfileScreen() {
		return profilescreen;
	}
	public BrowserScreen getBrowserScreen() {
		return browser;
	}
	public BookingCartScreen getBookingCartScreen() {
		return bookingcart;
	}
	public CheckOutScreen getCheckOutScreen() {
		return checkout;
	}
	public SalesLogScreen getSalesLogScreen() {
		return saleslog;
	}
	public StaffBookingsScreen getStaffBookingScreen() {
		return bookingScreen;
	}
	public BookingHistoryScreen getBookingHistoryScreen() {
		return bookingHistory;
	}
	public ReturnCarScreen getReturnCarScreen() {
		return returncar;
	}
	public Controller getController() {
		return controller;
	}
	public CarManager getCarManager() {
		return carmanager;
	}
	public BookingManager getBookingManager() {
		return bookingmanager;
	}
}
