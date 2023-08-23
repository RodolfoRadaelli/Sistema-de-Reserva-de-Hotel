import java.util.Scanner;

public class ReservationSystem
{
	private static Scanner input = new Scanner(System.in);

	public static void main ( String[] args)
	{
		int option;
		ClientFile.readFile();
		RoomFile.readFile();
		System.out.println();

		do
		{
			viewMenu();

			option = input.nextInt();

			switch ( option )
			{
				case 0: ;break;
				case 1: readRoom();break;
				case 2: loadReservation();break;
				case 3: showReservation();break;
				case 4: eraseReservation();break;
				default: System.out.println
					 ("Ingrese un valor valido.");
			}

		}while ( option != 0 );

	}

	public static void viewMenu ()
	{
		System.out.printf ("Ingrese un comando%n" +
				"1)Ver habitaciones%n" +
				"2)Cargar nueva reserva%n" +
				"3)Mostrar reserva%n" +
				"4)Cancelar reserva%n" +
				"0)Salir%n");
	}

	public static void readRoom()
	{
		RoomFile.showRegistryAll();
	}

	public static void loadReservation()
	{
		//Load registry to memory
		ClientFile.loadRegistry();

		//Update Client.data and Room.data files
		ClientFile.writeFile();
		ClientFile.readFile();
		RoomFile.writeFile();
		RoomFile.readFile();
	}

	public static void showReservation()
	{
		ClientFile.showRegistryAll();
	}

	public static void eraseReservation()
	{
		System.out.println("Ingrese numero de cliente a eliminar");
		int number = input.nextInt();
		ClientFile.deleteRegistry( number );
		ClientFile.writeFile();
		ClientFile.readFile();
		RoomFile.writeFile();
		RoomFile.readFile();                
	}
}
