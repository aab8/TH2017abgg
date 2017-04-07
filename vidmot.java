import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class vidmot extends JFrame {

	private JPanel contentPane;
	private JTextField txtSladuInnDag;
	private JTextField txtDagurHeim;
	private JLabel lbTitill;
	private JLabel lblBrottfr;
	private JLabel lblKoma;
	private JList flightList;
	private JButton btnBoka;
	private JLabel lblVidLeitFundust;
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
	public vidmot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String [] places = {"KEF", "CPH", "BRU", "LAX"};
		
		JButton searchButton = new JButton("LEITA!!!");
		searchButton.setForeground(Color.BLACK);
		searchButton.setBackground(Color.WHITE);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		
		btnBoka = new JButton("BOOK");
		btnBoka.setBackground(Color.WHITE);
		btnBoka.setBounds(388, 168, 89, 64);
		contentPane.add(btnBoka);
		searchButton.setBounds(388, 67, 89, 64);
		contentPane.add(searchButton);
		JComboBox pickWhereFrom = new JComboBox(places);
		pickWhereFrom.setBackground(Color.ORANGE);
		pickWhereFrom.setToolTipText("Tunna");
		pickWhereFrom.setBounds(37, 89, 82, 20);
		contentPane.add(pickWhereFrom);
		
		
		JComboBox pickWhereTo = new JComboBox(places);
		pickWhereTo.setBackground(Color.CYAN);
		pickWhereTo.setBounds(121, 89, 82, 20);
		contentPane.add(pickWhereTo);
		
		//pickWhereTo.addItem(places);
		//pickWhereFrom.addItem(places);
		
		txtSladuInnDag = new JTextField();
		txtSladuInnDag.setText("Sladu inn dag");
		txtSladuInnDag.setBounds(204, 89, 86, 20);
		contentPane.add(txtSladuInnDag);
		txtSladuInnDag.setColumns(10);
		
		txtDagurHeim = new JTextField();
		txtDagurHeim.setText("Dagur heim");
		txtDagurHeim.setBounds(292, 89, 86, 20);
		contentPane.add(txtDagurHeim);
		txtDagurHeim.setColumns(10);
		
		lbTitill = new JLabel("Flugbókunarþjónustan BAGG");
		lbTitill.setBounds(69, 11, 244, 51);
		contentPane.add(lbTitill);
		
		lblBrottfr = new JLabel("Brottfor");
		lblBrottfr.setBounds(51, 73, 46, 14);
		contentPane.add(lblBrottfr);
		
		lblKoma = new JLabel("Koma");
		lblKoma.setBounds(146, 73, 46, 14);
		contentPane.add(lblKoma);
		
		String [] flug = {"FLUG 1", "FLUG 2", "FLUG 3", "FLUG 4", "FLUG 2", "FLUG 3", "FLUG 4", "FLUG 2", "FLUG 3", "FLUG 4"};
		flightList = new JList(flug);
		flightList.setBackground(Color.LIGHT_GRAY);
		flightList.setBounds(37, 155, 345, 130);
		contentPane.add(flightList);
		
		lblVidLeitFundust = new JLabel("Vid leit fundust thessi flug");
		lblVidLeitFundust.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidLeitFundust.setBounds(47, 130, 288, 14);
		contentPane.add(lblVidLeitFundust);
		
	}
}
