
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class SearchAndBook {
	
	public String fileName;
	public ArrayList<Flight> flightList;
	
	// Smidur fyrir SearchAndBook
	public SearchAndBook(ArrayList<Flight> flightList, String fileName) {
		this.fileName = fileName;
		this.flightList = flightList;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public ArrayList<Flight> getFlightList() {
		return flightList;
	}
	
	
	public static void main(String[] args) {
		//String fileName = "flugtest.csv";
		String fileName = "src/flugtest.csv";

		
		String hvadan = "KEF";
		String hvert = "BRU";
		String hvenaer = "20.04.17";
		
		//String hvenaerHeim = "30.04.17";
		ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
		ArrayList<Flight> ut = searchFlight(flightList,hvadan, hvert, hvenaer);
		//ArrayList<Flight> heim = searchFlightBack(hvert,hvadan,hvenaerHeim);

		
		//System.out.println("Fann thessi flug ut, reyndi ad rada eftir dagsetningu:\n");
		System.out.println("Fann thessi flug ut, odyrasta efst:\n");
		Collections.sort(ut);
		printCurrentResults(ut);
		//System.out.println("Fann thessi flug heim, odyrasta efst:\n");
		//Collections.sort(heim);
		//printCurrentResults(heim);
		//System.out.println("\nAf ollum thessum!\n");
		//dateSort(heim);
		//printCurrentResults(heim);
	}


	
	
	public static void dateSort(ArrayList<Flight> flightList){
		Collections.sort(flightList, new Comparator<Flight>() {
			  public int compare(Flight flight1, Flight flight2) {
			      return flight1.getDate().compareTo(flight2.getDate());
			  }
			});
		return;
	}

	public ArrayList<Flight> customSort(ArrayList<Flight> flightList) {
		
		return flightList;
	}

	public static ArrayList<Flight> searchFlight(ArrayList<Flight> flightList,String whereFrom, String whereTo, String date){
		//String fileName = "flugtest.csv";
		//String fileName = "src/flugtest.csv";
		//ArrayList<Flight> flightList = DataManager.cruchFile(filename);
		
		
		
				
		ArrayList<Flight> foundFlight = new ArrayList<Flight>(flightList.size());
		
		for(int i = 0; i < flightList.size(); i++) {
		
		if(        whereFrom.equals(flightList.get(i).getWhereFrom().getName())
				&& whereTo.equals(flightList.get(i).getWhereTo().getName())
				&& date.equals(flightList.get(i).getDate()))
		{
			foundFlight.add(flightList.get(i));
		}

	}

		return foundFlight;
	}
	
	public static ArrayList<Flight> searchFlightBack(String whereFrom, String whereTo, String dateBack){
		//String fileName = "flugtest.csv";
		String fileName = "src/flugtest.csv";

		ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
		ArrayList<Flight> foundFlightBack = new ArrayList<Flight>(flightList.size());


		for(int i = 0; i < flightList.size(); i++) {
			
			if(        whereFrom.equals(flightList.get(i).getWhereFrom().getName())
					&& whereTo.equals(flightList.get(i).getWhereTo().getName())
					&& dateBack.equals(flightList.get(i).getDate()))
			{
				foundFlightBack.add(flightList.get(i));
			}

		}

		return foundFlightBack;
	}
	
	public static void printCurrentResults(ArrayList<Flight> flightList){

		System.out.println("Fra \tTil\tDags\t\tVerd");

		for(int i = 0; i < flightList.size(); i++) {
			System.out.print(flightList.get(i).getWhereFrom().getName() + "\t");
			System.out.print(flightList.get(i).getWhereTo().getName() + "\t");
			System.out.print(flightList.get(i).getDate() + "\t");
			System.out.println(flightList.get(i).getPrice()+"\n");
		}
	}

}
