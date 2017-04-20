package classes.decorator;

import classes.Utils;

public class BasicPackageDecorator extends PackageDecorator
{

	public BasicPackageDecorator(IPackage myPackage) 
	{
		super(myPackage);
		super.setType(EPackageType.Basic);
	}
	
	@Override
	public void Assemble()
	{
		super.Assemble();
		
		for(int i = 0; i< Utils.BASIC.size(); i++)
			setBenefits(EBenefitsType.BasicType, (String)Utils.BASIC.get(i).getKey(), (Integer)Utils.BASIC.get(i).getValue());
	}
	

}
