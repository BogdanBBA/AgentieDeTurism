package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

/**
 * Provides the definition for the {@code getIterator()} method that should return a {@link IIterator} implementation for the desired iteration type across {@link AgencyResource} objects.
 */
public interface IIterable
{
	/**
	 * Should return a {@link IIterator} implementation for the desired iteration type across {@link AgencyResource} objects.
	 * 
	 * @param resources
	 *            the list of concrete implementations of agency resources
	 * @return a {@link IIterator} implementation
	 */
	IIterator getIterator(ArrayList<? extends AgencyResource> resources);
}
