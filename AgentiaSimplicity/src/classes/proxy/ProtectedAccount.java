package classes.proxy;

import classes.User;

public class ProtectedAccount implements IAccount
{
	private User user;
	
	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}	
	
	
	public ProtectedAccount(User user) 
	{
		this.setUser(user);
	}

	@Override
	public boolean reserve(User user) 
	{
		return true;	
	}

	@Override
	public boolean makePayment(User user) 
	{
		return true;
	}

	@Override
	public boolean login(User user)
	{
		return true;
	}
}
