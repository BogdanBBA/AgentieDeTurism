package classes.decorator;

import classes.Utils;

public class UltraAllInclusivePackageOfferDecorator extends AllInclusivePackageOfferDecorator
{

	public UltraAllInclusivePackageOfferDecorator(IPackageLevel level)
	{
		super(level);
		level.setType(EPackageType.UltraAllIncusive);
	}

	@Override
	public void Assemble()
	{
		super.Assemble();


		for(int i = 0; i< Utils.ULTRAALLINCLUSIVE.size(); i++)
			setBenefits(EBenefitsType.UltraAllInclusiveType, (String)Utils.ULTRAALLINCLUSIVE.get(i).getKey(), (Integer)Utils.ULTRAALLINCLUSIVE.get(i).getValue());	}

}
