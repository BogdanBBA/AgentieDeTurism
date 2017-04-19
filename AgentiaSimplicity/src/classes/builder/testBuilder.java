package classes.builder;

import classes.Utils;
import classes.decorator.AllInclusivePackageOfferDecorator;
import classes.decorator.BasicPackageOffer;
import classes.decorator.PackageOfferDecorator;
import classes.model.City;
import classes.model.Hotel;
import classes.strategy.TravelByPlane;
import classes.strategy.TravelContext;
import classes.model.ERoomType;

public class testBuilder
{
	public static void main(String[] args)
	{
		IPackageOfferBuilder builder = new PackageOfferBuilder();
		PackageOfferBuilderAgent agent = new PackageOfferBuilderAgent(builder);

		City city = new City(1, "Brasov, Romania");
		Hotel hotel = new Hotel(1,0, "Aro palace", city, 0.9);
		ERoomType room = ERoomType.SingleRoom;
		PackageOfferDecorator allInclusiveDecorator = new AllInclusivePackageOfferDecorator(new BasicPackageOffer());
		TravelContext travelContext = new TravelContext(new TravelByPlane());
		travelContext.executeStrategy();
		
		// de adaugat strategy
		agent.Construct(room, hotel, allInclusiveDecorator, travelContext);
		//agent.GetResult().getPackageLevel().Display();

		PackageOffer offer = agent.GetResult();
		

		int price = ((BasicPackageOffer) ((PackageOfferDecorator) offer.getPackageLevel()).getMyPackageOffer()).getPrice();
		System.out.println(price);

		
		Utils mt = new Utils();
		
		System.out.println(mt.calculatePrice(offer, 8));
		
		System.out.println(offer);

	}
}
