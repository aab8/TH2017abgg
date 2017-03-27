import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataManager {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "src/flugtest.csv";
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
		Flight flight = new Flight();
		//Fara i gegnum hverja linu í skranni fyrir sig og gefa flight eiginleika.
		//Fylla svo upp í flightList i lok hverrar itrunar
		
		//whereTo - Afangastadur
		Place whereFrom = new Place();
		String whereFromName = flightFile.get(i).get(0);
		whereFrom.setName(whereFromName);
		flight.setWhereFrom(whereFrom);
		
		//whereFrom - Brottfararstadur
		Place whereTo = new Place();
		String whereToName = flightFile.get(i).get(1);
		whereTo.setName(whereToName);
		flight.setWhereTo(whereTo);
		
		//price - Verd
		double price = Double.parseDouble(flightFile.get(i).get(5));
		flight.setPrice(price);
		
		
		//time - Timi dags
		flight.setTime(flightFile.get(i).get(3));
		
		//date - Dagsetning
		//flight.setDate(flightFile.get(i).get(2));
		
		//duration - Lengd flugs i klst
		int duration = Integer.parseInt(flightFile.get(i).get(4));
		flight.setDuration(duration);
		
		/*
		private String airline;
		private String flightNumber;
		private int numSeatsLeft;
		*/
		flightList.add(flight);
	}
	
	return flightList;
}
}
