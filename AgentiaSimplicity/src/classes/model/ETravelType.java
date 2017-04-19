package classes.model;

public enum ETravelType
{
	NotIncluded(0), Plane(1), Bus(2),Train(3);
	
	private int value;
	
	ETravelType(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
