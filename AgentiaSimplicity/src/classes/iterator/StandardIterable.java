package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

/**
 * Implements the {@code getIterator()} method that returns a {@link StandardIterator} to be used for iterating across {@link AgencyResource} objects.
 */
public class StandardIterable implements IIterable
{
	private ArrayList<? extends AgencyResource> items;

	/**
	 * Returns a {@link StandardIterator} to be used for iterating across {@link AgencyResource} objects.
	 */
	@Override
	public IIterator getIterator(ArrayList<? extends AgencyResource> resources)
	{
		this.items = resources;
		return new StandardIterator(this);
	}

	/**
	 * @return the total item count of the resource list
	 */
	public int count()
	{
		return this.items.size();
	}

	/**
	 * @return the item at the desired index position
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	public AgencyResource get(int index)
	{
		return this.items.get(index);
	}
}
