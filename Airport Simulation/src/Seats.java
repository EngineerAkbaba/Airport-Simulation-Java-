
public class Seats
{
	private String seat_number;
	private String seat_type_business_or_economic;
	private Passengers pass;
	
	public Seats (String seat_number, String seat_type_business_or_economic, Passengers pass)
	{
		this.seat_number = seat_number;
		this.seat_type_business_or_economic = seat_type_business_or_economic;
		this.pass = pass;
	}

	// Get-set methods
	public String getSeat_number()
	{
		return seat_number;
	}

	public void setSeat_number(String seat_number)
	{
		this.seat_number = seat_number;
	}

	public String getSeat_type_business_or_economic()
	{
		return seat_type_business_or_economic;
	}

	public void setSeat_type_business_or_economic(String seat_type_business_or_economic)
	{
		this.seat_type_business_or_economic = seat_type_business_or_economic;
	}

	public Passengers getPass_yolcular()
	{
		return pass;
	}

	public void setPass_yolcular(Passengers pass_yolcular)
	{
		this.pass = pass_yolcular;
	}
	
}
