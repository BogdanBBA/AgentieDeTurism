package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

public class StandardIterable implements IIterable
{
	private ArrayList<AgencyResource> items;

	@Override
	public IIterator getIterator(ArrayList<AgencyResource> resources)
	{
		this.items = resources;
		return new StandardIterator(this);
	}

	public int count()
	{
		return this.items.size();
	}

	public AgencyResource get(int index)
	{
		return this.items.get(index);
	}

	public void set(int index, AgencyResource item)
	{
		this.items.set(index, item);
	}
}
