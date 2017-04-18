package classes.iterator;

import classes.AgencyResource;

public interface IIterator
{
	AgencyResource current();

	boolean moveNext();

	void reset();
}
