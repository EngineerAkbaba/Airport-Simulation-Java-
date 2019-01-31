
public class Company
{
	private String from;
	private String to;
	private String company_type;
	Planes Airbus[];
	Planes Boeing[];
	
	public Company(String from,String to,String company_type)
	{
		this.company_type = company_type;
		this.from = from;
		this.to = to;
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
	
	public String getCompany_type()
	{
		return company_type;
	}
	
	public void setCompany_type(String company_type)
	{
		this.company_type = company_type;
	}

}