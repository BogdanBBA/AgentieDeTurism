package classes.builder;

import classes.model.Hotel;
import classes.model.Rooms;

public class PackageOffer
{
	private Rooms room;
	private Hotel hotel;
	private int price;

	public Rooms getRoom()
	{
		return room;
	}

	public void setRoom(Rooms room)
	{
		this.room = room;
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
		return "PackageOffer [room=" + room + ", hotel=" + hotel + ", price=" + price + "]";
	}

}
