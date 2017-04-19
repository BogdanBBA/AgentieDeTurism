package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

import classes.model.ETravelType;

public class TravelByTrain implements ITravelStrategy
{

	@Override
	public int calculateTravelCost()
	{
		return ThreadLocalRandom.current().nextInt(80, 130);
	}

	@Override
	public ETravelType getType()
	{
		return ETravelType.Train;
	}

}
