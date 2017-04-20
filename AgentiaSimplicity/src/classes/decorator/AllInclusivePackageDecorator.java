package classes.decorator;

import classes.Utils;

public class AllInclusivePackageDecorator extends BasicPackageDecorator
{
	public AllInclusivePackageDecorator(IPackage myPackage) 
	{
		super(myPackage);
		super.setType(EPackageType.AllInclusive);
	}
	
	@Override
	public void Assemble()
	{
		super.Assemble();
		
		for(int i = 0; i< Utils.ALLINCLUSIVE.size(); i++)
			setBenefits(EBenefitsType.AllInclusiveType, (String)Utils.ALLINCLUSIVE.get(i).getKey(), (Integer)Utils.ALLINCLUSIVE.get(i).getValue());
	}

}
