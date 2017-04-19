package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class TravelByTrain implements ITravelStrategy
{

	@Override
	public int calculateTravelCost()
	{
		return ThreadLocalRandom.current().nextInt(80, 130);
	}

	@Override
	public String getType()
	{
		return "Travel by train.";
	}

}
