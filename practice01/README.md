# Funcionamiento del Código Java de reservas de teatro
Este código consta de dos clases: **App** y **Reserved**. **App** se encarga de interactuar con el usuario a través de la entrada estándar y llamar a los métodos relevantes en la clase **Reserved** para crear, anular o mostrar el estado de las reservas.

## Class Seat

Esta clase es responsable de representar un asiento individual en el teatro. Contiene información sobre el número de fila, la letra de la columna y el estado de reserva del asiento.

### Variables de instancia
- "rowNumber": un entero que representa el número de fila del asiento
- "colLetter": un carácter que representa la letra de la columna del asiento
- "reserved": un booleano que indica si el asiento está reservado o no

### Constructor
El constructor de la clase "Seat" toma dos parámetros: "rowNumber" y "colLetter", que se utilizan para inicializar las variables de instancia correspondientes. También establece el valor de "reserved" en 'false', lo que significa que el asiento no está reservado inicialmente.

### Métodos
- 'getSeatNumber()': un método que devuelve una cadena que representa el número de asiento completo (es decir, la concatenación del número de fila y la letra de la columna).
- 'getReserved()': un método que devuelve un booleano que indica si el asiento está reservado o no.
- 'reserve()': un método que establece el valor de "reserved" en 'true', lo que significa que el asiento está reservado.

## Clase Reserved
En el archivo 'Reserved.java', se define la clase "Reserved", que representa el teatro y contiene la matriz de asientos y los métodos para buscar, mostrar y reservar los asientos.

### Variables de instancia
- "rowNumber" y "colNumber": números de filas y columnas de la matriz de asientos (ambas inicializadas con 20 por defecto)
- "seats": matriz de objetos "Seat" que representa los asientos del teatro.

### Constructor
El constructor "Reserved" toma dos argumentos para establecer el número de filas y columnas de la matriz de asientos. Inicializa la matriz de asientos y llama al método 'assignSeats()' para asignar a cada celda de la matriz un objeto "Seat".

### Métodos
- 'assignSeats()': método privado que asigna los objetos "Seat" a cada celda de la matriz. Recorre cada fila y columna y crea un objeto "Seat" con el número de fila y columna correspondiente.

- 'searchSeat(seatNumber)': método público que toma como argumento el número de asiento en formato "fila-letra" (por ejemplo, "5-B"). Primero normaliza el número de asiento a mayúsculas y sin guiones ni ceros al principio. Luego verifica que el número de asiento sea válido según el número de filas y columnas de la matriz de asientos. Si es válido, devuelve el objeto "Seat" correspondiente.

- 'displaySeatMatrix()': método público que muestra la matriz de asientos y su estado de reserva. Recorre cada fila y columna y muestra el número de asiento de cada asiento. Si un asiento está reservado, muestra "//" en su lugar.

- 'reserveSeat(seatNumber)': método público que toma como argumento el número de asiento en formato "fila-letra" (por ejemplo, "5-B"). Llama al método 'searchSeat()' para encontrar el objeto "Seat" correspondiente y si el asiento no está reservado, lo reserva llamando al método 'reserve()' en el objeto "Seat". Si el asiento ya está reservado, muestra un mensaje de error.

## Clase App

### Variables de instancia
- "reserved": objeto "Reserved" que representa el teatro.

### Método main()
El método 'main()' es el punto de entrada del programa. Crea un nuevo objeto "Reserved" con 20 filas y 20 columnas y lo asigna a la variable "reserved". Luego muestra un mensaje de bienvenida y las opciones del menú en la consola. Después, entra en un ciclo infinito que permite al usuario seleccionar una opción del menú hasta que se selecciona la opción para salir.

Dentro del ciclo, lee la opción del usuario de la entrada estándar y llama al método correspondiente en el objeto "Reserved". Si la opción es "a" o "c" (crear o anular reserva), muestra la matriz de asientos actualizada después de la reserva o la anulación. Después, muestra nuevamente el mensaje de bienvenida y las opciones del menú en la consola y espera la siguiente entrada del usuario.
