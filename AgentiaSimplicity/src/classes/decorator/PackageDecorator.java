package classes.decorator;

import java.util.List;

public abstract class PackageDecorator implements IPackage 
{
	public IPackage myPackage;
	public EPackageType type;
	
	public PackageDecorator(IPackage myPackage) 
	{
		this.myPackage = myPackage;
	}	
	
	public IPackage getMyPackage() 
	{
		return myPackage;
	}

	public void setMyPackage(IPackage myPackage) 
	{
		this.myPackage = myPackage;
	}
	
	@Override
	public EPackageType getType() 
	{
		return this.type;
	}

	@Override
	public void setType(EPackageType type) 
	{
		this.type=type;
	}

	@Override
	public void setBenefits(EBenefitsType type, String name, int price) 
	{
		myPackage.setBenefits(type, name, price);
	}

	@Override
	public void Assemble() 
	{
		myPackage.Assemble();
		
	}
	@Override
	public List<String> Display() 
	{
		return myPackage.Display();
		
	}
}
