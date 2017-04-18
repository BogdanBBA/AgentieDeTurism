package classes.decorator;

public class AllInclusivePackageOfferDecorator extends PackageOfferDecorator 
{

	public AllInclusivePackageOfferDecorator(IPackageLevel level) 
	{
		super(level);
		level.SetType(EPackageType.AllInclusive);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SetType(EPackageType type) 
	{
		// TODO Auto-generated method stub
	}
	
	@Override
	public void Assemble()
	{
		super.Assemble();
		
		setBenefits(EBenefitsType.AllInclusiveType, "bautura moca 24/24", 200);
	}
	

}
