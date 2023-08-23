import java.math.BigDecimal;

public class SuiteRoom extends Room
{
	private static int totalSuiteRoom;

	SuiteRoom(int roomNumber, Status status )
	{
		super(roomNumber, status);
		price = BigDecimal.valueOf ( 50000 );
		type = "Suite Room";
	}

	SuiteRoom( int roomNumber )
	{
		super ( roomNumber );
		price = BigDecimal.valueOf( 2000 );
		type = "Suite Room";
	}

	@Override
	public String toString ()
	{
		return String.format("CLASS: SuiteRoom%n" + 
			"roomNumber: %d%nprice: %s" +
			"%nstatus: %s%nType: %s%n", 
			getRoomNumber(), getPrice(), 
			getStatus(), getType() );
	}

}
