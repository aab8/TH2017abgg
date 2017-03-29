
import java.util.ArrayList;
import java.util.Collections;

public class SearchAndBook {
	public static void main(String[] args) {
		//String fileName = "flugtest.csv";
		String fileName = "src/flugtest.csv";

		String hvadan = "DXB";
		String hvert = "KEF";
		String hvenaer = "15.05.17";

		ArrayList<Flight> test = searchFlight(hvert, hvadan, hvenaer);

		ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
		System.out.println("Fann thessi flug:\n");
		printCurrentResults(test);
		System.out.println("\nAf ollum thessum!\n");
		printCurrentResults(flightList);
	}


	public ArrayList<Flight> flightList;

	public ArrayList<Flight> customSort(ArrayList<Flight> flightList, String sortBy, boolean order) {

		return flightList;
	}

	public static ArrayList<Flight> searchFlight(String whereTo, String whereFrom, String date){
		//String fileName = "flugtest.csv";
		String fileName = "src/flugtest.csv";

		ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
		ArrayList<Flight> foundFlight = new ArrayList<Flight>(flightList.size());
		// int count = 0;


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

	public static void printCurrentResults(ArrayList<Flight> flightList){
		System.out.println("Fra \tTil\tDags\t\tVerd");
		for(int i = 0; i < flightList.size(); i++) {
			System.out.print(flightList.get(i).getWhereTo().getName() + "\t");
			System.out.print(flightList.get(i).getWhereFrom().getName() + "\t");
			System.out.print(flightList.get(i).getDate() + "\t");
			System.out.println(flightList.get(i).getPrice());
		}
	}

}
