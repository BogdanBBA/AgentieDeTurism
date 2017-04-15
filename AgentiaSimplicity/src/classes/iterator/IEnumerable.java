package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

public interface IEnumerable
{
	IEnumerator getEnumerator(ArrayList<AgencyResource> resources);
}
