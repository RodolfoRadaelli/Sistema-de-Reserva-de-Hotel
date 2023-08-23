import java.io.Serializable;
import java.math.BigDecimal;

public class Client implements Serializable
{
	private int id;
	private Date reservationDate;
	private Date reservationStartDate;
	private int reservationDays;
	private int numberRoomReserved;
	private BigDecimal amount;
		
	Client (int id, Date reservationDate, Date reservationStartDate,
			int reservationDays, int numberRoomReserved, 
			BigDecimal amount)
	{
		this.id = id;
		this.reservationDate = reservationDate;
		this.reservationStartDate = reservationStartDate;
		this.reservationDays = reservationDays;
		this.numberRoomReserved = numberRoomReserved;
		this.amount = amount;
	}

	public int getId ()
	{
		return id;
	}

	public void setId ( int id )
	{
		this.id = id;
	}

	public String getReservationDate ()
	{
		return reservationDate.showDate();
	}

	public void setReservationDate ( Date reservationDate )
	{
		this.reservationDate = reservationDate;
	}

	public String getReservationStartDate ()
	{
		return reservationStartDate.showDate();
	}

	public void setReservationStartDate ( Date reservationStartDate )
	{
		this.reservationStartDate = reservationStartDate;
	}

	public int getReservationDays ()
	{
		return reservationDays;
	}

	public void setReservationDays ( int reservationDays )
	{
		this.reservationDays = reservationDays;
	}

	public int getNumberRoomReserved ()
	{
		return numberRoomReserved;
	}

	public void setNumberRoomReserved ( int numberRoomReserved )
	{
		this.numberRoomReserved = numberRoomReserved;
	}

	public BigDecimal getAmount ()
	{
		return amount;
	}

	public void setAmount( BigDecimal amount )
	{
		this.amount = amount;
	}

	@Override
	public String toString()
	{
                return String.format("CLASS: Client%n" +
                        "Id: %d%nReservationDate: %s" +
                        "%nReservationStartDate: %s" +
			"%nReservationDays: %d" +
			"%nNumberRoomReserved: %d" +
			"%nAmount to pay: %s",
			getId(), getReservationDate(), 
			getReservationStartDate(), getReservationDays(),
			getNumberRoomReserved(), getAmount() );
	}
}
