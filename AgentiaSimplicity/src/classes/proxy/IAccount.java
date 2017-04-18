package classes.proxy;

import classes.model.User;

public interface IAccount
{
	public boolean reserve(User user);

	public boolean makePayment(User user);

	public boolean login(User user);

}
