package classes.builder;

import classes.Hotel;
import classes.Rooms;

public interface IPackageOfferBuilder 
{
	PackageOffer getPackageOffer();
	void SetRoom(Rooms room);
	void SetHotel(Hotel hotel);
	void SetPrice(int price);
	
}