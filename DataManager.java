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

public class DataManager {

	public static void main(String[] args) throws IOException {
		//String fileName = "flugtest.csv";
		String fileName = "src/flugtest.csv";

		/* PRENTAR ÚT "flugtest.csv"
		List<List<String>> lines = scanFile(fileName);
		int lineNo = 1;
		for(List<String> line: lines) {
			int columnNo = 1;
			for (String value: line) {
				System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
				columnNo++;
			}
			lineNo++;
		}
		 */
		/*ArrayList<Flight> flightList = crunchFile(fileName);
		String[] placesFrom = availablePlacesFrom(flightList);
		System.out.println("Lengd placesFrom: " + placesFrom.length);

		for(int i = 0; i < placesFrom.length; i++) {

			System.out.println(placesFrom[i]);
		} */
		
		
		Booking booking  = new Booking("Gretar", "123123", "st" ,"ergeg", "str", 12345);
		appendCSV(booking);

	}

	public static List<List<String>> scanFile(String fileName) {

		File file = new File(fileName);
		// this gives you a 2-dimensional array of strings
		List<List<String>> lines = new ArrayList<>();
		Scanner inputStream;

		try
		{
			inputStream = new Scanner(file);

			while(inputStream.hasNext()){
				String line = inputStream.next();
				String[] values = line.split(",");

				// this adds the currently parsed line to the 2-dimensional string array
				lines.add(Arrays.asList(values));
			}
			inputStream.close();
		}

		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return lines;
	}

	public static ArrayList<Flight> crunchFile(String fileName){
		//Lesum inn skrana
		List<List<String>> flightFile = scanFile(fileName);
		//Fjoldi fluga
		int numFlights = flightFile.size();
		//Foruthluta
		ArrayList<Flight> flightList = new ArrayList<Flight>(numFlights);
		//Herna aetti ad koma einhvers konar lykkja
		for (int i = 0;i < numFlights;i++){
			//Flight flight = new Flight();
			//Fara i gegnum hverja linu i skranni fyrir sig og na i eiginleika fyrir flight.
			//Baeta svo vid i flightList i lok hverrar itrunar

			//whereTo - Afangastadur
			Place whereFrom = new Place(flightFile.get(i).get(0));

			//whereFrom - Brottfararstadur
			Place whereTo = new Place(flightFile.get(i).get(1));

			//price - Verd
			double price = Double.parseDouble(flightFile.get(i).get(5));

			//time - Timi dags
			String time = (flightFile.get(i).get(3));

			//date - Dagsetning
			String date = (flightFile.get(i).get(2));

			//duration - Lengd flugs i klst
			double duration = Double.parseDouble(flightFile.get(i).get(4));

			int numSeatsLeft = Integer.parseInt(flightFile.get(i).get(6));

			int flightNumber = Integer.parseInt(flightFile.get(i).get(7));

			Flight flight = new Flight(whereTo, whereFrom, price, time, date, duration, numSeatsLeft,flightNumber);
			flightList.add(flight);
		}

		return flightList;
	}

	public static void writeCSV(ArrayList<Flight> flightList) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(new File("src/flugtest.csv"));
		StringBuilder line = new StringBuilder();

		for(int i = 0; i < flightList.size(); i++)
		{
			line.append(flightList.get(i).getWhereFrom().getName());
			line.append(",");
			line.append(flightList.get(i).getWhereTo().getName());
			line.append(",");
			line.append(flightList.get(i).getDate());
			line.append(",");
			line.append(flightList.get(i).getTime());
			line.append(",");
			line.append(flightList.get(i).getDuration());
			line.append(",");
			line.append(flightList.get(i).getPrice());
			line.append(",");
			line.append(flightList.get(i).getNumSeatsLeft());
			//line.append((int) (Math.random()*80));    Byr til random numSeatsLeft
			line.append(",");
			line.append(1000+i);
			line.append(",");
			line.append("\n");
		}

		pw.write(line.toString());
		pw.close();
	}

	public static String[] availablePlacesFrom(ArrayList<Flight> flightList) {
		int numFlights = flightList.size();

		String[] places = new String[numFlights];

		for (int i = 0;i < numFlights;i++) {
			places[i] = flightList.get(i).getWhereFrom().getName();
		}

		Set<String> temp = new HashSet<String>(Arrays.asList(places));
		String[] uq = temp.toArray(new String[temp.size()]);

		return uq;
	}

	public static String[] availablePlacesTo(ArrayList<Flight> flightList) {
		int numFlights = flightList.size();

		String[] places = new String[numFlights];

		for (int i = 0;i < numFlights;i++) {
			places[i] = flightList.get(i).getWhereTo().getName();
		}

		Set<String> temp = new HashSet<String>(Arrays.asList(places));
		String[] uq = temp.toArray(new String[temp.size()]);

		return uq;
	}

	public static void adjustFlightFile(int flightNumber, int numPassengers) throws FileNotFoundException{
		ArrayList<Flight> flightList = crunchFile("src/flugtest.csv");
		for(int i = 0;i < flightList.size();i++){
			if(flightList.get(i).getFlightNumber() == flightNumber){
				flightList.get(i).setNumSeatsLeft(flightList.get(i).getNumSeatsLeft() - numPassengers);
			}

		}
		writeCSV(flightList);
	}
	
	public static void appendCSV(Booking booking) throws IOException {
		FileWriter pw = new FileWriter("src/bookings.csv",true);
		StringBuilder line = new StringBuilder();

		line.append(booking.getName());
		line.append(",");
		line.append(booking.getPhoneNO());
		line.append(",");
		line.append(booking.getAddress());
		line.append(",");
		line.append(booking.geteMail());
		line.append(",");
		line.append(booking.getCreditNO());
		line.append(",");
		line.append(booking.getBookingNO());
		line.append(",");
		line.append("\n");

		pw.append(line.toString());
		pw.close();
	}

}
