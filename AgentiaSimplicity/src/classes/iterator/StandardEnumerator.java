package classes.iterator;

import classes.AgencyResource;

public class StandardEnumerator implements IEnumerator
{
	private final StandardEnumerable enumerable;
	private int current;

	public StandardEnumerator(StandardEnumerable enumerable)
	{
		this.enumerable = enumerable;
		this.reset();
	}

	@Override
	public AgencyResource current()
	{
		return (AgencyResource) this.enumerable.get(this.current);
	}

	@Override
	public boolean moveNext()
	{
		return ++this.current < this.enumerable.count();
	}

	@Override
	public void reset()
	{
		this.current = -1;
	}
}
