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
		myResources.add(new AgencyResourceTestImplementation("ABC"));
		myResources.add(new AgencyResourceTestImplementation("123"));
		myResources.add(new AgencyResourceTestImplementation("Hello? This is the internet."));

		IEnumerator iterator = new StandardEnumerable().getEnumerator(myResources);
		
		while (iterator.moveNext())
			System.out.println(iterator.current());

		System.out.println(" * Done.");
	}
}
