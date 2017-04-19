import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;


public class Booking {
	private String name;
	private String phoneNO;
	private String address;
	private String eMail;
	private String creditNO;
	private int bookingNO;

	public static void main(String[] args) throws IOException {
		//List<List<String>> bookingFile = DataManager.scanFile("src/bookings.csv");
		//System.out.println(bookingFile.get(1).get(3));
	}

	public Booking(String name, String phoneNO, String address, String eMail, String creditNO, int bookingNO) {
		super();
		this.name = name;
		this.phoneNO = phoneNO;
		this.address = address;
		this.eMail = eMail;
		this.creditNO = creditNO;
		this.bookingNO = bookingNO;
	}


	public int getBookingNO() {
		return bookingNO;
	}


	public void setBookingNO(int bookingNO) {
		this.bookingNO = bookingNO;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNO() {
		return phoneNO;
	}
	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCreditNO() {
		return creditNO;
	}
	public void setCreditNO(String creditNO) {
		this.creditNO = creditNO;
	}


	public static Integer[] getCurrentBookingNO(String fileName) {
		List<List<String>> bookingFile = DataManager.scanFile(fileName);
		Integer[] bookingNOs = new Integer[bookingFile.size()];
		for(int i = 0; i < bookingFile.size(); i++) {
			bookingNOs[i] = Integer.parseInt(bookingFile.get(i).get(5));
		}
		return bookingNOs;
	}


	public static int generateBookingNO(String fileName) {
		Integer[] bookingNOs = getCurrentBookingNO(fileName);
		if(bookingNOs.length == 0) return 35783301;
		else {
			Arrays.sort(bookingNOs);
			int bookingNO = bookingNOs[bookingNOs.length-1]+1;
			return bookingNO;
		}
	}

	public static int book(String name, String phoneNO, String address, String eMail, String creditNO, int flightNO, int numPassengers) throws IOException{
		//int bookingNO = generateBookingNO("src/bookings.csv");
		int bookingNO = (int) (Math.random()*1000000)+1000; 
		Booking booking = new Booking(name, phoneNO, address, eMail, creditNO, bookingNO);

		DataManager.adjustFlightFile(flightNO, numPassengers);
		DataManager.appendCSV(booking);
		return bookingNO;
	}

}