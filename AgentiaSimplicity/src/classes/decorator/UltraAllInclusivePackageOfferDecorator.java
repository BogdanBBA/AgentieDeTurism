package classes.decorator;

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

		setBenefits(EBenefitsType.UltraAllInclusiveType, "Bar all inclusive - cocktail-uri.", 5);
		setBenefits(EBenefitsType.UltraAllInclusiveType, "Gustari intre orele 15:00 - 17:00 (produse de patiserie si inghetata).", 2);
		setBenefits(EBenefitsType.UltraAllInclusiveType, "Snacks intre orele 10:00 - 23:00", 3);
		setBenefits(EBenefitsType.UltraAllInclusiveType, "Acces la sala de fitness.", 10);
	}

}
