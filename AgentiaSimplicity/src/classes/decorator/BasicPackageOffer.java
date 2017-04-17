package classes.decorator;

public class BasicPackageOffer implements IPackageLevel
{

	private EPackageType type;
	
	@Override
	public EPackageType GetType() 
	{
		return type;
	}

	@Override
	public void SetType() 
	{
		type = EPackageType.Basic;
	}

	@Override
	public void setBenefits(EBenefitsType type, String name, int price) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Assemble() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Display()
		  {
		// TODO Auto-generated method stub
		
	}
	
	
}
