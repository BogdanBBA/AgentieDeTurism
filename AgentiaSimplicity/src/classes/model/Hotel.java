package classes.model;

import classes.AgencyResource;

public class Hotel implements AgencyResource
{
	private int id;
	private String name;
	private City city;

	public Hotel(int id, String name, City city)
	{
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public City getCity()
	{
		return city;
	}

	@Override
	public String toString()
	{
		return "Hotel [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
}
