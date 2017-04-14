package classes;

public interface IPackageOfferBuilder 
{
	PackageOffer getPackageOffer();
	void SetRoom(Rooms room);
	void SetHotel(Hotel hotel);
	void SetPrice(int price);
	
}
