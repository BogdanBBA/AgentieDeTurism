package classes.builder;

import classes.Hotel;
import classes.Rooms;

public interface IPackageOfferBuilder 
{
	PackageOffer getPackageOffer();
	void setRoom(Rooms room);
	void setHotel(Hotel hotel);
	void setPrice(int price);
	
}
