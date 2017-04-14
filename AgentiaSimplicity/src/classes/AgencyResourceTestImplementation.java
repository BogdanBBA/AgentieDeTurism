package classes;

public class AgencyResourceTestImplementation implements AgencyResource
{
	private String name;

	public AgencyResourceTestImplementation(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "TestResource[name=" + this.name + "]";
	}
}
