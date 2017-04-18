package classes.decorator;

import java.util.ArrayList;
import java.util.List;

public class BasicPackageOffer implements IPackageLevel
{

	private EPackageType typeLevel;
	private int price;
	
	public List<String> BasicPackageOfferBenefits;
	public List<String> AllInclusivePackageOfferBenefits;
	public List<String> UltraAllInclusivePackageOfferBenefits;

	
	@Override
	public EPackageType getType() 
	{
		return this.typeLevel;
	}

	
	@Override
	public void setType(EPackageType typeLevel) 
	{
		this.typeLevel = typeLevel;
	}
	
	public int getPrice() 
	{
		return this.price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public List<String> getBasicPackageOfferBenefits() 
	{
		return BasicPackageOfferBenefits;
	}

	public void setBasicPackageOfferBenefits(List<String> basicPackageOfferBenefits) 
	{
		BasicPackageOfferBenefits = new ArrayList<>(basicPackageOfferBenefits);
	}

	public List<String> getAllInclusivePackageOfferBenefits() 
	{
		return AllInclusivePackageOfferBenefits;
	}

	public void setAllInclusivePackageOfferBenefits(List<String> allInclusivePackageOfferBenefits) 
	{
		AllInclusivePackageOfferBenefits = new ArrayList<>(allInclusivePackageOfferBenefits);
	}

	public List<String> getUltraAllInclusivePackageOfferBenefits() 
	{
		return UltraAllInclusivePackageOfferBenefits;
	}

	public void setUltraAllInclusivePackageOfferBenefits(List<String> ultraAllInclusivePackageOfferBenefits) 
	{
		UltraAllInclusivePackageOfferBenefits = new ArrayList<>(ultraAllInclusivePackageOfferBenefits);
	}

	public BasicPackageOffer() 
	{
		this.typeLevel = EPackageType.Basic;
		
		BasicPackageOfferBenefits = new ArrayList<String>();
		AllInclusivePackageOfferBenefits = new ArrayList<String>();
		UltraAllInclusivePackageOfferBenefits = new ArrayList<String>();
	}
	
	@Override
	public void setBenefits(EBenefitsType type, String name, int price) 
	{
		List<String> benefits = null ;
		
		switch(type)
		{
			case BasicType:
				benefits = BasicPackageOfferBenefits;
				break;
			case AllInclusiveType:
				benefits = AllInclusivePackageOfferBenefits;
				break;
			case UltraAllInclusiveType:
				benefits = UltraAllInclusivePackageOfferBenefits;
				break;
			default:
				break;
		}
		benefits.add(name);
		setPrice(getPrice()+price);
		
	}

	@Override
	public void Assemble() 
	{
		BasicPackageOfferBenefits.add("mic dejun inclus");
		price = 1000;
	}

	@Override
	public void Display()
	{
		System.out.println();
		
		System.out.println("Price");
		System.out.println(price);
		
		System.out.println("----Basic----");
		for(int i = 0; i < BasicPackageOfferBenefits.size(); i++)
			System.out.println(BasicPackageOfferBenefits.get(i));
		
		System.out.println("----AllInclusive----");
		for(int i = 0; i < AllInclusivePackageOfferBenefits.size(); i++)
			System.out.println(AllInclusivePackageOfferBenefits.get(i));
		
		System.out.println("----UltraAllInclusive----");
		for(int i = 0; i <UltraAllInclusivePackageOfferBenefits.size(); i++)
			System.out.println(UltraAllInclusivePackageOfferBenefits.get(i));
		
		System.out.println("\n");
	}
	
	
}