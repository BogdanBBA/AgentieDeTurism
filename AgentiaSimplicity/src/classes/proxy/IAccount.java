package classes.proxy;

import java.util.List;

import classes.builder.PackageOffer;
import classes.model.User;

public interface IAccount
{
	public List<String> reserve(PackageOffer offer,double finalPrice);

	public boolean login(User user);

}
