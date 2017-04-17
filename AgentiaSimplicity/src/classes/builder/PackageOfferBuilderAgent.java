package classes.builder;

import classes.model.Hotel;
import classes.model.Rooms;

public class PackageOfferBuilderAgent 
{
	private IPackageOfferBuilder _packageOfferBuilder;
	
	public PackageOfferBuilderAgent(IPackageOfferBuilder packageOfferBuilder)
	{
		this._packageOfferBuilder = packageOfferBuilder;
	}
	
	public void Construct(Rooms room, Hotel hotel, int price)
	{
		_packageOfferBuilder.setRoom(room);
		_packageOfferBuilder.setHotel(hotel);
		_packageOfferBuilder.setPrice(price);
	}
	
	public PackageOffer GetResult()
	{
		return _packageOfferBuilder.getPackageOffer();
	}
}
