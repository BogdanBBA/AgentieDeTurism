package classes;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import classes.iterator.IIterator;
import classes.iterator.StandardIterable;
import classes.model.City;
import classes.model.Hotel;
import classes.model.User;

public class Database
{
	private static Database instance;

	private final ArrayList<User> users;
	private final ArrayList<City> cities;
	private final ArrayList<Hotel> hotels;

	private Database()
	{
		this.users = new ArrayList<>();
		this.cities = new ArrayList<>();
		this.hotels = new ArrayList<>();
	}

	public static Database getInstance()
	{
		if (Database.instance == null)
			Database.instance = new Database();
		return Database.instance;
	}

	public ArrayList<User> getUsers()
	{
		return users;
	}

	public ArrayList<City> getCities()
	{
		return cities;
	}

	public ArrayList<Hotel> getHotels()
	{
		return hotels;
	}

	public String readFromDatabase()
	{
		try
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("db.xml");

			NodeList userNodes = ((Element) doc.getElementsByTagName("Users").item(0)).getElementsByTagName("User");
			for (int i = 0; i < userNodes.getLength(); i++)
			{
				Element userNode = (Element) userNodes.item(i);
				String username = userNode.getAttribute("username");
				String password = userNode.getAttribute("password");
				this.users.add(new User(username, password));
			}

			NodeList cityNodes = ((Element) doc.getElementsByTagName("Cities").item(0)).getElementsByTagName("City");
			for (int i = 0; i < cityNodes.getLength(); i++)
			{
				Element cityNode = (Element) cityNodes.item(i);
				int id = Integer.parseInt(cityNode.getAttribute("ID"));
				String name = cityNode.getAttribute("name");
				this.cities.add(new City(id, name));
			}

			NodeList hotelNodes = ((Element) doc.getElementsByTagName("Hotels").item(0)).getElementsByTagName("Hotel");
			for (int i = 0; i < hotelNodes.getLength(); i++)
			{
				Element hotelNode = (Element) hotelNodes.item(i);
				int id = Integer.parseInt(hotelNode.getAttribute("ID"));
				int type = Integer.parseInt(hotelNode.getAttribute("type"));
				String name = hotelNode.getAttribute("name");
				int cityId = Integer.parseInt(hotelNode.getAttribute("cityID"));
				double priceModifier = Double.parseDouble(hotelNode.getAttribute("priceModifier"));
				City city = this.cities.stream().filter(x -> x.getId() == cityId).findFirst().get();
				this.hotels.add(new Hotel(id,type, name, city, priceModifier));
			}

			return "";
		} catch (Exception e)
		{
			StringBuilder sb = new StringBuilder("Database read ERROR: " + e.toString() + "\n");
			for (StackTraceElement item : e.getStackTrace())
				sb.append(" - ").append(item).append("\n");
			return sb.toString();
		}
	}
	
	public ArrayList<Hotel> searchHotels(String query, int hotelType)
	{
		ArrayList<Hotel> result = new ArrayList<Hotel>();

		IIterator iterator = new StandardIterable().getIterator(this.hotels);
		while (iterator.moveNext())
		{
			Hotel hotel = (Hotel) iterator.current();
			boolean queryOk = query.isEmpty() 
					|| hotel.getName().toUpperCase().contains(query.toUpperCase())
					|| hotel.getCity().getName().toUpperCase().contains(query.toUpperCase());
			boolean typeOk = hotelType == -1 
					|| hotel.getType() == hotelType; 
			if (queryOk && typeOk)
				result.add(hotel);
		}

		return result;
	}
}
