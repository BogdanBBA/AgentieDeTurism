package classes;

import java.util.ArrayList;

import org.junit.Test;

import classes.iterator.IEnumerator;
import classes.iterator.StandardEnumerable;

public class IteratorTests
{
	@Test
	public void iteratorTest1() // not really a unit test, just prints out stuff
	{
		ArrayList<AgencyResource> myResources = new ArrayList<>();
		myResources.add(new City(1, "ABC"));
		myResources.add(new City(2, "123"));
		myResources.add(new Hotel(10, "Hello? This is the internet.", new City(0, "temp")));

		IEnumerator iterator = new StandardEnumerable().getEnumerator(myResources);

		while (iterator.moveNext())
			System.out.println(iterator.current());

		System.out.println(" * Done.");
	}
}
