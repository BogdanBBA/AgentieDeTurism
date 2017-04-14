package classes.builder;

import classes.Hotel;
import classes.Rooms;

public class PackageOffer 
{
	public Rooms room;
	public Hotel hotel;
	public int price;
	@Override
	public String toString() {
		return "PackageOffer [room=" + room + ", hotel=" + hotel + ", price=" + price + "]";
	}
	
	
	
	
}