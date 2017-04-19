package classes.strategy;

import classes.model.ETravelType;

public class TravelContext
{
	private ITravelStrategy strategy;
	private int price;

	public TravelContext(ITravelStrategy strategy)
	{
		this.strategy = strategy;
	}
	
	public int getPrice() 
	{
		return this.price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public int executeStrategy()
	{
		setPrice(strategy.calculateTravelCost());
		return getPrice();
	}

	public ETravelType getType()
	{
		return this.strategy.getType();
	}
}
