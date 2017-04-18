package classes.proxy;

import classes.model.User;

public class SafeProxyAccount implements IAccount
{
	private ProtectedAccount wrappedAccount;
	
	public SafeProxyAccount(User user)
	{
		if(checkUser(user))
		{
			wrappedAccount=new ProtectedAccount();
		}
		else
			wrappedAccount=null;
	}
	
	public boolean checkUser(User user)
	{
		if(user.getUsername().isEmpty() || user.getPassword().isEmpty() || user==null)
			return false;
		return true;
	}

	@Override
	public boolean reserve()
	{
		if(wrappedAccount!=null)
		{
			if(wrappedAccount.reserve())
				return true;
		}
		return false;
		
	}

	@Override
	public boolean makePayment(User user) 
	{
		if(wrappedAccount!=null)
		{
			if(wrappedAccount.makePayment(user))
				return true;
		}
		return false;
		
	}

	@Override
	public boolean login(User user)
	{
		if(wrappedAccount!=null)
		{
			if(wrappedAccount.login(user))
				return true;
			
		}
		return false;
		
	}

}
