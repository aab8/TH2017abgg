
import java.util.ArrayList;
// ÞETTA KOMMENT ER BARA GITHUB PRUFA
public class SearchAndBook {
	public static void main(String[] args) {
		String fileName = "flugtest.csv";
		// String fileName = "src/flugtest.csv";

		String hvadan = "DXB";
		String hvert = "KEF";
		String hvenaer = "15.05.17";

		ArrayList<Flight> test = searchFlight(hvert, hvadan, hvenaer);

		System.out.println(test.size());

		System.out.println("Leitaði að flugi frá " + hvadan + " til " + hvert);
		System.out.println("Fann flug frá " + test.get(0).getWhereFrom().getName() + " til " + test.get(0).getWhereTo().getName() );
		if(test.size()>1) {
			System.out.println("Fann líka flug frá " + test.get(1).getWhereFrom().getName()  + " til " + test.get(1).getWhereTo().getName() );
		}
		
	}


	public ArrayList<Flight> flightList;

	public ArrayList<Flight> customSort(ArrayList<Flight> flightList, String sortBy, boolean order) {

		return flightList;
	}

	public static ArrayList<Flight> searchFlight(String whereTo, String whereFrom, String date){
		String fileName = "flugtest.csv";
		// String fileName = "src/flugtest.csv";

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

	public void printCurrentResults(ArrayList<Flight> flightList){
		System.out.println("FLUGLISTI");
	}

}
