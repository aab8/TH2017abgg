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

public class vidmot extends JFrame {

	private JPanel contentPane;
	private JLabel lbTitill;
	private JLabel lblBrottfr;
	private JLabel lblKoma;
	private JList flightList;
	private JList flightListBackJList;
	private JButton btnBoka;
	private JLabel lblVidLeitFundust;
	private JLabel lblPrufa;
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



	public vidmot()  throws IOException  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 562);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);


		String [] placesFrom = DataManager.availablePlacesFrom(DataManager.crunchFile("src/flugtest.csv"));
		String [] placesTo = DataManager.availablePlacesTo(DataManager.crunchFile("src/flugtest.csv"));

		searchButton = new JButton("LEITA!!!");
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
				flightList.setListData(stringFlightListOut);

				dateHome = SearchAndBook.makeDate(dayHome, monthBack, yearBack);
				flightListBack = SearchAndBook.searchFlight(whereToName, whereFromName, dateHome,numberOfPassengers);
				Collections.sort(flightListBack);
				String[] stringFlightList = SearchAndBook.stringCurrentResults(flightListBack);
				flightListHome.setListData(stringFlightList);

			}
		});

		btnBoka = new JButton("BOOK");
		btnBoka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (flightList.getSelectedIndex() > -1){
					bookingWindow.setVisible(true);
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
					lblPrufa.setVisible(false);
					lblVidLeitFundust_1.setVisible(false);
					flightListHome.setVisible(false);
					manudur.setVisible(false);
					ar.setVisible(false);
					dayHomeList.setVisible(false);
					monthHome.setVisible(false);
					yearHome.setVisible(false);
					searchButton.setVisible(false);
					if (rdbtnBadarLeidir.isSelected()) {
						lblBokunFlugs.setText("Bokun flugs fra " + whereFromName + " til " + whereToName + " thann " + date + " og til baka thann " + dateHome + " fyrir " +  numberOfPassengers + ".");	
					}
					else {
						lblBokunFlugs.setText("Bokun flugs fra " + whereFromName + " til " + whereToName + " thann " + date +" fyrir " +  numberOfPassengers + ".");
					}
				}
			}
		}
				);
		btnBoka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (flightList.getSelectedIndex() > -1){
					/*bookingWindow.setVisible(true);
					lbTitill.setVisible(false);
					lblBrottfr.setVisible(false);
					lblKoma.setVisible(false);
					flightList.setVisible(false);
					flightListBackJList.setVisible(false);
					btnBoka.setVisible(false);
					lblVidLeitFundust.setVisible(false);
					lblPrufa.setVisible(false);
					lblVidLeitFundust_1.setVisible(false);
					flightListHome.setVisible(false);
					manudur.setVisible(false);
					ar.setVisible(false);
					dayHomeList.setVisible(false);
					monthHome.setVisible(false);
					yearHome.setVisible(false);*/

				}
			}
		});
		btnBoka.setBackground(Color.WHITE);
		btnBoka.setBounds(479, 337, 89, 64);
		contentPane.add(btnBoka);
		searchButton.setBounds(479, 213, 89, 64);
		contentPane.add(searchButton);

		pickWhereFrom = new JComboBox(placesFrom);
		pickWhereFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				whereFromName = (String)cb.getSelectedItem();
				lblPrufa.setText(whereFromName);
			}
		});
		pickWhereFrom.setBackground(Color.ORANGE);
		pickWhereFrom.setToolTipText("");
		pickWhereFrom.setBounds(37, 89, 82, 20);
		contentPane.add(pickWhereFrom);


		pickWhereTo = new JComboBox(placesTo);
		pickWhereTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				whereToName = (String)cb.getSelectedItem();
				lblPrufa.setText(whereToName);
			}
		});
		pickWhereTo.setBackground(Color.CYAN);
		pickWhereTo.setBounds(121, 89, 82, 20);
		contentPane.add(pickWhereTo);

		lbTitill = new JLabel("Flugbókunarþjónustan BAGG");
		lbTitill.setBounds(69, 11, 244, 51);
		contentPane.add(lbTitill);

		lblBrottfr = new JLabel("Brottfor");
		lblBrottfr.setBounds(51, 73, 46, 14);
		contentPane.add(lblBrottfr);

		lblKoma = new JLabel("Koma");
		lblKoma.setBounds(146, 73, 46, 14);
		contentPane.add(lblKoma);

		//String [] flug = {"FLUG 1", "FLUG 2", "FLUG 3", "FLUG 4", "FLUG 2", "FLUG 3", "FLUG 4", "FLUG 2", "FLUG 3", "FLUG 4"};
		flightList = new JList();
		flightList.setBackground(Color.WHITE);
		flightList.setBounds(37, 189, 345, 130);
		contentPane.add(flightList);

		lblVidLeitFundust = new JLabel("Vid leit fundust thessi flug");
		lblVidLeitFundust.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidLeitFundust.setBounds(50, 164, 288, 14);
		contentPane.add(lblVidLeitFundust);

		lblPrufa = new JLabel("Prufa");
		lblPrufa.setBounds(436, 168, 46, 14);
		contentPane.add(lblPrufa);

		lblVidLeitFundust_1 = new JLabel("Vid leit fundust thessi flug til baka");
		lblVidLeitFundust_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidLeitFundust_1.setBounds(76, 330, 237, 20);
		contentPane.add(lblVidLeitFundust_1);

		flightListHome = new JList();
		flightListHome.setBounds(37, 361, 345, 130);
		contentPane.add(flightListHome);

		dagurUt = new JComboBox();
		dagurUt.setBounds(200, 89, 82, 20);
		contentPane.add(dagurUt);

		dagurUt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox cb = (JComboBox)arg0.getSource();
				day = (int) cb.getSelectedItem();

			}
		});

		int maxDagur = 31;
		for (int i = 1; i <= maxDagur; i++) {
			dagurUt.addItem(new Integer(i));
		}



		manudur = new JComboBox();
		manudur.setBounds(281, 89, 82, 20);
		contentPane.add(manudur);

		int maxManudur = 12;
		for (int i = 1; i <= maxManudur; i++) {
			manudur.addItem(new Integer(i));
		}

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

		rdbtnBadarLeidir = new JRadioButton("Badar leidir");
		rdbtnBadarLeidir.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {
					dayHomeList.setVisible(true);
					monthHome.setVisible(true);
					yearHome.setVisible(true);
				}
				else if (arg0.getStateChange() == ItemEvent.DESELECTED) {
					dayHomeList.setVisible(false);
					monthHome.setVisible(false);
					yearHome.setVisible(false);
				}
			}
		});


		rdbtnBadarLeidir.setBounds(546, 88, 109, 23);
		contentPane.add(rdbtnBadarLeidir);

		dayHomeList = new JComboBox();
		dayHomeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				dayHome = (int) cb.getSelectedItem();
			}
		});
		dayHomeList.setBounds(200, 133, 82, 20);
		contentPane.add(dayHomeList);

		for (int i = 1; i <= maxDagur; i++) {
			dayHomeList.addItem(new Integer(i));
		}


		monthHome = new JComboBox();
		monthHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				monthBack = (int) cb.getSelectedItem();
			}
		});
		monthHome.setBounds(281, 133, 82, 20);
		contentPane.add(monthHome);

		for (int i = 1; i <= maxManudur; i++) {
			monthHome.addItem(new Integer(i));
		}

		yearHome = new JComboBox(arListi);
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
		bookingWindow.setBounds(37, 24, 507, 437);
		contentPane.add(bookingWindow);

		nafnBooking = new JTextField();
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

		btnBoka_1 = new JButton("BOKA :) ;) :P");
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
						lblBokunTokstXd.setText("Bokunarnumerid thitt er " + kukur);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnBoka_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 24));

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

		JButton btnTilBaka = new JButton("Til baka");
		btnTilBaka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bookingWindow.setVisible(false);
				lbTitill.setVisible(true);
				lblBrottfr.setVisible(true);
				lblKoma.setVisible(true);
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
				lblPrufa.setVisible(true);
				lblVidLeitFundust_1.setVisible(true);
				flightListHome.setVisible(true);
				manudur.setVisible(true);
				ar.setVisible(true);
				dayHomeList.setVisible(true);
				monthHome.setVisible(true);
				yearHome.setVisible(true);
				searchButton.setVisible(true);
			}
		});

		lblBokunFlugs = new JLabel("Bokun flugs");
		lblBokunFlugs.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBokunFlugs.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout groupLayout = new GroupLayout(bookingWindow.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(25)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(nafnBooking, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(simiBooking, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
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
														.addComponent(expireYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(heimilisfangBooking, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblBokunTokstXd, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
														.addGap(18)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
																.addComponent(btnBoka_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
																.addComponent(emailBooking, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(btnTilBaka)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(38)
										.addComponent(lblBokunFlugs, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(27, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(btnTilBaka)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblBokunFlugs, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(nafnBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(simiBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(heimilisfangBooking, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailBooking, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(kk1Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(kk2Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(kk3Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(kk4Booking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(securityNoBooking, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(expireMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(expireYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBoka_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBokunTokstXd, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGap(67))
				);
		bookingWindow.getContentPane().setLayout(groupLayout);
		bookingWindow.setVisible(false);


		for (int i = 1; i <= 8; i++) {
			numPassengers.addItem(new Integer(i));
		}

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
