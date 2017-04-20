package classes.builder;

import classes.model.Hotel;
import classes.strategy.TravelContext;
import classes.decorator.PackageDecorator;
import classes.model.ERoomType;

public class PackageOfferBuilderAgent
{
	private IPackageOfferBuilder packageOfferBuilder;

	public PackageOfferBuilderAgent(IPackageOfferBuilder packageOfferBuilder)
	{
		this.packageOfferBuilder = packageOfferBuilder;
	}

	public void Construct(ERoomType roomType, Hotel hotel, PackageDecorator packageDecorator, TravelContext travelContext)
	{
		packageOfferBuilder.setPackageLevel(packageDecorator);
		packageOfferBuilder.setTravelContext(travelContext);
		packageOfferBuilder.setRoomType(roomType);
		packageOfferBuilder.setHotel(hotel);
	}

	public PackageOffer GetResult()
	{
		return packageOfferBuilder.getPackageOffer();
	}
}
