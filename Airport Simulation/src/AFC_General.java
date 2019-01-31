
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class AFC_General
{
	enigma.console.Console cn = Enigma.getConsole("AFC_General");

	public AFC_General() throws IOException
	{
		print_general_screen();
		flight_list_from_file();
		passenger_list_from_file();
		placing_passenger();
		Circular_Queue arrival_planes = new Circular_Queue(8);
		Circular_Queue departure_planes = new Circular_Queue(8);
		Flight flight = new Flight();
		int current_time = 40;
		int satir_sayisi1 = 6;
		int satir_sayisi2 = 23;
		
		while(!stackFlight.isEmpty() || !arrival_planes.isEmpty() || !departure_planes.isEmpty())
		{
			if(!arrival_planes.isEmpty() && !departure_planes.isEmpty())
			{
				Random random = new Random();
				int a = random.nextInt(99);
				if(a < 66)
				{
					flight = (Flight)arrival_planes.dequeue();
				}
				else
				{
					flight = (Flight)departure_planes.dequeue();
				}
			}
			else if(!arrival_planes.isEmpty() && departure_planes.isEmpty())
			{
				flight = (Flight)arrival_planes.dequeue();
			}
			else if(arrival_planes.isEmpty() && !departure_planes.isEmpty())
			{
				flight = (Flight)departure_planes.dequeue();
			}
			else
			{
				flight = (Flight)stackFlight.Pop();
			}
			if(current_time < flight.getArrival_or_departure_time())
			{
				current_time = flight.getArrival_or_departure_time();
			}
			if(!stackFlight.isEmpty())
			{
				while(!stackFlight.isEmpty() &&(current_time + flight.getService_time()) >= ((Flight)stackFlight.Peek()).getArrival_or_departure_time())
				{
					if(((Flight)stackFlight.Peek()).getFlight_type().equals("A"))
					{
						arrival_planes.enqueue(stackFlight.Pop());
					}
					else
					{
						departure_planes.enqueue(stackFlight.Pop());
					}
				}
			}
			if(current_time > flight.getArrival_or_departure_time())
			{
				flight.setWaiting_time(current_time - flight.getArrival_or_departure_time());
				flight.setArrival_or_departure_time(current_time);
				flight.setFinishing_time(current_time + flight.getService_time());
			}
			else
			{
				flight.setWaiting_time(0);
				flight.setFinishing_time(current_time + flight.getService_time());
			}
			current_time = current_time + flight.getService_time() - 30;
			
			System.in.read();
			if (current_time == flight.getArrival_or_departure_time())
			{
				cn.getTextWindow().setCursorPosition(0, satir_sayisi2);
				System.out.print(flight.getFlight_type());
				
				cn.getTextWindow().setCursorPosition(13, satir_sayisi2);
				System.out.print(flight.getWhich_company());
				
				cn.getTextWindow().setCursorPosition(25, satir_sayisi2);
				System.out.print(flight.getFrom());
				
				cn.getTextWindow().setCursorPosition(35, satir_sayisi2);
				System.out.print(flight.getTo());
				
				cn.getTextWindow().setCursorPosition(47, satir_sayisi2);
				System.out.print(flight.getFlight_number());
				
				cn.getTextWindow().setCursorPosition(62, satir_sayisi2);
				System.out.print(flight.getArrival_or_departure_time());
				
				cn.getTextWindow().setCursorPosition(79, satir_sayisi2);
				System.out.print(flight.getFinishing_time());
				
				cn.getTextWindow().setCursorPosition(93, satir_sayisi2);
				System.out.print(flight.getWaiting_time());
				
				cn.getTextWindow().setCursorPosition(134, 20);
				System.out.print(flight.getFlight_number());
				
			}
			else
			{
				System.in.read();
				cn.getTextWindow().setCursorPosition(86, 0);
				System.out.print(current_time);
				
				cn.getTextWindow().setCursorPosition(0, satir_sayisi1);
				System.out.print(flight.getWhich_company());
				
				cn.getTextWindow().setCursorPosition(13, satir_sayisi1);
				System.out.print(flight.getFrom());
				
				cn.getTextWindow().setCursorPosition(25, satir_sayisi1);
				System.out.print(flight.getTo());
				
				cn.getTextWindow().setCursorPosition(35, satir_sayisi1);
				System.out.print(flight.getFlight_number());
				
				cn.getTextWindow().setCursorPosition(47, satir_sayisi1);
				System.out.print(flight.getArrival_or_departure_time());
				
				cn.getTextWindow().setCursorPosition(61, satir_sayisi1);
				System.out.println(flight.getService_time());
			}
			satir_sayisi1++;
			satir_sayisi2++;
		}
		System.out.println();
	}
	
	static TextAttributes first_color = new TextAttributes(Color.blue, Color.green);
	static TextAttributes second_color = new TextAttributes(Color.black, Color.green);
	static TextAttributes third_color = new TextAttributes(Color.black, Color.blue);
	public static Circular_Queue QueuePassengers = new Circular_Queue(100);
	public static Stack stackFlight = new Stack(8);
	public static Stack temp = new Stack(8);
	public static Stack temp2 = new Stack(8);
	
	public void print_general_screen()
	{
		cn.getTextWindow().setCursorPosition(60, 0);
		cn.getTextWindow().output("C U R R E N T    T I M E:", first_color);

		cn.getTextWindow().setCursorPosition(0, 1);
		for (int i = 0; i < 150; i++)
		{
			cn.getTextWindow().output("*", third_color);
		}

		cn.getTextWindow().setCursorPosition(0, 2);
		cn.getTextWindow().output("WAITING DEPARTURES", first_color);

		cn.getTextWindow().setCursorPosition(0, 4);
		cn.getTextWindow().output("Company:", second_color);
		cn.getTextWindow().setCursorPosition(0, 5);
		cn.getTextWindow().output("        ", second_color);

		cn.getTextWindow().setCursorPosition(13, 4);
		cn.getTextWindow().output("From:", second_color);
		cn.getTextWindow().setCursorPosition(13, 5);
		cn.getTextWindow().output("     ", second_color);

		cn.getTextWindow().setCursorPosition(25, 4);
		cn.getTextWindow().output("To:", second_color);
		cn.getTextWindow().setCursorPosition(25, 5);
		cn.getTextWindow().output("   ", second_color);

		cn.getTextWindow().setCursorPosition(35, 4);
		cn.getTextWindow().output("Flight ", second_color);
		cn.getTextWindow().setCursorPosition(35, 5);
		cn.getTextWindow().output("Number:", second_color);
		
		cn.getTextWindow().setCursorPosition(47, 4);
		cn.getTextWindow().output("Departure", second_color);
		cn.getTextWindow().setCursorPosition(47, 5);
		cn.getTextWindow().output("Time    :", second_color);

		cn.getTextWindow().setCursorPosition(61, 4);
		cn.getTextWindow().output("Service", second_color);
		cn.getTextWindow().setCursorPosition(61, 5);
		cn.getTextWindow().output("Time  :", second_color);

		int position_counter1 = 2;
		for (int i = 0; i < 18; i++)
		{
			cn.getTextWindow().setCursorPosition(73, position_counter1);
			cn.getTextWindow().output("*", third_color);
			position_counter1++;
		}
		// *********************************************
		cn.getTextWindow().setCursorPosition(80, 2);
		cn.getTextWindow().output("WAITING ARRIVALS", first_color);

		cn.getTextWindow().setCursorPosition(80, 4);
		cn.getTextWindow().output("Company:", second_color);
		cn.getTextWindow().setCursorPosition(80, 5);
		cn.getTextWindow().output("        ", second_color);

		cn.getTextWindow().setCursorPosition(93, 4);
		cn.getTextWindow().output("From:", second_color);
		cn.getTextWindow().setCursorPosition(93, 5);
		cn.getTextWindow().output("     ", second_color);

		cn.getTextWindow().setCursorPosition(105, 4);
		cn.getTextWindow().output("To:", second_color);
		cn.getTextWindow().setCursorPosition(105, 5);
		cn.getTextWindow().output("   ", second_color);

		cn.getTextWindow().setCursorPosition(115, 4);
		cn.getTextWindow().output("Flight ", second_color);
		cn.getTextWindow().setCursorPosition(115, 5);
		cn.getTextWindow().output("Number:", second_color);

		cn.getTextWindow().setCursorPosition(125, 4);
		cn.getTextWindow().output("Arrival", second_color);
		cn.getTextWindow().setCursorPosition(125, 5);
		cn.getTextWindow().output("Time  :", second_color);

		cn.getTextWindow().setCursorPosition(137, 4);
		cn.getTextWindow().output("Service Time:", second_color);
		cn.getTextWindow().setCursorPosition(137, 5);
		cn.getTextWindow().output("             ", second_color);

		int position_counter2 = 1;
		for (int i = 0; i < 20; i++)
		{
			cn.getTextWindow().setCursorPosition(150, position_counter2);
			cn.getTextWindow().output("*", third_color);
			position_counter2++;
		}
		// ##############################################
		cn.getTextWindow().setCursorPosition(0, 20);
		for (int i = 0; i < 113; i++)
		{
			cn.getTextWindow().output("*", third_color);
		}
		cn.getTextWindow().setCursorPosition(139, 20);
		for (int i = 0; i < 11; i++)
		{
			cn.getTextWindow().output("*", third_color);
		}

		cn.getTextWindow().setCursorPosition(0, 21);
		cn.getTextWindow().output("Type      :", second_color);
		cn.getTextWindow().setCursorPosition(0, 22);
		cn.getTextWindow().output("(Ar or Dep)", second_color);

		cn.getTextWindow().setCursorPosition(13, 21);
		cn.getTextWindow().output("Company:", second_color);
		cn.getTextWindow().setCursorPosition(13, 22);
		cn.getTextWindow().output("        ", second_color);

		cn.getTextWindow().setCursorPosition(25, 21);
		cn.getTextWindow().output("From:", second_color);
		cn.getTextWindow().setCursorPosition(25, 22);
		cn.getTextWindow().output("     ", second_color);

		cn.getTextWindow().setCursorPosition(35, 21);
		cn.getTextWindow().output("To:", second_color);
		cn.getTextWindow().setCursorPosition(35, 22);
		cn.getTextWindow().output("   ", second_color);

		cn.getTextWindow().setCursorPosition(47, 21);
		cn.getTextWindow().output("Flight ", second_color);
		cn.getTextWindow().setCursorPosition(47, 22);
		cn.getTextWindow().output("Number:", second_color);

		cn.getTextWindow().setCursorPosition(61, 21);
		cn.getTextWindow().output("Ar/Dep ", second_color);
		cn.getTextWindow().setCursorPosition(61, 22);
		cn.getTextWindow().output("Time  :", second_color);

		cn.getTextWindow().setCursorPosition(79, 21);
		cn.getTextWindow().output("Finishing", second_color);
		cn.getTextWindow().setCursorPosition(79, 22);
		cn.getTextWindow().output("Time    :", second_color);

		cn.getTextWindow().setCursorPosition(93, 21);
		cn.getTextWindow().output("Waiting", second_color);
		cn.getTextWindow().setCursorPosition(93, 22);
		cn.getTextWindow().output("Time  :", second_color);

		int position_counter3 = 21;
		for (int i = 0; i < 18; i++)
		{
			cn.getTextWindow().setCursorPosition(106, position_counter3);
			cn.getTextWindow().output("*", third_color);
			position_counter3++;
		}
		// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		cn.getTextWindow().setCursorPosition(113, 20);
		cn.getTextWindow().output("PASSENGERS OF FLÝGHT:", first_color);

		cn.getTextWindow().setCursorPosition(113, 22);
		cn.getTextWindow().output("Seat No:", second_color);
		cn.getTextWindow().setCursorPosition(113, 21);
		cn.getTextWindow().output("        ", second_color);

		cn.getTextWindow().setCursorPosition(125, 22);
		cn.getTextWindow().output("Name:", second_color);
		cn.getTextWindow().setCursorPosition(125, 21);
		cn.getTextWindow().output("     ", second_color);

		cn.getTextWindow().setCursorPosition(142, 22);
		cn.getTextWindow().output("Luggage:", second_color);
		cn.getTextWindow().setCursorPosition(142, 21);
		cn.getTextWindow().output("        ", second_color);

		int position_counter4 = 21;
		for (int i = 0; i < 18; i++)
		{
			cn.getTextWindow().setCursorPosition(150, position_counter4);
			cn.getTextWindow().output("*", third_color);
			position_counter4++;
		}

		cn.getTextWindow().setCursorPosition(0, 38);
		for (int i = 0; i < 151; i++)
		{
			cn.getTextWindow().output("*", third_color);
		}
	}
	
	public void flight_list_from_file() throws IOException
	{
		String line_flight;
		int counter = 0;
		Flight[] flight = new Flight[8];
		String[] x = null;
		File file = new File("FlightList.txt");
		BufferedReader flight_reader = null;
		flight_reader = new BufferedReader(new FileReader(file));
		String temp_string = " ";
		int j = 0;
		while (counter < 8)
		{
			temp_string = flight_reader.readLine();
			if (temp_string != null);
			{
				counter++;
				line_flight = temp_string;
			}
			String[] line_flight_split = new String[8];
			for (int i = 0; i  < line_flight_split.length; i++)
			{
				line_flight_split = line_flight.split(",");
				x = line_flight_split;
			}
			flight[j]  =new Flight((String)x[0], (String)x[1], (String)x[2], (String)x[3], (String)x[4], (String)x[5], Integer.parseInt(x[6]), Integer.parseInt(x[7]));
			stackFlight.Push(flight[j]);
			j++;
		}
		Flight_sorting();
	}
	
	private void Flight_sorting()
	{
		while(!stackFlight.isEmpty())
		{
			Flight f = (Flight)stackFlight.Pop();
			int number = f.getArrival_or_departure_time();
			while(!temp.isEmpty() && ((Flight)temp.Peek()).getArrival_or_departure_time() < number)
			{
				temp2.Push(temp.Pop());
			}
			if (!temp.isEmpty() && ((Flight)temp.Peek()).getArrival_or_departure_time() <= number)
			{
				while(!temp.isEmpty())
				{
					temp2.Push(temp.Pop());
				}
				temp.Push(f );
			}
			else
			{
				temp.Push(f );
			}
			while(!temp2.isEmpty())
			{
				temp.Push(temp2.Pop());
			}
		}
		stackFlight = temp;
	}
	
	public void placing_passenger()
	{
		Stack temp = new Stack(8);
		while(!stackFlight.isEmpty())
		{
			int buis_capacity = 2;
			int eco_capacity = 6;
			int seat_no = 0;
			String [] seat_numbers = new String[8];
			seat_numbers[0] = "A1";
			seat_numbers[1] = "A2";
			seat_numbers[2] = "B1";
			seat_numbers[3] = "B2";
			seat_numbers[4] = "C1";
			seat_numbers[5] = "C2";
			seat_numbers[6] = "D1";
			seat_numbers[7] = "D2";
			
			if(((Flight)stackFlight.Peek()).getAirplane_type().equals("Boeing"))
			{
				eco_capacity = 4;
			}
			int limit = QueuePassengers.size();
			
			for (int i = 0; i < limit; i++)
			{
				boolean flag = true;
				if(((Passengers)QueuePassengers.peek()).getWhich_class().equals("Economy"))
				{
					if(eco_capacity != 0 && ((Passengers)QueuePassengers.peek()).getFrom().equals(((Flight)stackFlight.Peek()).getFrom())
							&& ((Passengers)QueuePassengers.peek()).getTo().equals(((Flight)stackFlight.Peek()).getTo()) 
							&&((Passengers)QueuePassengers.peek()).getWhich_company().equals(((Flight)stackFlight.Peek()).getWhich_company()))
					{
						((Flight)stackFlight.Peek()).getPassengers()[seat_no]=new Seats(seat_numbers[seat_no],"Economy",(Passengers)QueuePassengers.dequeue());
						flag = false;
					}
				}
				else
				{
					if(eco_capacity != 0 && ((Passengers)QueuePassengers.peek()).getFrom().equals(((Flight)stackFlight.Peek()).getFrom())
							&& ((Passengers)QueuePassengers.peek()).getTo().equals(((Flight)stackFlight.Peek()).getTo()) 
							&&((Passengers)QueuePassengers.peek()).getWhich_company().equals(((Flight)stackFlight.Peek()).getWhich_company()))
					{
						((Flight)stackFlight.Peek()).getPassengers()[seat_no]=new Seats(seat_numbers[seat_no],"Buisness",(Passengers)QueuePassengers.dequeue());
						flag = false;
					}
				}
				if(flag)
				{
					QueuePassengers.enqueue(QueuePassengers.dequeue());
				}
			}
			temp.Push(stackFlight.Pop());
		}
		while (!temp.isEmpty())
		{
			stackFlight.Push(temp.Pop());
		}
	}
	
	public void passenger_list_from_file() throws IOException
	{
		String line_passenger;
		int counter = 0;
		Passengers passengers;
		String[] x = null;
		
		File file = new File("PassengerList.txt");
		BufferedReader passenger_reader = null;
		passenger_reader = new BufferedReader(new FileReader(file));
		String temp_string = " ";
		while (counter < 52)
		{
			temp_string = passenger_reader.readLine();
			if (!(temp_string.equals(null)));
			{
				counter++;
				line_passenger = temp_string;
			}
			String[] line_passenger_split = new String[52];
			for (int i = 0; i  < line_passenger_split.length; i++)
			{
				line_passenger_split = line_passenger.split(",");
				x=line_passenger_split;
			}
			passengers=new Passengers(x[0],Integer.parseInt(x[1]),Integer.parseInt(x[2]),x[3],x[4],x[5],x[6]);
			QueuePassengers.enqueue(passengers);
		}
	}

}
