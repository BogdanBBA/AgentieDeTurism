package classes.proxy;

import classes.model.User;

public interface IAccount
{
	public boolean reserve();

	public boolean login(User user);

}
