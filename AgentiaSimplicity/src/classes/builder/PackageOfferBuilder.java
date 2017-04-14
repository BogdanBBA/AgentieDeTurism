package classes.builder;

import classes.Hotel;
import classes.Rooms;

public class PackageOfferBuilder implements IPackageOfferBuilder
{

	PackageOffer packageOffer = new PackageOffer();

	@Override
	public PackageOffer getPackageOffer() 
	{
		return this.packageOffer;
	}

	@Override
	public void SetRoom(Rooms room) 
	{
		packageOffer.room = room;
	}

	@Override
	public void SetHotel(Hotel hotel) 
	{
		packageOffer.hotel = hotel;
	}

	@Override
	public void SetPrice(int price)
	{
		packageOffer.price = price;
	} 

}
