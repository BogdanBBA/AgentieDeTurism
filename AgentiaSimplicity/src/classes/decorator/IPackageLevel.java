package classes.decorator;

import javafx.scene.control.TextArea;

public interface IPackageLevel
{
	EPackageType getType();

	void setType(EPackageType type);

	void setBenefits(EBenefitsType type, String name, int price);

	void Assemble();

	void Display(TextArea detailsText);
	
}
