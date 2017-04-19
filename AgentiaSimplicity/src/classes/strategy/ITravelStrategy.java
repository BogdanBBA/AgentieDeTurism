package classes.strategy;

import classes.model.ETravelType;

public interface ITravelStrategy
{
	int calculateTravelCost();

	ETravelType getType();
}
