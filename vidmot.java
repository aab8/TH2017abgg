import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.IOException;
import javax.swing.UIManager;

public class vidmot extends JFrame {

	private JPanel contentPane;
	private JLabel lbTitill;
	private JLabel lblBrottfr;
	private JList flightList;
	private JList flightListBackJList;
	private JButton btnBoka;
	private JLabel lblVidLeitFundust;
	private JLabel lblVidLeitFundust_1;
	private JInternalFrame bookingWindow;
	JLabel lblBokunTokstXd;
	JButton btnBoka_1;
	JComboBox numPassengers;
	JComboBox pickWhereFrom;
	JComboBox pickWhereTo;
	JComboBox dagurUt;
	JRadioButton rdbtnBadarLeidir;
	JButton searchButton;
	JLabel lblBokunFlugs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//String [] places = {"KEF", "CPH", "BRU", "LAX"};


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vidmot frame = new vidmot();
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
	String whereFromName = new String();
	String whereToName = new String();
	String date;
	String dateHome = new String();
	private JList flightListHome;
	private JComboBox manudur;
	private JComboBox ar;
	int day;
	int month;
	int year;
	String tempString;
	boolean bothWays;
	private JComboBox dayHomeList;
	private JComboBox monthHome;
	private JComboBox yearHome;
	int dayHome;
	int monthBack;
	int yearBack;
	int numberOfPassengers;
	private JTextField nafnBooking;
	private JTextField heimilisfangBooking;
	private JTextField simiBooking;
	private JTextField emailBooking;
	private JTextField kk1Booking;
	private JTextField kk2Booking;
	private JTextField kk3Booking;
	private JTextField kk4Booking;
	private JTextField securityNoBooking;
	private JComboBox expireMonth;
	private JComboBox expireYear;
	private int geyma;
	int monthExpires;
	int yearExpires;
	int flightNumberOut;
	int flightNumberBack;
	ArrayList<Flight> flightListOut;
	ArrayList<Flight> flightListBack;
	String creditNO;
	private JLabel lblKoma;
	private JLabel lblDagsetningFlugsDagurmnuurr;
	private JLabel lblStafjldi;
	private JLabel label;
	private JLabel lblName;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;



