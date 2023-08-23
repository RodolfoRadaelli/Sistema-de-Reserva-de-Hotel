import java.io.Serializable;

public class Date implements Serializable
{
	private int day;
	private int month;
	private int year;

	public Date ()
	{
		day = 0;
		month = 0;
		year = 0;
	}

	public Date ( int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public void setDay ( int day )
	{
		this.day = day;
	}

	public int getDay ()
	{
		return day;
	}

	public void setMonth ( int month )
	{
		this.month = month;
	}

	public int getMonth ( )
	{
		return month;
	}

	public void setYear ( int year )
	{
		this.year = year;
	}

	public int getYear ( )
	{
		return year;
	}

	public String showDate()
	{
		return String.format ("%d/%d/%d", getDay(), getMonth(),
				getYear() );
	}

	@Override
	public String toString ()
	{
		return String.format(
		"CLASS: Date%n%d/%d/%d%n", getDay(),getMonth(), getYear()
				);
	}

}
