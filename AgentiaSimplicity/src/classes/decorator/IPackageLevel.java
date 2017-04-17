package classes.decorator;

public interface IPackageLevel 
{
	EPackageType GetType();
	void SetType();
	
	void setBenefits(EBenefitsType type, String name, int price);
	void Assemble();
	void Display();
}
