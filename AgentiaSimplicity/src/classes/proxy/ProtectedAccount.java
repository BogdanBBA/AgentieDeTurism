package classes.proxy;

import classes.model.User;
import classes.Database;
import classes.iterator.IIterator;
import classes.iterator.StandardIterable;

public class ProtectedAccount implements IAccount
{
	private User user;

	public ProtectedAccount()
	{
		
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public boolean reserve()
	{
		if (getUser() != null)
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
				setUser(user);
				return true;
			}
		return false;
	}
}
