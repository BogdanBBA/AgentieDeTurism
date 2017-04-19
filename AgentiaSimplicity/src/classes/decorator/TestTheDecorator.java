package classes.decorator;

public class TestTheDecorator
{

	public static void main(String[] args)
	{
		BasicPackageOffer basic = new BasicPackageOffer();
		basic.Assemble();
		basic.Display();

		PackageOfferDecorator allInclusiveDecorator = new AllInclusivePackageOfferDecorator(new BasicPackageOffer());
		allInclusiveDecorator.Assemble();
		allInclusiveDecorator.Display();

		PackageOfferDecorator ultraAllInclusiveDecorator = new UltraAllInclusivePackageOfferDecorator(new BasicPackageOffer());
		ultraAllInclusiveDecorator.Assemble();
		ultraAllInclusiveDecorator.Display();

		
		
		// DECORATOR

	}

}
