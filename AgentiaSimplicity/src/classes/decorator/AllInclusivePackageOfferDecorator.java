package classes.decorator;

import classes.Utils;

public class AllInclusivePackageOfferDecorator extends PackageOfferDecorator
{

	public AllInclusivePackageOfferDecorator(IPackageLevel typeLevel)
	{
		super(typeLevel);
		// Apelam constructorul care nu trebuia
		// typeLevel.setType(EPackageType.AllInclusive);
		setType(EPackageType.AllInclusive);
		
	}

	@Override
	public void setType(EPackageType type)
	{
		super.setType(type);
	}
	
	@Override
	public void Assemble()
	{
		super.Assemble();
		
		for(int i = 0; i< Utils.ALLINCLUSIVE.size(); i++)
			setBenefits(EBenefitsType.AllInclusiveType, (String)Utils.ALLINCLUSIVE.get(i).getKey(), (Integer)Utils.ALLINCLUSIVE.get(i).getValue());
	}

}
