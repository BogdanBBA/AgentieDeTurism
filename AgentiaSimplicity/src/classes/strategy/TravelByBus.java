package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class TravelByBus implements ITravelStrategy
{

	@Override
	public int calculateTravelCost() 
	{
		return ThreadLocalRandom.current().nextInt(100,200);
	}

	@Override
	public String getType() 
	{
		return "Travel by bus.";
	}
	
}
