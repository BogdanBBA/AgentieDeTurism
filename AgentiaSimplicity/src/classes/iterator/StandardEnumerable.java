package classes.iterator;

import java.util.ArrayList;

import classes.AgencyResource;

public class StandardEnumerable implements IEnumerable
{
	private ArrayList<AgencyResource> items;

	@Override
	public IEnumerator getEnumerator(ArrayList<AgencyResource> resources)
	{
		this.items = resources;
		return new StandardEnumerator(this);
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
