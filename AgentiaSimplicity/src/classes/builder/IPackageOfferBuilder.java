package classes.builder;

import classes.model.Hotel;
import classes.strategy.TravelContext;
import classes.decorator.PackageDecorator;
import classes.model.ERoomType;

public interface IPackageOfferBuilder
{
	PackageOffer getPackageOffer();

	void setPackageLevel(PackageDecorator packageDecorator);

	void setTravelContext(TravelContext travelContext);

	void setRoomType(ERoomType room);

	void setHotel(Hotel hotel);

}
