package classes.decorator;

import classes.Utils;

public class UltraAllInclusivePackageDecorator extends AllInclusivePackageDecorator
{

	public UltraAllInclusivePackageDecorator(IPackage myPackage) 
	{
		super(myPackage);
		super.setType(EPackageType.AllInclusive);
	}
	
	@Override
	public void Assemble()
	{
		super.Assemble();
		
		for(int i = 0; i< Utils.ULTRAALLINCLUSIVE.size(); i++)
			setBenefits(EBenefitsType.UltraAllInclusiveType, (String)Utils.ULTRAALLINCLUSIVE.get(i).getKey(), (Integer)Utils.ULTRAALLINCLUSIVE.get(i).getValue());
	}

}
