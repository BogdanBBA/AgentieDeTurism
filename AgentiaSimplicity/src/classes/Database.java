package classes;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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
				String name = hotelNode.getAttribute("name");
				int cityId = Integer.parseInt(hotelNode.getAttribute("cityID"));
				City city = this.cities.stream().filter(x -> x.id == cityId).findFirst().get();
				this.hotels.add(new Hotel(id, name, city));
			}

			return "";
		} catch (Exception e)
		{
			return e.toString();
		}
	}
}
