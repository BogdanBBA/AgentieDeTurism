package classes.proxy;

import classes.User;

public class SafeProxyAccount implements IAccount
{
	private ProtectedAccount wrappedAccount;
	
	public SafeProxyAccount(User u)
	{
		if(authenticate(u))
		{
			wrappedAccount=new ProtectedAccount(u);
		}
		else
			wrappedAccount=null;
	}
	
	public boolean authenticate(User u)
	{
		User us=new User("alina","12");
		if(u.equals(us))
			return true;
		
		return false;
	}

	@Override
	public boolean reserve(User u)
	{
		if(wrappedAccount!=null)
		{
			wrappedAccount.reserve(u);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean makePayment(User u) 
	{
		if(wrappedAccount!=null)
		{
			wrappedAccount.makePayment(u);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean login(User u) 
	{
		if(wrappedAccount!=null)
		{
			wrappedAccount.login(u);
			return true;
		}
		return false;
		
	}
	
	

}
