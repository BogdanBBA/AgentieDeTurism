package classes.strategy;

import classes.model.ETravelType;

public class TravelNotIncluded implements ITravelStrategy
{

	@Override
	public int calculateTravelCost()
	{
		return 0;
	}

	@Override
	public ETravelType getType()
	{
		return ETravelType.NotIncluded;
	}

}
