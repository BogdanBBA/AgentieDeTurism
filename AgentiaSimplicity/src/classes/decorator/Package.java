package classes.decorator;

import java.util.ArrayList;
import java.util.List;

public class Package implements IPackage
{
	private EPackageType type;
	protected int price;

	public List<String> BasicPackageOfferBenefits;
	public List<String> AllInclusivePackageOfferBenefits;
	public List<String> UltraAllInclusivePackageOfferBenefits;
		
	public Package() 
	{
		this.type=EPackageType.Raw;
		BasicPackageOfferBenefits = new ArrayList<String>();
		AllInclusivePackageOfferBenefits = new ArrayList<String>();
		UltraAllInclusivePackageOfferBenefits = new ArrayList<String>();
	}

	public int getPrice()
	{
		return price;
	}

	public List<String> getBasicPackageOfferBenefits() 
	{
		return BasicPackageOfferBenefits;
	}

	public List<String> getAllInclusivePackageOfferBenefits() 
	{
		return AllInclusivePackageOfferBenefits;
	}

	public List<String> getUltraAllInclusivePackageOfferBenefits() 
	{
		return UltraAllInclusivePackageOfferBenefits;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public void setBasicPackageOfferBenefits(List<String> basicPackageOfferBenefits) 
	{
		BasicPackageOfferBenefits = basicPackageOfferBenefits;
	}



	public void setAllInclusivePackageOfferBenefits(List<String> allInclusivePackageOfferBenefits) 
	{
		AllInclusivePackageOfferBenefits = allInclusivePackageOfferBenefits;
	}



	public void setUltraAllInclusivePackageOfferBenefits(List<String> ultraAllInclusivePackageOfferBenefits) 
	{
		UltraAllInclusivePackageOfferBenefits = ultraAllInclusivePackageOfferBenefits;
	}



	@Override
	public EPackageType getType() 
	{
		return this.type;
	}

	@Override
	public void setType(EPackageType type) 
	{
		this.type=type;
	}

	@Override
	public void setBenefits(EBenefitsType type, String name, int price) 
	{
		List<String> benefits = null;

		switch (type)
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
		setPrice(getPrice() + price);
		
	}

	@Override
	public void Assemble() 
	{
		setPrice(20);	
	}

	@Override
	public List<String> Display() 
	{
		List<String> list=new ArrayList<>();
		if(BasicPackageOfferBenefits.size()>0)
		{
			list.add("\nBasic \n");
			for (int i = 0; i < BasicPackageOfferBenefits.size(); i++)
				list.add("\t" + BasicPackageOfferBenefits.get(i) + "\n");
		}
		
		if(AllInclusivePackageOfferBenefits.size()>0)
		{
			list.add("\nAll inclusive \n");
			for (int i = 0; i < AllInclusivePackageOfferBenefits.size(); i++)
				list.add("\t"+AllInclusivePackageOfferBenefits.get(i)+"\n");
		}
		
		if(UltraAllInclusivePackageOfferBenefits.size()>0)
		{
			list.add("\nUltra all inclusive \n");
			for (int i = 0; i < UltraAllInclusivePackageOfferBenefits.size(); i++)
				list.add("\t" + UltraAllInclusivePackageOfferBenefits.get(i)+"\n");
		}
		
		return list;
	}


}
