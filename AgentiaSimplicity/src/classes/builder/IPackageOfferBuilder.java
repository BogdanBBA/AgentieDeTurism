package classes.builder;

import classes.model.Hotel;
import classes.model.Rooms;

public interface IPackageOfferBuilder 
{
	PackageOffer getPackageOffer();
	void setRoom(Rooms room);
	void setHotel(Hotel hotel);
	void setPrice(int price);
	
}
