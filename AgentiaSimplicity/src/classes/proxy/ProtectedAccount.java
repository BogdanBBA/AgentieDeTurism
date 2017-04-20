package classes.proxy;

import classes.model.User;
import java.util.List;
import classes.Database;
import classes.builder.PackageOffer;
import classes.iterator.IIterator;
import classes.iterator.StandardIterable;

public class ProtectedAccount implements IAccount
{

	public ProtectedAccount()
	{
		
	}

	@Override
	public List<String> reserve(PackageOffer offer,double finalPrice)
	{
		List<String> list=offer.getPackageLevel().Display();
		list.add("\n\n\nTotal cost:   "+finalPrice);
		return list;
	}

	@Override
	public boolean login(User user)
	{
		IIterator iterator = new StandardIterable().getIterator(Database.getInstance().getUsers());
		while (iterator.moveNext())
			if (user.equals(iterator.current()))
			{
				return true;
			}
		return false;
	}
}
