

public class Flight {

	private Place whereTo;
	private Place whereFrom;
	private double price;
	private String time;
	private String date;
	private double duration;
	private String airline;
	private String flightNumber;
	private int numSeatsLeft;
	
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
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public int getNumSeatsLeft() {
		return numSeatsLeft;
	}
	public void setNumSeatsLeft(int numSeatsLeft) {
		this.numSeatsLeft = numSeatsLeft;
	}

	
}
