import java.math.BigDecimal;

public class SingleRoom extends Room
{
	private static int totalSingleRoom;

	SingleRoom(int roomNumber, Status status )
	{
		super(roomNumber, status);
		price = BigDecimal.valueOf(20000);
		type = "Single Room";
	}

	SingleRoom( int roomNumber )
	{
		super(roomNumber);
		price = BigDecimal.valueOf(900);
		type = "Single Room";
	}

	@Override
	public String toString ()
	{
		return String.format("CLASS: SingleRoom%n" + 
			"roomNumber: %d%nprice: %s" +
			"%nstatus: %s%nType: %s%n", 
			getRoomNumber(), getPrice(), 
			getStatus(), getType() );
	}

}
