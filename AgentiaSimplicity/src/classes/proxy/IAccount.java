package classes.proxy;

import classes.User;

public interface IAccount 
{
	public boolean reserve(User user);
	public boolean makePayment(User user);
	public boolean login(User user);

}
