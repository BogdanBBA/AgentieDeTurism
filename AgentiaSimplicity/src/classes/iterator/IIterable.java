package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

public interface IIterable
{
	IIterator getIterator(ArrayList<AgencyResource> resources);
}
