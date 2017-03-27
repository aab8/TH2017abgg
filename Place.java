

public class Place {
private String name;
//private Attraction attractionType;
//private double popularityRating;
private String country;
private String continent;
private String avgTemp;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getContinent() {
	return continent;
}
public void setContinent(String continent) {
	this.continent = continent;
}
public String getAvgTemp() {
	return avgTemp;
}
public void setAvgTemp(String avgTemp) {
	this.avgTemp = avgTemp;
}

public boolean equals(Place place) {
	if ( this.name.equals( place.getName() ) ) {
		return true;
	}
	else return false;
}

}
