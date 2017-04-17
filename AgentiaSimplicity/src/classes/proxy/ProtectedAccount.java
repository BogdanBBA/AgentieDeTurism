package classes.proxy;

import classes.model.User;

public class ProtectedAccount implements IAccount
{
	private boolean isLoggedIn;
	
	public ProtectedAccount()
	{
		isLoggedIn=false;
	}

	@Override
	public boolean reserve(User user) 
	{
		if(isLoggedIn)
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
		User u=new User("alina","12");
		if(user.equals(u))
		{
			isLoggedIn=true;
			return true;
		}
		return false;
	}
}
