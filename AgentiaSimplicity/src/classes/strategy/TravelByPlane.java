package classes.strategy;

import java.util.concurrent.ThreadLocalRandom;

import classes.model.ETravelType;

public class TravelByPlane implements ITravelStrategy
{

	@Override
	public int calculateTravelCost()
	{
		return ThreadLocalRandom.current().nextInt(200, 300);
	}

	@Override
	public ETravelType getType()
	{
		return ETravelType.Plane;
	}

}
