import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigDecimal;

public class ClientFile
{
	private static ArrayList<Client> arrayClient = new ArrayList<Client> ();

	public static void writeFile()
	{
		Scanner userInput = new Scanner (System.in);
		ObjectOutputStream clientOutput = null;
		int i = 0;

		try{
			clientOutput = new ObjectOutputStream 
				(Files.newOutputStream(Paths.get ("Client.data")));
		}

		catch ( IOException e )
		{
			System.err.println (e);
			System.exit (1);
		}

		sortElement();

		while ( i < arrayClient.size() )
		{
			try{
				clientOutput.writeObject( arrayClient.get(i) );
			}

			catch ( IOException e )
			{
				System.exit(1);
			}

			i++;

		}

		try
		{
			clientOutput.close();
			System.out.println 
				("El archivo de Clientes fue actualizado.");
		}

		catch ( IOException e )
		{
			System.exit(1);
		}
	}

	public static void loadRegistry()
	{
		Scanner userInput = new Scanner (System.in);
		int id;
		Date reservationDate = new Date();
		Date reservationStartDate = new Date();
		int reservationDays;
		int numberRoomReserved;
		BigDecimal amount;
		int clientCounter = 0;

		/**Input data*/
		System.out.printf ( "Ingrese id del cliente (EOF para salir)%n" );

		while ( userInput.hasNext() )
		{
			do{
				id = userInput.nextInt();
				if ( searchRegistry (id) != -1 )
					System.out.printf
						("Cliente existente,"+
						 "ingrese otro id.%n");
			}while ( searchRegistry (id) != -1 );

			System.out.println("Ingrese fecha de reserva (dd): ");
			reservationDate.setDay( userInput.nextInt() );

			System.out.println("Ingrese fecha de reserva (mm): ");
			reservationDate.setMonth( userInput.nextInt() );
	
			System.out.println("Ingrese fecha de reserva (yy): ");
			reservationDate.setYear( userInput.nextInt() );
	
			
			System.out.println("Ingrese fecha de inicio de reserva(dd): ");
			reservationStartDate.setDay( userInput.nextInt());

			System.out.println("Ingrese fecha de inicio de reserva(mm): ");
			reservationStartDate.setMonth( userInput.nextInt());

			System.out.println("Ingrese fecha de inicio de reserva(yy): ");
			reservationStartDate.setYear( userInput.nextInt());



			System.out.println("Ingrese dias de la reserva");
			do{
				reservationDays = userInput.nextInt();
			}while ( reservationDays < 0 );

			System.out.println("Ingrese numero de cuarto a reservar");
			do{
				numberRoomReserved = userInput.nextInt();

				if ( RoomFile.searchRegistry(numberRoomReserved) == -1 )
					System.out.println("Cuarto inexistente, ingrese otro");

				else if (RoomFile.showStatus(numberRoomReserved).name() != Status.LIBRE.name())
					System.out.println("Cuarto ocupado, ingrese otro");

			}while (RoomFile.searchRegistry(numberRoomReserved) == -1 || RoomFile.showStatus(numberRoomReserved).name() != Status.LIBRE.name());

			BigDecimal roomPrice = RoomFile.showPriceRoom(numberRoomReserved);


			BigDecimal days = BigDecimal.valueOf( reservationDays);
			amount = roomPrice.multiply(days);



			Client registry = new Client( id, reservationDate, reservationStartDate, reservationDays, numberRoomReserved, amount );
			RoomFile.changeStatus(numberRoomReserved, Status.RESERVADO);

			arrayClient.add(registry);
			clientCounter++;

			
			System.out.printf ( "Ingrese id del cliente (EOF para salir): %n" );
		}
		
		System.out.printf ("Se añadieron %d clientes.%n", clientCounter);
	}

	public static void readFile ()
	{
		ObjectInputStream clientInput = null;
		arrayClient.clear();

		try 
		{
			clientInput = new ObjectInputStream ( Files.newInputStream (Paths.get ("Client.data")));
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
				arrayClient.add ( (Client) clientInput.readObject() );
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
			clientInput.close();
			System.out.printf("%d Clientes cargados%n", arrayClient.size());
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

		for ( Client c: arrayClient )
		{

			if ( c.getId() == key )
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
		int index = searchRegistry (key);
		if ( index >= 0 )
		{
                        RoomFile.changeStatus(arrayClient.get(index).getNumberRoomReserved (), Status.LIBRE);
			arrayClient.remove(index);
			System.out.printf("El cliente %d fue eliminado%n", key );
		}

		else
			System.out.println("No se encontró registro.");
	}

	public static void showRegistry( int index )
	{

		Client c = arrayClient.get(index );
		System.out.printf ( "--Client - %d%n" +
				"Number of room: %d%n" +
				"Date of reserving: %s%n" +
				"Starting date to use: %s%n" +
				"Days to stay: %d%n" +
				"Amount: %s%n", 
			c.getId(), 
			c.getNumberRoomReserved(), 
			c.getReservationDate(), 
			c.getReservationStartDate(), 
			c.getReservationDays(), 
			c.getAmount() );

	}

	public static void showRegistryAll ()
	{
		sortElement();
		int i;

		for ( i = 0; i < arrayClient.size(); i++)
		{
			showRegistry(i);
		}
		System.out.println();
	}

	public static void sortElement()
	{
		int i, j;

		System.out.printf("ehhh: %d%n", arrayClient.size());

		for ( i = 1; i < arrayClient.size()-1; i++ )
		{
			for( j = 0; j < arrayClient.size() - 1; j++)
			{
				System.out.printf("%d>%d%n", arrayClient.get(i).getId(), arrayClient.get(j).getId());
				if ( arrayClient.get(j).getId() > 
						arrayClient.get(j+1).getId() )
				{
					System.out.println("on");
					Client aux = arrayClient.get(j);
					arrayClient.set(j, arrayClient.get(j+1));
					arrayClient.set(j+1, aux);
				}
			}
		}
	}

}
