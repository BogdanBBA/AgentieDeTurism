package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

import classes.model.ETravelType;

public class TravelByBus implements ITravelStrategy
{

	@Override
	public int calculateTravelCost()
	{
		return ThreadLocalRandom.current().nextInt(100, 200);
	}

	@Override
	public ETravelType getType()
	{
		return ETravelType.Bus;
	}

}
