package classes.decorator;

public interface IPackageLevel 
{
	EPackageType GetType();
	void SetType(EPackageType type);
	
	void setBenefits(EBenefitsType type, String name, int price);
	void Assemble();
	void Display();
}
