

public class Flight implements Comparable<Flight>{

	private Place whereTo;
	private Place whereFrom;
	private double price;
	private String time;
	private String date;
	private double duration;
	private String airline;
	private int numSeatsLeft;
	private int flightNumber;
	
	public  Flight(Place whereTo, Place whereFrom, double price, String time, String date,double duration,int numSeatsLeft, int flightNumber){
	
		this.whereTo = whereTo;
		this.whereFrom = whereFrom;
		this.price = price;
		this.time = time;
		this.date = date;
		this.duration = duration;
		this.numSeatsLeft = numSeatsLeft;
		this.flightNumber = flightNumber;
	}
	
	public Place getWhereTo() {
		return whereTo;
	}
	public void setWhereTo(Place whereTo) {
		this.whereTo = whereTo;
	}
	public Place getWhereFrom() {
		return whereFrom;
	}
	public void setWhereFrom(Place whereFrom) {
		this.whereFrom = whereFrom;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getNumSeatsLeft() {
		return numSeatsLeft;
	}
	public void setNumSeatsLeft(int numSeatsLeft) {
		this.numSeatsLeft = numSeatsLeft;
	}
	
	@Override     
	  public int compareTo(Flight flight) {          
		return (this.getPrice() < flight.getPrice() ? -1 : 
            (this.getPrice() == flight.getPrice() ? 0 : 1));  
	  }    

	
}
