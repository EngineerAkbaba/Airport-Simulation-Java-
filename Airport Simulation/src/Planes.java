
public class Planes
{
	private String plane_type;
	private Seats seats;
	
	// Constructor with parameters
	public Planes (String plane_type, Seats seats)
	{
		this.plane_type = plane_type;
		this.seats = seats;
	}
	
	// Constructor without parameters
	public Planes ()
	{
		plane_type = null;
		seats = null;
	}
	
	// Get-set methods
	public String getPlane_type()
	{
		return plane_type;
	}

	public void setPlane_type(String plane_type)
	{
		this.plane_type = plane_type;
	}

	public Seats getSeats()
	{
		return seats;
	}

	public void setSeats(Seats seats)
	{
		this.seats = seats;
	}
}
