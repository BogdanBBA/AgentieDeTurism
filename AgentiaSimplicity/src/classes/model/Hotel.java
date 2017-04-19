package classes.model;

import classes.AgencyResource;

public class Hotel implements AgencyResource
{
	private int id;
	private String name;
	private City city;
	private double priceModifier;
	
	public Hotel(int id, String name, City city, double priceModifier)
	{
		this.id = id;
		this.name = name;
		this.city = city;
		this.priceModifier = priceModifier;
	}

	public double getPriceModifier()
	{
		return priceModifier;
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
		return "Hotel [id=" + id + ", name=" + name + ", city=" + city + ",priceModifier =" + priceModifier+"]";
	}
}
