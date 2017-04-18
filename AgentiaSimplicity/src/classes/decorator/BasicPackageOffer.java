package classes.decorator;

public class BasicPackageOffer implements IPackageLevel
{
	private EPackageType type;

	@Override
	public EPackageType getType()
	{
		return type;
	}

	@Override
	public void setType()
	{
		type = EPackageType.Basic;
	}

	@Override
	public void setBenefits(EBenefitsType type, String name, int price)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void assemble()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub

	}
}
