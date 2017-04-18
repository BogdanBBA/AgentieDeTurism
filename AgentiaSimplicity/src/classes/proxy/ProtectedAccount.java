package classes.proxy;

import classes.model.User;
import classes.model.User;
import classes.Database;
import classes.iterator.IIterator;
import classes.iterator.StandardIterable;

public class ProtectedAccount implements IAccount
{
	private boolean isLoggedIn;
	private User user;
	
	
	public ProtectedAccount()
	{
		isLoggedIn=false;
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
		if(getUser()!=null)
			return true;
		return false;
	}

	@Override
	public boolean makePayment(User user) 
	{
		if(isLoggedIn)
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
