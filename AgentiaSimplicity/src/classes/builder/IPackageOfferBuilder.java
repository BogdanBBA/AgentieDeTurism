package classes.builder;

import classes.model.Hotel;
import classes.model.ERoomType;

public interface IPackageOfferBuilder
{
	PackageOffer getPackageOffer();

	void setRoomType(ERoomType room);

	void setHotel(Hotel hotel);

	void setPrice(int price);

}
