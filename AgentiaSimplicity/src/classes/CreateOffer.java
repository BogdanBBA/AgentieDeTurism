package classes;

import classes.builder.IPackageOfferBuilder;
import classes.builder.PackageOffer;
import classes.builder.PackageOfferBuilder;
import classes.builder.PackageOfferBuilderAgent;
import classes.decorator.AllInclusivePackageDecorator;
import classes.decorator.BasicPackageDecorator;
import classes.decorator.Package;
import classes.decorator.PackageDecorator;
import classes.decorator.UltraAllInclusivePackageDecorator;
import classes.model.ERoomType;
import classes.model.ETravelType;
import classes.model.Hotel;
import classes.strategy.TravelByBus;
import classes.strategy.TravelByPlane;
import classes.strategy.TravelByTrain;
import classes.strategy.TravelContext;
import classes.strategy.TravelNotIncluded;

public class CreateOffer 
{
	public TravelContext getTravelContext(ETravelType travellingType)
	{
		TravelContext travelContext = null;
		
		switch(travellingType)
		{
			case NotIncluded:
				travelContext = new TravelContext(new TravelNotIncluded());
				break;
			case Bus:
				travelContext = new TravelContext(new TravelByBus());
				break;
			case Plane:
				travelContext = new TravelContext(new TravelByPlane());
				break;
			case Train:
				travelContext = new TravelContext(new TravelByTrain());
				break;				
		}
		return travelContext;
	}
	
	public PackageDecorator getPackageDecorator(String chosenFacility)
	{
		PackageDecorator decorator=null;
		
		switch(chosenFacility)
		{
		case "Basic":
			decorator = new BasicPackageDecorator(new Package());
			break;
		case "All inclusive":
			decorator = new AllInclusivePackageDecorator(new Package());
			break;
		case "Ultra all inclusive":
			decorator = new UltraAllInclusivePackageDecorator(new Package());
			break;
		default:
			break;
		}
		
		return decorator;
	}
	
	public PackageOffer createOffer(ETravelType travellingType,String chosenFacility,Hotel hotel,ERoomType chosenRoom)
	{
		PackageOffer offer=null;
		IPackageOfferBuilder builder = new PackageOfferBuilder();
		PackageOfferBuilderAgent agent = new PackageOfferBuilderAgent(builder);
		
		TravelContext travelContext=getTravelContext(travellingType);
		travelContext.executeStrategy();
		
		PackageDecorator decorator=getPackageDecorator(chosenFacility);
		
		agent.Construct(chosenRoom, hotel, decorator, travelContext);
		
		offer = agent.GetResult();
		
		
		return offer;
	}
	
	
}
