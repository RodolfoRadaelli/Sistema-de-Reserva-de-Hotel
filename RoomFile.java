import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;

public class RoomFile
{
	private static ArrayList<Room> arrayRoom = new ArrayList<Room> ();

	public static void writeFile()
	{
		Scanner userInput = new Scanner (System.in);
		ObjectOutputStream roomOutput = null;
		int i = 0;

		try{
			roomOutput = new ObjectOutputStream 
				(Files.newOutputStream(Paths.get ("Room.data")));
		}

		catch ( IOException e )
		{
			System.err.println (e);
			System.exit (1);
		}

		sortElement();

		while ( i < arrayRoom.size() )
		{
			try{
				roomOutput.writeObject( arrayRoom.get(i) );
			}

			catch ( IOException e )
			{
				System.exit(1);
			}

			i++;

		}

		try
		{
			roomOutput.close();
			System.out.println ("El archivo Room fue grabado.");
		}

		catch ( IOException e )
		{
			System.exit(1);
		}
	}

//Method used to create Room.data
/*	public static void writeFile ()
	{
		Scanner dataInput = new Scanner (System.in);
		int roomNumber;
		BigDecimal price;
		Status status = null;
		ObjectOutputStream roomOutput = null;
		Room registry = null;

		try
		{
			roomOutput = new ObjectOutputStream (Files.newOutputStream(Paths.get ("Room.data")));
		}

		catch ( IOException e )
		{
			System.err.println (e);
			System.exit (1);
		}

		//Input data

		System.out.printf ( "Ingrese numero de cuarto%n" );

		while ( dataInput.hasNext() )
		{
			roomNumber = dataInput.nextInt();

			System.out.println ("Ingrese tipo de cuarto");

			System.out.printf ("1)Double%n2)Single%n3)Suite%n");

			int selectorRoom = dataInput.nextInt();

			switch (selectorRoom)
			{
				case 1: registry = new DoubleRoom
					( roomNumber);break;
				case 2: registry = new SingleRoom
					( roomNumber);break;
				case 3: registry = new SuiteRoom
					( roomNumber );break;
				default: System.out.println("Valor erroneo");
			}

			try{
			roomOutput.writeObject( registry );
			}

			catch ( IOException e )
			{
				System.exit(1);
			}

		System.out.printf ( "Ingrese numero de cuarto%n" );
		}
		
		try
		{
			roomOutput.close();
			System.out.println ("Se escribió el archivo de cuartos.");
		}

		catch ( IOException e )
		{
			System.exit(1);
		}
	}
*/
	public static void readFile ()
	{
		ObjectInputStream roomInput = null;
		arrayRoom.clear();
		int registryCounter = 0;

		try 
		{
			roomInput = new ObjectInputStream ( 
					Files.newInputStream (Paths.get 
						("Room.data")));
		}

		catch ( IOException e )
		{
			System.err.println (e);
			System.exit (1);
		}

		try
		{
			while (true)
			{
				arrayRoom.add ( (Room) roomInput.readObject() );
				registryCounter++;
			}
		
		}

		catch ( EOFException e )
		{
			//System.out.printf ("no hay más registros%n");
		}

		catch ( ClassNotFoundException e )
		{
			System.err.println ("Tipo de objeto invalido.");
		}

		catch ( IOException e )
		{
			System.exit(1);
		}

	
		try
		{
			roomInput.close();
			System.out.printf("Se ha cargado %d cuartos.%n",
					registryCounter);
		}

		catch ( IOException e )
		{
			System.exit(1);
		}

	}

	public static int searchRegistry ( int key )
	{
		int indexKey = -1;
		int i = 0;

		for ( Room r : arrayRoom )
		{
			if ( r.getRoomNumber() == key )
			{
				indexKey = i;
				break;
			}
			i++;

		}

		return indexKey;
	}

	public static void deleteRegistry( int key )
	{
		int index;

		index = searchRegistry(key);

		if ( index >= 0 )
		{
			arrayRoom.remove(index);
			System.out.printf("Se ha eliminado el registro" +
					"%d%n", index);
		}
		else
			System.out.println("Registo invalido.");
	}

	public static void showRegistry( int index )
	{
		Room r = arrayRoom.get( index );
		System.out.printf ( "--Room - %d%n" +
				"Type: %s%n" + "Price: %f%n"
				+ "Status: %s%n", 
			r.getRoomNumber(), 
			r.getType(),
			r.getPrice(),
			r.getStatus());
	}

	public static void showRegistryAll ()
	{
		sortElement();
		int i;

		for ( i = 0; i < arrayRoom.size(); i++)
		{
			showRegistry(i);
		}

		System.out.println();
	}

	public static void changeStatus ( int key, Status status )
	{
		Room r = arrayRoom.get(searchRegistry (key) );
		r.setStatus( status );	
	}

	public static BigDecimal showPriceRoom ( int key)
	{
		return arrayRoom.get(searchRegistry(key)).getPrice();
	}

	public static Status showStatus ( int key)
	{
		int index = searchRegistry(key);

		return arrayRoom.get(index).getStatus();
	}

	public static int getIndex ()
	{
		return arrayRoom.size();
	}

	public static void sortElement()
	{
		int i, j;

		for ( i = 1; i < arrayRoom.size()-1; i++ )
		{
			for( j = 0; j < arrayRoom.size() - 1; j++)
			{
				if ( arrayRoom.get(j).getRoomNumber() > 
						arrayRoom.get(j+1).getRoomNumber() )
				{
					Room aux = arrayRoom.get(j);
					arrayRoom.set(j, arrayRoom.get(j+1));
					arrayRoom.set(j+1, aux);
				}
			}
		}
	}
}
