
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Passengers
{
	// passenger listi hem AFC_General'de okumuþuz hem de burda, burdakini sonra sil
	private String passenger_name;
	private int luggage;
	private int ticket_price;
	private String which_class;
	private String from;
	private String to;
	private String which_company;
	
	// Constructor with parameters
	public Passengers (String passenger_name, int luggage, int ticket_price, String which_class, String from, String to, String which_company)
	{
		this.passenger_name = passenger_name;
		this.luggage = luggage;
		this.ticket_price = ticket_price;
		this.which_class = which_class;
		this.from = from;
		this.to = to;
		this.which_company = which_company;
	}
	
	// Constructor without parameters
	public Passengers ()
	{
		passenger_name = null;
		luggage = 0;
		ticket_price = 0;
		which_class = null;
		from = null;
		to = null;
		which_company = null;
	}
	
	// Get-set methods
	public String getPassenger_name()
	{
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name)
	{
		this.passenger_name = passenger_name;
	}

	public int getLuggage()
	{
		return luggage;
	}

	public void setLuggage(int luggage)
	{
		this.luggage = luggage;
	}

	public int getTicket_price()
	{
		return ticket_price;
	}

	public void setTicket_price(int ticket_price)
	{
		this.ticket_price = ticket_price;
	}

	public String getWhich_class()
	{
		return which_class;
	}

	public void setWhich_class(String which_class)
	{
		this.which_class = which_class;
	}

	public String getFrom()
	{
		return from;
	}

	public void setFrom(String from)
	{
		this.from = from;
	}

	public String getTo()
	{
		return to;
	}

	public void setTo(String to)
	{
		this.to = to;
	}

	public String getWhich_company()
	{
		return which_company;
	}

	public void setWhich_company(String which_company)
	{
		this.which_company = which_company;
	}

	public void passenger_list_from_file() throws IOException
	{
		String line_passenger;
		int counter = 0;
		File file = new File("C:\\Users\\Asus\\Desktop\\LECTURES\\FIRST YEAR-SPRING SEMESTER\\PROJECT BASED LEARNING-II\\FROM LECTURES\\PassengerList.txt");
		BufferedReader passenger_reader = null;
		passenger_reader = new BufferedReader(new FileReader(file));
		line_passenger = passenger_reader.readLine();
		String temp_string = " ";
		while (counter < 52)
		{
			temp_string = passenger_reader.readLine();
			if (!(temp_string.equals(null)));
			{
				counter++;
				line_passenger = temp_string;
			}
			
			String[] line_passenger_split = new String[8];
			for (int i = 0; i  < line_passenger_split.length; i++)
			{
				line_passenger_split = line_passenger.split(",");
			}
			for (int i = 0; i < line_passenger_split.length; i++)
			{
				System.out.print(line_passenger_split[i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
		
}
