import java.math.BigDecimal;

public class DoubleRoom extends Room
{
	DoubleRoom(int roomNumber, Status status )
	{
		super(roomNumber, status);
		price = BigDecimal.valueOf(30000);
		type = "Double Room";
	}

	DoubleRoom( int roomNumber)
	{
		super(roomNumber);
		price = BigDecimal.valueOf(1200);
		type = "Double Room";
	}


	@Override
	public String toString ()
	{
		return String.format("CLASS: DoubleRoom%n" + 
			"roomNumber: %d%nprice: %s" +
			"%nstatus: %s%nType: %s%n", 
			getRoomNumber(), getPrice(), 
			getStatus(), getType() );
	}

}
