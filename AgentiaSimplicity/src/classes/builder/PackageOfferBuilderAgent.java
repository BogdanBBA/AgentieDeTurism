package classes.builder;

import classes.model.Hotel;
import classes.decorator.IPackageLevel;
import classes.model.ERoomType;

public class PackageOfferBuilderAgent
{
	private IPackageOfferBuilder _packageOfferBuilder;

	public PackageOfferBuilderAgent(IPackageOfferBuilder packageOfferBuilder)
	{
		this._packageOfferBuilder = packageOfferBuilder;
	}

	public void Construct(ERoomType roomType, Hotel hotel, IPackageLevel packageLevel, int price)
	{
		_packageOfferBuilder.setPackageLevel(packageLevel);
		_packageOfferBuilder.setRoomType(roomType);
		_packageOfferBuilder.setHotel(hotel);
		_packageOfferBuilder.setPrice(price);
	}

	public PackageOffer GetResult()
	{
		return _packageOfferBuilder.getPackageOffer();
	}
}
