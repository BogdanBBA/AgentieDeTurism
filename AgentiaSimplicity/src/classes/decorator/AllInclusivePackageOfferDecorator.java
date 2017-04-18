package classes.decorator;

public class AllInclusivePackageOfferDecorator extends PackageOfferDecorator 
{

	public AllInclusivePackageOfferDecorator(IPackageLevel typeLevel) 
	{
		super(typeLevel);
	
		typeLevel.setType(EPackageType.AllInclusive);
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
		
		setBenefits(EBenefitsType.AllInclusiveType, "bautura moca 24/24", 200);
	}
	

}
