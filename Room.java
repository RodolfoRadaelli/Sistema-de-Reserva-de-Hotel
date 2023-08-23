import java.math.BigDecimal;
import java.io.Serializable;

public class Room implements Serializable
{
	protected int roomNumber;
	protected BigDecimal price;
	protected Status status;
	protected String type;

	Room( int roomNumber, Status status )
	{
		this.roomNumber = roomNumber;
		this.status = status;
	}

	Room ( int roomNumber )
	{
		this.roomNumber = roomNumber;
		status = status.LIBRE;
	}
	
	public int getRoomNumber ()
	{
		return roomNumber;
	}

	public void setRoomNumber ( int roomNumber)
	{
		this.roomNumber = roomNumber;
	}

	public BigDecimal getPrice ()
	{
		return price;
	}

	public void setPrice( BigDecimal price )
	{
		this.price = price;
	}

	public Status getStatus ()
	{
		return status;
	}

	public void setStatus( Status status)
	{
		this.status = status;
	}

	public void setType (String type)
	{
		this.type = type;
	}

	public String getType ()
	{
		return type;
	}

	@Override
	public String toString ()
	{
		return String.format("CLASS: Room%n" + 
			"roomNumber: %d%nprice by night: %s" +
			"%nstatus: %s%nType: %s%n", 
			getRoomNumber(), getPrice(), 
			getStatus(), getType());
	}
}
