package classes.decorator;

import javafx.scene.control.TextArea;

public abstract class PackageOfferDecorator implements IPackageLevel
{

	public IPackageLevel myPackageOffer;
	public EPackageType type;


	public PackageOfferDecorator(IPackageLevel level)
	{
		this.myPackageOffer = level;

	}

	
	public IPackageLevel getMyPackageOffer()
	{
		return this.myPackageOffer;
	}

	public void setMyPackageOffer(IPackageLevel myPackageOffer)
	{
		this.myPackageOffer = myPackageOffer;
	}

	@Override
	public void setType(EPackageType type)
	{
		this.type = type;
	}

	@Override
	public EPackageType getType()
	{
		return this.type;
	}

	@Override
	public void setBenefits(EBenefitsType type, String name, int price)
	{
		myPackageOffer.setBenefits(type, name, price);
	}
	
	@Override
	public void Assemble()
	{
		myPackageOffer.Assemble();
	}

	@Override
	public void Display(TextArea detailsText)
	{
		myPackageOffer.Display(detailsText);
	}

}
