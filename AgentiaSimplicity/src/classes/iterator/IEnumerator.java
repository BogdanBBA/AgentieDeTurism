package classes.iterator;

import classes.AgencyResource;

public interface IEnumerator
{
	AgencyResource current();
	boolean moveNext();
	void reset();
}
