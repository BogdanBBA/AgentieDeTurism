package classes.proxy;

import classes.User;

public class SafeProxyAccount implements IAccount
{
	private User user;
	private ProtectedAccount wrappedAccount;
	
	public SafeProxyAccount(User u)
	{
		if(Authenticate(u))
		{
			wrappedAccount=new ProtectedAccount();
		}
		else
			wrappedAccount=null;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User u) 
	{
		this.user = u;
	}
	
	public boolean Authenticate(User u)
	{
		User us=new User("alina","12");
		if(u.equals(us))
			return true;
		
		return false;
	}

	@Override
	public void reserve() 
	{
		System.out.println("ok");
		
	}

	@Override
	public void makePayment() 
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
