
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class SearchAndBook {
	
	public static void main(String[] args) {
		//String fileName = "flugtest.csv";
		//String fileName = "src/flugtest.csv";

		
		String hvadan = "BRU";
		String hvert = "KEF";
		String hvenaer = "05.04.17";
		//String hvenaerHeim = "30.04.17";

		ArrayList<Flight> ut = searchFlight(hvadan, hvert, hvenaer);
		//ArrayList<Flight> heim = searchFlightBack(hvert,hvadan,hvenaerHeim);

		//ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
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


	public ArrayList<Flight> flightList;
	
	public static void dateSort(ArrayList<Flight >flightList){
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

	public static ArrayList<Flight> searchFlight(String whereFrom, String whereTo, String date){
		//String fileName = "flugtest.csv";
		//String fileName = "src/flugtest.csv";
		Place keflavik = new Place();
		keflavik.setName("KEF");
		Place copenhagen = new Place();
		copenhagen.setName("CPH");
		Place brussel = new Place();
		brussel.setName("BRU");
		Place losangeles = new Place();
		losangeles.setName("LAX");

		ArrayList<Flight> flightList = new ArrayList<Flight>(5);
		Flight flight1 = Flight.createFlight(keflavik, copenhagen,30000,"9","20.04.17",2.5);
		flightList.add(flight1);
		
		Flight flight2 = Flight.createFlight(keflavik, losangeles,35000,"7","25.04.17",5.5);
		flightList.add(flight2);
		
		Flight flight3 = Flight.createFlight(losangeles, copenhagen,90000,"21","20.09.17",8);
		flightList.add(flight3);
		
		Flight flight4 = Flight.createFlight(brussel, copenhagen,20000,"4","24.04.17",2.0);
		flightList.add(flight4);
		
		Flight flight5 = Flight.createFlight(keflavik, brussel,30000,"16","05.04.17",3.5);
		flightList.add(flight5);
		
				
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
