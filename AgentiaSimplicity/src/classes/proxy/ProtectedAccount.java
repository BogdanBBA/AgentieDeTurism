package classes.proxy;

import classes.model.User;
import classes.Database;

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
		for (User iUser : Database.getInstance().getUsers())
			if (user.equals(iUser))
			{
				isLoggedIn = true;
				return true;
			}
		return false;
	}
}
