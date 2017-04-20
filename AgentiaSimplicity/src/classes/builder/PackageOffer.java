package classes.builder;

import classes.model.Hotel;
import classes.strategy.TravelContext;
import classes.decorator.PackageDecorator;
import classes.model.ERoomType;

public class PackageOffer
{
	private ERoomType roomType;
	private Hotel hotel;
	private PackageDecorator packageDecorator;
	private TravelContext travelContext;

	public TravelContext getTravelContext()
	{
		return this.travelContext;
	}

	public void setTravelContext(TravelContext travelContext)
	{
		this.travelContext = travelContext;
	}

	public PackageDecorator getPackageLevel()
	{
		return packageDecorator;
	}

	public void setPackageLevel(PackageDecorator packageDecorator)
	{
		this.packageDecorator = packageDecorator;
		this.packageDecorator.Assemble();
	}

	public ERoomType getRoom()
	{
		return roomType;
	}

	public void setRoom(ERoomType roomType)
	{
		this.roomType = roomType;
	}

	public Hotel getHotel()
	{
		return hotel;
	}

	public void setHotel(Hotel hotel)
	{
		this.hotel = hotel;
	}

	@Override
	public String toString()
	{
		return "PackageOffer [roomType=" + roomType + ", hotel=" + hotel + ", packageLevel=" + packageDecorator.getType() + ", travelContext=" + travelContext.getType() + ",Travel price =" + travelContext.getPrice()+ "]";
	}

}
