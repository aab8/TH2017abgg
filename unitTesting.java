import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class unitTesting {
	private Flight flight1, flight2, flight3, flight4, flight5;
	private ArrayList<Flight> flightList;
	private Place keflavik, copenhagen, brussel, losangeles;

	@Before
	public void setUp() {  
		keflavik = new Place("KEF");
		copenhagen = new Place("CPH");
		brussel = new Place("BRU");
		losangeles = new Place("LAX");

		flightList = new ArrayList<Flight>(5);

		flight1 = new Flight(keflavik, copenhagen,30000,"9","25.04.17",2.5);
		flight2 = new Flight(keflavik, copenhagen,35000,"7","25.04.17",5.5);
		flight3 = new Flight(losangeles, copenhagen,90000,"21","20.09.17",8);
		flight4 = new Flight(brussel, copenhagen,20000,"4","24.04.17",2.0);
		flight5 = new Flight(brussel,keflavik, 23456 ,"5", "20.04.17" ,3.0);

		flightList.add(flight1);
		flightList.add(flight2);
		flightList.add(flight3);
		flightList.add(flight4);
		flightList.add(flight5);
	}



	@After
	public void tearDown(){
		flightList = null;
		flight1 = null;
		flight2 = null;
		flight3 = null;
		flight4 = null;
		flight5 = null;
		keflavik = null;
		copenhagen = null;
		brussel = null;
		losangeles = null;
	}

	@Test
	public void testSearchSize() {
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"KEF","BRU","20.04.17");
		assertEquals(1,testList.size());
	}

	@Test
	public void testSearchName() {
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"KEF","BRU","20.04.17");
		assertEquals("KEF",testList.get(0).getWhereFrom().getName());
	}


	@Test
	public void testSearchNotNull() {
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"KEF","BRU","20.04.17");
		assertNotNull(testList.get(0));
	}

	@Test
	public void testSearchIfTypo() {
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"KEF","BUR","20.04.17");
		assertEquals(0,testList.size());
	}

	@Test
	public void testSearchDuplicateFlights() {
		ArrayList<Flight> expectedList = new ArrayList<Flight>(2);
		expectedList.add(flight1);
		expectedList.add(flight2);
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"CPH","KEF","25.04.17");
		assertEquals(testList, expectedList);
	}

	@Test
	public void testSearchCheapestOnTop() {
		ArrayList<Flight> expectedList = new ArrayList<Flight>(2);
		expectedList.add(flight1);
		expectedList.add(flight2);
		ArrayList<Flight> testList = SearchAndBook.searchFlight(flightList,"CPH","KEF","25.04.17");
		assertTrue(testList.get(0).getPrice() < testList.get(1).getPrice());
	}



}
