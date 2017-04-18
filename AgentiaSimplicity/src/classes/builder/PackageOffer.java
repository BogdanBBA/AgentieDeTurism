package classes.builder;

import classes.model.Hotel;
import classes.model.ERoomType;

public class PackageOffer
{
	private ERoomType roomType;
	private Hotel hotel;
	private int price;

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

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	@Override
	public String toString()
	{
		return "PackageOffer [room=" + roomType + ", hotel=" + hotel + ", price=" + price + "]";
	}

}
