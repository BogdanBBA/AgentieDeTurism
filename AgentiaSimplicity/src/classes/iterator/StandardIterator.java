package classes.iterator;

import classes.AgencyResource;

/**
 * Provides a simple (ascending, consecutive) iterator to be used to iterate across {@link AgencyResource} objects.
 */
public class StandardIterator implements IIterator
{
	private final StandardIterable iterable;
	private int current;

	public StandardIterator(StandardIterable iterable)
	{
		this.iterable = iterable;
		this.reset();
	}

	@Override
	public AgencyResource current()
	{
		return (AgencyResource) this.iterable.get(this.current);
	}

	@Override
	public boolean moveNext()
	{
		return ++this.current < this.iterable.count();
	}

	@Override
	public void reset()
	{
		this.current = -1;
	}
}
