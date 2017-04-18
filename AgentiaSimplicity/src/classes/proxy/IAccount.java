package classes.proxy;

import classes.model.User;

public interface IAccount 
{
	public boolean reserve();
	public boolean makePayment(User user);
	public boolean login(User user);

}
