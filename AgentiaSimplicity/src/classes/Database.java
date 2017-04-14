package classes;

import java.util.ArrayList;

public class Database
{
	private final ArrayList<User> users;
	private final ArrayList<City> cities;
	private final ArrayList<Hotel> hotels;

	private Database()
	{
		this.users = new ArrayList<>();
		this.cities = new ArrayList<>();
		this.hotels = new ArrayList<>();
	}

	public ArrayList<User> getUsers()
	{
		return users;
	}

	public ArrayList<City> getCities()
	{
		return cities;
	}

	public ArrayList<Hotel> getHotels()
	{
		return hotels;
	}
}
