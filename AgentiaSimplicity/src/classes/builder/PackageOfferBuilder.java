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
	public void setRoom(Rooms room) 
	{
		packageOffer.setRoom(room);
	}

	@Override
	public void setHotel(Hotel hotel) 
	{
		packageOffer.setHotel(hotel); 
	}

	@Override
	public void setPrice(int price)
	{
		packageOffer.setPrice(price); 
	} 

}
