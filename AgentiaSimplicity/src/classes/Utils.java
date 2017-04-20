package classes;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import classes.builder.PackageOffer;
import classes.decorator.PackageDecorator;
import classes.decorator.Package;

public class Utils {

	public static final List<AbstractMap.SimpleEntry> BASIC = new ArrayList<AbstractMap.SimpleEntry>();	
	public static final List<AbstractMap.SimpleEntry> ALLINCLUSIVE = new ArrayList<AbstractMap.SimpleEntry>();
	public static final List<AbstractMap.SimpleEntry> ULTRAALLINCLUSIVE = new ArrayList<AbstractMap.SimpleEntry>();
	
	
	static
	{
		BASIC.add(new AbstractMap.SimpleEntry<String, Integer>("Mic dejun inclus - bufet suedez.", 3));
		BASIC.add(new AbstractMap.SimpleEntry<String, Integer>("Bar - bauturi alcoolice si racoritoare din productie indigena(bere, vin alb/rosu, bauturi spirtoase)", 4));
	
		ALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Pranz inclus - buefet suedez.", 5));
		ALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Cina inclusa - buefet suedez.", 6));
		ALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Bar all inclusiv - bauturi si racoritoare din import.", 7));
		ALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Bar all inclusive - cafea si ceai intre orele 8:00-17:00.", 2));
		ALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Acces la piscina.", 10));
		
		ULTRAALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Bar all inclusive - cocktail-uri.", 5));
		ULTRAALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Gustari intre orele 15:00 - 17:00 (produse de patiserie si inghetata).", 2));
		ULTRAALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Snacks intre orele 10:00 - 23:00", 3));
		ULTRAALLINCLUSIVE.add(new AbstractMap.SimpleEntry<String, Integer>("Acces la sala de fitness.", 10));	
	}
	
	public double calculatePrice(PackageOffer offer, long nofDays)
	 {
		 double overallSum = 0;
		 int packageOfferPrice = ((Package) ((PackageDecorator) offer.getPackageLevel()).getMyPackage()).getPrice();
		 double hotelPriceModifier = offer.getHotel().getPriceModifier();
		 int travelContextPrice = offer.getTravelContext().getPrice();
		 
		 System.out.println("packageOffer = " + packageOfferPrice + ", hotelPriceModifier = " + hotelPriceModifier +",travel cost = " + travelContextPrice );
		 overallSum = (packageOfferPrice * hotelPriceModifier) * nofDays + travelContextPrice;
		 
		 return overallSum;
	 }

}
