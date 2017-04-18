package classes.builder;

import classes.model.Hotel;
import classes.model.ERoomType;

public class PackageOfferBuilderAgent
{
	private IPackageOfferBuilder _packageOfferBuilder;

	public PackageOfferBuilderAgent(IPackageOfferBuilder packageOfferBuilder)
	{
		this._packageOfferBuilder = packageOfferBuilder;
	}

	public void Construct(ERoomType roomType, Hotel hotel, int price)
	{
		_packageOfferBuilder.setRoomType(roomType);
		_packageOfferBuilder.setHotel(hotel);
		_packageOfferBuilder.setPrice(price);
	}

	public PackageOffer GetResult()
	{
		return _packageOfferBuilder.getPackageOffer();
	}
}
