package classes.proxy;

import java.util.ArrayList;
import java.util.List;

import classes.builder.PackageOffer;
import classes.model.User;

public class SafeProxyAccount implements IAccount
{
	private ProtectedAccount wrappedAccount;

	public SafeProxyAccount(User user)
	{
		if (checkUser(user))
		{
			wrappedAccount = new ProtectedAccount();
		} else
			wrappedAccount = null;
	}

	public boolean checkUser(User user)
	{
		if (user.getUsername().isEmpty() || user.getPassword().isEmpty() || user == null)
			return false;
		return true;
	}

	@Override
	public List<String> reserve(PackageOffer offer,double finalPrice)
	{
		List<String> list=new ArrayList<>();
		if (wrappedAccount != null)
		{
			if (offer!=null && finalPrice>=0)
				list=wrappedAccount.reserve(offer,finalPrice);
		}
		return list;
	}

	@Override
	public boolean login(User user)
	{
		if (wrappedAccount != null)
		{
			if (wrappedAccount.login(user))
				return true;

		}
		return false;

	}

}
