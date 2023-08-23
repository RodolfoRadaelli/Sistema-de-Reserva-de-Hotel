# Sistema de reservas para cuartos de hotel

## Descripción del proyecto
El proyecto consiste en un sistema de reservas para cuartos de hotel, donde el usuario puede:
- Agregar reservas
- Eliminar reservas
- Ver el estado de los cuartos del hotel
- Ver todas las reservas.

	El programa utiliza la clase **serializable** para guardar la información y acceder a ella, en los archivos *Client.data* para las reservas, y los cuartos en *Room.data*, con este ultimo teniendo los cuartos del hotel precargados.

	El programa fue hecho como practica para leer y escribir en ficheros.

## Como ejecutar el proyecto
La clase principal del programa es ***ReservationSystem.***

## Como usar el programa
Se abre un menu donde se tiene 5 posibilidades.
1. Ver cuartos
1. Cargar una reserva
1. Ver reservas
1. Eliminar reserva.
1. Salir del programa

La función ver cuartos, mostrará el listado de cuartos con los siguientes datos:
- El numero de cuarto.
- Tipo de cuarto: doble, simple, suite
- Precio
- Estado: ocupado, libre

La función cargar una reserva, pedirá los datos para cargar una nueva reserva. 
- Comenzando con el id del cliente
- Fecha en que se carga la reserva
- Fecha sobre cuando el cliente ocupará la habitación
- Numero de días.
- Cuarto que en el que se quedará. 
	Para terminar la carga de clientes, se utiliza el fin de archivo.

La función ver reservas mostrará el listado de todas las reservas con los siguientes datos:
1. Id del cliente
1. Numero de cuarto
1. Fecha en que se registró la reserva
1. Fecha en que se ocupará la habitación
1. Dias a ocupar
1. Precio

La función eliminar reserva pide un id de cliente valido para eliminar la reserva.

