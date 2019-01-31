
public class Flight
{
	private String airplane_type;
	private String flight_type;
	private String which_company;
	private String from;
	private String to;
	private String flight_number;
	private int arrival_or_departure_time;
	private int service_time;
	private Seats [] passengers = new Seats[8];
	private int finishing_time;
	private int waiting_time;
	
	// Constructor with parameters
	public Flight (String airplane_type, String flight_type, String which_company, String from, String to, String flight_number, int arrival_or_departure_time, int service_time)
	{
		this.airplane_type = airplane_type;
		this.flight_type = flight_type;
		this.which_company = which_company;
		this.from = from;
		this.to = to;
		this.flight_number = flight_number;
		this.arrival_or_departure_time = arrival_or_departure_time;
		this.service_time = service_time;
		
	}
	
	// Constructor without parameters
	public Flight ()
	{
		airplane_type = null;
		flight_type = null;
		which_company = null;
		from = null;
		to = null;
		flight_number = null;
		arrival_or_departure_time = 0;
		service_time = 0;
	}
	
	// Get-set methods
	public int getFinishing_time()
	{
		return finishing_time;
	}

	public void setFinishing_time(int finishing_time)
	{
		this.finishing_time = finishing_time;
	}

	public int getWaiting_time()
	{
		return waiting_time;
	}

	public void setWaiting_time(int waiting_time)
	{
		this.waiting_time = waiting_time;
	}
	
	public String getAirplane_type()
	{
		return airplane_type;
	}

	public void setAirplane_type(String airplane_type)
	{
		this.airplane_type = airplane_type;
	}

	public String getFlight_type()
	{
		return flight_type;
	}

	public void setFlight_type(String flight_type)
	{
		this.flight_type = flight_type;
	}

	public String getWhich_company()
	{
		return which_company;
	}

	public void setWhich_company(String which_company)
	{
		this.which_company = which_company;
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

	public String getFlight_number()
	{
		return flight_number;
	}

	public void setFlight_number(String flight_number)
	{
		this.flight_number = flight_number;
	}

	public int getArrival_or_departure_time()
	{
		return arrival_or_departure_time;
	}

	public void setArrival_or_departure_time(int arrival_or_departure_time)
	{
		this.arrival_or_departure_time = arrival_or_departure_time;
	}

	public int getService_time()
	{
		return service_time;
	}

	public void setService_time(int service_time)
	{
		this.service_time = service_time;
	}
	public Seats[] getPassengers()
	{
		return passengers;
	}

	public void setPassengers(Seats[] economic_passengers)
	{
		this.passengers = economic_passengers;
	}
	
}