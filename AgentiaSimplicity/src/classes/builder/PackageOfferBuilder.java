package classes.builder;

import classes.model.Hotel;
import classes.strategy.TravelContext;
import classes.decorator.PackageDecorator;
import classes.model.ERoomType;

public class PackageOfferBuilder implements IPackageOfferBuilder
{
	PackageOffer packageOffer = new PackageOffer();

	@Override
	public PackageOffer getPackageOffer()
	{
		return this.packageOffer;
	}

	@Override
	public void setRoomType(ERoomType roomType)
	{
		packageOffer.setRoom(roomType);
	}

	@Override
	public void setHotel(Hotel hotel)
	{
		packageOffer.setHotel(hotel);
	}

	@Override
	public void setPackageLevel(PackageDecorator packageDecorator)
	{
		packageOffer.setPackageLevel(packageDecorator);
	}

	@Override
	public void setTravelContext(TravelContext travelContext)
	{
		packageOffer.setTravelContext(travelContext);
	}
}