	public vidmot()  throws IOException  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 562);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//thessi lina er timabundin
		//setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		
		
		
		
		String [] placesFrom = DataManager.availablePlacesFrom(DataManager.crunchFile("src/flugtest.csv"));
		String [] placesTo = DataManager.availablePlacesTo(DataManager.crunchFile("src/flugtest.csv"));

		searchButton = new JButton("Search for flights");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(Color.WHITE);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				date = SearchAndBook.makeDate(day, month, year);
				flightListOut = SearchAndBook.searchFlight(whereFromName, whereToName, date,numberOfPassengers);
				Collections.sort(flightListOut);
				String[] stringFlightListOut = SearchAndBook.stringCurrentResults(flightListOut);
				if(flightListOut.size() > 0 ){
				lblVidLeitFundust.setText("Flight search results:");
				flightList.setListData(stringFlightListOut);
				} else {
					lblVidLeitFundust.setText("No flights were found");
				};
				
				if(rdbtnBadarLeidir.isSelected()) {
				dateHome = SearchAndBook.makeDate(dayHome, monthBack, yearBack);
				flightListBack = SearchAndBook.searchFlight(whereToName, whereFromName, dateHome,numberOfPassengers);
				Collections.sort(flightListBack);
				String[] stringFlightList = SearchAndBook.stringCurrentResults(flightListBack);
				
				if(flightListBack.size() > 0 ){
					lblVidLeitFundust_1.setText("Return flight search results:");
					flightListHome.setListData(stringFlightList);
					} else {
						lblVidLeitFundust_1.setText("No return flights were found");
					};
				}

			}
		});

		btnBoka = new JButton("Proceed to booking");
		btnBoka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (flightList.getSelectedIndex() > -1){
					bookingWindow.setVisible(true);
					lblDagsetningFlugsDagurmnuurr.setVisible(false);
					lblStafjldi.setVisible(false);
					label.setVisible(false);
					lbTitill.setVisible(false);
					lblBrottfr.setVisible(false);
					lblKoma.setVisible(false);
					flightList.setVisible(false);
					btnBoka.setVisible(false);
					pickWhereFrom.setVisible(false);
					pickWhereTo.setVisible(false);
					numPassengers.setVisible(false);
					pickWhereFrom.setVisible(false);
					pickWhereTo.setVisible(false);
					dagurUt.setVisible(false);
					rdbtnBadarLeidir.setVisible(false);
					lblVidLeitFundust.setVisible(false);
					lblVidLeitFundust_1.setVisible(false);
					flightListHome.setVisible(false);
					manudur.setVisible(false);
					ar.setVisible(false);
					dayHomeList.setVisible(false);
					monthHome.setVisible(false);
					yearHome.setVisible(false);
					searchButton.setVisible(false);
					if (rdbtnBadarLeidir.isSelected()) {
						lblBokunFlugs.setText("Booking flight from " + whereFromName + " to " + whereToName + "on the day of" + date + " and return flight on the day of " + dateHome + " for " +  numberOfPassengers + ".");	
					}
					else {
						lblBokunFlugs.setText("Booking flight from " + whereFromName + " to " + whereToName + " on the day of " + date +" for " +  numberOfPassengers + ".");
					}
				}
			}
		}
				);

		btnBoka.setBackground(Color.WHITE);
		btnBoka.setBounds(479, 384, 148, 107);
		contentPane.add(btnBoka);
		searchButton.setBounds(479, 213, 148, 106);
		contentPane.add(searchButton);

		pickWhereFrom = new JComboBox(placesFrom);
		pickWhereFrom.setSelectedIndex(-1);
		pickWhereFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				whereFromName = (String)cb.getSelectedItem();
			}
		});
		pickWhereFrom.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		pickWhereFrom.setToolTipText("");
		pickWhereFrom.setBounds(37, 89, 82, 20);
		contentPane.add(pickWhereFrom);


		pickWhereTo = new JComboBox(placesTo);
		pickWhereTo.setSelectedIndex(-1);

		pickWhereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				whereToName = (String)cb.getSelectedItem();
			}
		});
		pickWhereTo.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		pickWhereTo.setBounds(121, 89, 82, 20);
		contentPane.add(pickWhereTo);

		lbTitill = new JLabel("Flugbókunarþjónustan BAGG");
		lbTitill.setBounds(69, 11, 244, 51);
		contentPane.add(lbTitill);

		lblBrottfr = new JLabel("From");
		lblBrottfr.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrottfr.setBounds(37, 73, 82, 14);
		contentPane.add(lblBrottfr);

		flightList = new JList();
		flightList.setBackground(Color.WHITE);
		flightList.setBounds(37, 189, 345, 130);
		contentPane.add(flightList);

		lblVidLeitFundust = new JLabel("");
		lblVidLeitFundust.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidLeitFundust.setBounds(50, 164, 288, 14);
		contentPane.add(lblVidLeitFundust);

		lblVidLeitFundust_1 = new JLabel("");
		lblVidLeitFundust_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidLeitFundust_1.setBounds(76, 330, 237, 20);
		contentPane.add(lblVidLeitFundust_1);

		flightListHome = new JList();
		flightListHome.setBounds(37, 361, 345, 130);
		contentPane.add(flightListHome);

		dagurUt = new JComboBox();
		dagurUt.setBounds(200, 89, 82, 20);
		contentPane.add(dagurUt);
		
		

		int maxDagur = 31;
		for (int i = 1; i <= maxDagur; i++) {
			dagurUt.addItem(new Integer(i));
		}
		dagurUt.setSelectedIndex(-1);
		dagurUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				day = (int) cb.getSelectedItem();

			}
		});
		
		manudur = new JComboBox();
		manudur.setBounds(281, 89, 82, 20);
		contentPane.add(manudur);
		

		int maxManudur = 12;
		for (int i = 1; i <= maxManudur; i++) {
			manudur.addItem(new Integer(i));
		}
		manudur.setSelectedIndex(-1);
		manudur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				month = (int)(cb.getSelectedItem());

			}
		});

		String[] arListi = {"2017","2018"};
		ar = new JComboBox(arListi);
		ar.setBounds(362, 89, 82, 20);
		contentPane.add(ar);
		ar.setSelectedIndex(-1);

		rdbtnBadarLeidir = new JRadioButton("Both ways");
		rdbtnBadarLeidir.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					dayHomeList.setVisible(true);
					monthHome.setVisible(true);
					yearHome.setVisible(true);
					label.setVisible(true);
					
				}
				else if (arg0.getStateChange() == ItemEvent.DESELECTED) {
					dayHomeList.setVisible(false);
					monthHome.setVisible(false);
					yearHome.setVisible(false);
					label.setVisible(false);
				}
			}
		});


		rdbtnBadarLeidir.setBounds(546, 88, 109, 23);
		contentPane.add(rdbtnBadarLeidir);

		dayHomeList = new JComboBox();
		
		
		dayHomeList.setBounds(200, 133, 82, 20);
		contentPane.add(dayHomeList);

		for (int i = 1; i <= maxDagur; i++) {
			dayHomeList.addItem(new Integer(i));
		}
		
		dayHomeList.setSelectedIndex(-1);
		
		dayHomeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				dayHome = (int) cb.getSelectedItem();
			}
		});

		monthHome = new JComboBox();
		
		monthHome.setBounds(281, 133, 82, 20);
		contentPane.add(monthHome);

		for (int i = 1; i <= maxManudur; i++) {
			monthHome.addItem(new Integer(i));
		}
		
		monthHome.setSelectedIndex(-1);
		
		monthHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				monthBack = (int) cb.getSelectedItem();
			}
		});
		
		yearHome = new JComboBox(arListi);
		yearHome.setSelectedIndex(-1);
		
		yearHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				tempString = (String)cb.getSelectedItem();
				yearBack = Integer.parseInt(tempString);
			}
		});
		yearHome.setBounds(362, 133, 82, 20);
		contentPane.add(yearHome);

		numPassengers = new JComboBox();
		numPassengers.setBounds(441, 89, 89, 20);
		contentPane.add(numPassengers);

		bookingWindow = new JInternalFrame("Flight booking");
		bookingWindow.setBounds(0, 0, 651, 542);  //100, 100, 671, 562
		contentPane.add(bookingWindow);

		nafnBooking = new JTextField("");
		nafnBooking.setColumns(10);

		heimilisfangBooking = new JTextField();
		heimilisfangBooking.setColumns(10);

		simiBooking = new JTextField();
		simiBooking.setColumns(10);

		emailBooking = new JTextField();
		emailBooking.setColumns(10);

		kk1Booking = new JTextField();
		kk1Booking.setColumns(10);

		kk2Booking = new JTextField();
		kk2Booking.setColumns(10);

		kk3Booking = new JTextField();
		kk3Booking.setColumns(10);

		kk4Booking = new JTextField();
		kk4Booking.setColumns(10);

		securityNoBooking = new JTextField();
		securityNoBooking.setColumns(10);

		btnBoka_1 = new JButton("Confirm booking");
		btnBoka_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (rdbtnBadarLeidir.isSelected()){
					flightNumberOut = flightListOut.get(flightList.getSelectedIndex()).getFlightNumber();
					flightNumberBack = flightListBack.get(flightListHome.getSelectedIndex()).getFlightNumber();
					creditNO = kk1Booking.getText() + "-" + kk2Booking.getText() + "-" + kk3Booking.getText() + "-" 
							+  kk4Booking.getText() + "-" + securityNoBooking.getText() +"-"+ monthExpires + "/" + yearExpires;
					try {
						int mafs = Booking.book(nafnBooking.getText(), simiBooking.getText(), heimilisfangBooking.getText(), emailBooking.getText(), creditNO, flightNumberOut, numberOfPassengers);
						int mafs2 = Booking.book(nafnBooking.getText(), simiBooking.getText(), heimilisfangBooking.getText(), emailBooking.getText(), creditNO, flightNumberBack, numberOfPassengers);
						lblBokunTokstXd.setText("Bokunarnumerin thin eru " + mafs + " og " + mafs2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					flightNumberOut = flightListOut.get(flightList.getSelectedIndex()).getFlightNumber();
					creditNO = kk1Booking.getText() + "-" + kk2Booking.getText() + "-" + kk3Booking.getText() + "-" 
							+  kk4Booking.getText() + "-" + securityNoBooking.getText() +"-"+ monthExpires + "/" + yearExpires;
					try {
						int kukur = Booking.book(nafnBooking.getText(), simiBooking.getText(), heimilisfangBooking.getText(), emailBooking.getText(), creditNO, flightNumberOut, numberOfPassengers);
						lblBokunTokstXd.setText("Your booking number is " + kukur);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnBoka_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 18));

		lblBokunTokstXd = new JLabel("");
		lblBokunTokstXd.setHorizontalAlignment(SwingConstants.CENTER);

		expireMonth = new JComboBox();
		expireMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				monthExpires = (int)cb.getSelectedItem();
			}
		});
		for (int i = 1; i <= 12; i++) {
			expireMonth.addItem(new Integer(i));
		}

		expireYear = new JComboBox();
		for (int i = 17; i <= 25; i++) {
			expireYear.addItem(new Integer(i));
		}
		expireYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				yearExpires = (int)cb.getSelectedItem();
			}
		});

		JButton btnTilBaka = new JButton("Go back");
		btnTilBaka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bookingWindow.setVisible(false);
				lbTitill.setVisible(true);
				lblBrottfr.setVisible(true);
				//lblKoma.setVisible(true);
				flightList.setVisible(true);
				btnBoka.setVisible(true);
				pickWhereFrom.setVisible(true);
				pickWhereTo.setVisible(true);
				numPassengers.setVisible(true);
				pickWhereFrom.setVisible(true);
				pickWhereTo.setVisible(true);
				dagurUt.setVisible(true);
				rdbtnBadarLeidir.setVisible(true);
				lblVidLeitFundust.setVisible(true);
				lblVidLeitFundust_1.setVisible(true);
				flightListHome.setVisible(true);
				manudur.setVisible(true);
				ar.setVisible(true);
				dayHomeList.setVisible(true);
				monthHome.setVisible(true);
				yearHome.setVisible(true);
				searchButton.setVisible(true);
				lblBokunTokstXd.setText("");
			}
		});

		lblBokunFlugs = new JLabel("Bokun flugs");
		lblBokunFlugs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBokunFlugs.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblName = new JLabel("Name");
		
		label_1 = new JLabel("Address");
		
		label_2 = new JLabel("Phone number");
		
		label_3 = new JLabel("E-mail address");
		
		label_4 = new JLabel("Credit card information");

		GroupLayout groupLayout = new GroupLayout(bookingWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(heimilisfangBooking, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(emailBooking, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblBokunTokstXd, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(nafnBooking, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
										.addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(simiBooking, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(kk1Booking, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(kk2Booking, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(kk3Booking, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(kk4Booking, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(securityNoBooking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(expireMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBoka_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addComponent(expireYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnTilBaka)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(lblBokunFlugs, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnTilBaka)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBokunFlugs, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nafnBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(simiBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(heimilisfangBooking, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(emailBooking, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_4)
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(kk1Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(kk2Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(kk3Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(kk4Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(securityNoBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(expireMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(expireYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblBokunTokstXd, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(btnBoka_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
					.addGap(21))
		);
		bookingWindow.getContentPane().setLayout(groupLayout);
		bookingWindow.setVisible(false);


		for (int i = 1; i <= 8; i++) {
			numPassengers.addItem(new Integer(i));
		}
		
		numPassengers.setSelectedIndex(-1);
		
		lblKoma = new JLabel("To");
		lblKoma.setHorizontalAlignment(SwingConstants.LEFT);
		lblKoma.setBounds(121, 73, 82, 14);
		contentPane.add(lblKoma);
		
		lblDagsetningFlugsDagurmnuurr = new JLabel("Date of flight, day/month/year");
		lblDagsetningFlugsDagurmnuurr.setHorizontalAlignment(SwingConstants.LEFT);
		lblDagsetningFlugsDagurmnuurr.setBounds(207, 73, 230, 14);
		contentPane.add(lblDagsetningFlugsDagurmnuurr);
		
		lblStafjldi = new JLabel("Passengers");
		lblStafjldi.setHorizontalAlignment(SwingConstants.LEFT);
		lblStafjldi.setBounds(448, 73, 82, 14);
		contentPane.add(lblStafjldi);
		
		label = new JLabel("Date of return flight, day/month/year");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(207, 117, 230, 13);
		contentPane.add(label);
		label.setVisible(false);
		
		numPassengers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				numberOfPassengers = (int)cb.getSelectedItem();
			}
		});


		dayHomeList.setVisible(false);
		monthHome.setVisible(false);
		yearHome.setVisible(false);

		ar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				tempString = (String)cb.getSelectedItem();
				year = Integer.parseInt(tempString);

			}
		});

	}
}
