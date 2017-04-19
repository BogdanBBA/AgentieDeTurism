package classes.strategy;

public class Main
{

	public static void main(String[] args)
	{
		TravelContext context = new TravelContext(new TravelByPlane());
		System.out.println(context.executeStrategy());
	}

}
