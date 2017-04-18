package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class TravelByPlane implements ITravelStrategy
{

	@Override
	public int calculateTravelCost() 
	{
		return  ThreadLocalRandom.current().nextInt(200,300);
	}

	@Override
	public String getType() 
	{
		return "Travel by plane.";
	}

}
