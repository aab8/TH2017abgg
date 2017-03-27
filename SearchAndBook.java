
import java.util.ArrayList;

public class SearchAndBook {
	public static void main(String[] args) {
		String fileName = "src/flugtest.csv";
		
		ArrayList<Flight> test = searchFlight("KEF","BRU","20.04.17");
		
	}
	
	
	public ArrayList<Flight> flightList;

	public ArrayList<Flight> customSort(ArrayList<Flight> flightList, String sortBy, boolean order) {
			
		return flightList;
	}

	public static ArrayList<Flight> searchFlight(String whereTo, String whereFrom, String date){
		String fileName = "src/flugtest.csv";
		ArrayList<Flight> flightList = DataManager.crunchFile(fileName);
		
		for(int i = 0; i < flightList.size(); i++) {
			//if(isEqual(whereTo, flightList.get(i).getWhereTo());
		}
		
		return flightList;
	}

	public void printCurrentResults(ArrayList<Flight> flightList){
		System.out.println("FLUGLISTI");
	}

}
