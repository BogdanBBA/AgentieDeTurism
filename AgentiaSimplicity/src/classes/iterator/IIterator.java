package classes.iterator;

import classes.AgencyResource;

/**
 * Provides the emthod definitions for any app-specific iterator implementation.
 */
public interface IIterator
{
	/**
	 * @return the item at the current index position (depends on the specific iterator implementation)
	 */
	AgencyResource current();

	/**
	 * @return {@code true} if, after increasing the current index position (depends on the specific iterator implementation) an item exists at that position, or {@code false} otherwise
	 */
	boolean moveNext();

	/**
	 * Resets the index position of the interator (depends on the specific iterator implementation).
	 */
	void reset();
}
