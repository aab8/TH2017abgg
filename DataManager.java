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
	//Lesum inn skrána
	List<List<String>> flightFile = scanFile(fileName);
	//Fjöldi fluga
	int numFlights = flightFile.size();
	//Forúthluta
	ArrayList<Flight> flightList = new ArrayList<Flight>(numFlights);
	//Hérna ætti að koma einhvers konar lykkja
	for (int i = 0;i < numFlights;i++){
		Flight flight = new Flight();
		//Fara í gegnum hverja línu í skránni fyrir sig og gefa flight eiginleika.
		//Fylla svo upp í flightList í lok hverrar ítrunar
		Place whereFrom = new Place();
		String whereFromName = flightFile.get(i).get(0);
		whereFrom.setName(whereFromName);
		flight.setWhereFrom(whereFrom);
		
		/*private Place whereTo;
		private Place whereFrom;
		private double price;
		private String time;
		private int duration;
		private String airline;
		private String flightNumber;
		private int numSeatsLeft;
		*/
		flightList.add(flight);
		//BRYNJAR REFRESH
		//GRETAR REFRESH
	}
	
	return flightList;
}
}
