package classes.builder;

import classes.model.Hotel;
import classes.decorator.IPackageLevel;
import classes.model.ERoomType;

public interface IPackageOfferBuilder
{
	PackageOffer getPackageOffer();

	void setPackageLevel(IPackageLevel packageLevel);
	
	void setRoomType(ERoomType room);

	void setHotel(Hotel hotel);

	void setPrice(int price);

}
