package classes.builder;

import classes.decorator.AllInclusivePackageOfferDecorator;
import classes.decorator.BasicPackageOffer;
import classes.decorator.PackageOfferDecorator;
import classes.model.City;
import classes.model.Hotel;
import classes.model.ERoomType;

public class testBuilder
{
	public static void main(String[] args)
	{
		IPackageOfferBuilder builder = new PackageOfferBuilder();
		PackageOfferBuilderAgent agent = new PackageOfferBuilderAgent(builder);

		City city = new City(1, "Brasov, Romania");

		//creeazao lista cu camerele
		//adaugam in constructorul de hotel
		
		Hotel hotel = new Hotel(1, "Aro palace", city);
	
		
		
		ERoomType room = ERoomType.SingleRoom;
		
		PackageOfferDecorator allInclusiveDecorator = new AllInclusivePackageOfferDecorator(new BasicPackageOffer());
		
		agent.Construct(room, hotel, allInclusiveDecorator, 100);
	
		agent.GetResult().getPackageLevel().Display();
		
		
		//agent.Construct(room, hotel, DECORATOR);
		//ecoraotr
			
		//packageOfferClass oferta = new packageOfferClass(agent, decorator, )
		//type room
		//locatie
		//afisam pret

		PackageOffer ofer = agent.GetResult();

		System.out.println(ofer);

	}
}
