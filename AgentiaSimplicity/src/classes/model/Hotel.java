package classes.model;

import classes.AgencyResource;

public class Hotel implements AgencyResource
{
	public int id;
	public String name;
	public City city;

	@Override
	public String toString()
	{
		return "Hotel [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

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

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public City getCity()
	{
		return city;
	}

	public void setCity(City city)
	{
		this.city = city;
	}

}
