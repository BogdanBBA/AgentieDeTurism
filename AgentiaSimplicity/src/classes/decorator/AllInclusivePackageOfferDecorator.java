package classes.decorator;

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

		setBenefits(EBenefitsType.AllInclusiveType, "Pranz inclus - buefet suedez.", 100);
		setBenefits(EBenefitsType.AllInclusiveType, "Cina inclusa - buefet suedez.", 100);
		setBenefits(EBenefitsType.AllInclusiveType, "Bar all inclusiv - bauturi si racoritoare din import.", 100);
		setBenefits(EBenefitsType.AllInclusiveType, "Bar all inclusive - cafea si ceai intre orele 8:00-17:00.", 100);
		setBenefits(EBenefitsType.AllInclusiveType, "Acces la piscina.", 100);
	}

}
