package classes.decorator;

public interface IPackageLevel
{
	EPackageType getType();

	void setType();

	void setBenefits(EBenefitsType type, String name, int price);

	void assemble();

	void display();
}
