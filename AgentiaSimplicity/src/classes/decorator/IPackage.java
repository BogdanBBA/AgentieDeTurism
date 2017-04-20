package classes.decorator;

import java.util.List;

public interface IPackage 
{
	EPackageType getType();

	void setType(EPackageType type);

	void setBenefits(EBenefitsType type, String name, int price);

	void Assemble();

	List<String> Display();
}
