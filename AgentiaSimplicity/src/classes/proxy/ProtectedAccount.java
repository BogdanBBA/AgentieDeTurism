package classes.proxy;

import classes.model.User;
import classes.Database;
import classes.iterator.IIterator;
import classes.iterator.StandardIterable;

public class ProtectedAccount implements IAccount
{
	private boolean isLoggedIn;

	public ProtectedAccount()
	{
		isLoggedIn = false;
	}

	@Override
	public boolean reserve(User user)
	{
		if (isLoggedIn)
			return true;
		return false;
	}

	@Override
	public boolean makePayment(User user)
	{
		if (isLoggedIn)
			return true;
		return false;
	}

	@Override
	public boolean login(User user)
	{
		IIterator iterator = new StandardIterable().getIterator(Database.getInstance().getUsers());
		while (iterator.moveNext())
			if (user.equals(iterator.current()))
			{
				isLoggedIn = true;
				return true;
			}
		return false;
	}
}
