![](https://imgur.com/DTwwCeI.png) ![](https://imgur.com/Erd7DXs.png)

![](https://imgur.com/F7J0Q1r.png)
Conceptos fundamentales de Java 7-3: Modificador static y clases anidadas

Actividades de práctica

# Objetivos de la lección:

- Crear variables estáticas
- Usar variables estáticas
- Crear métodos estáticos
- Usar métodos estáticos
- Crear clases estáticas
- Utilizar clases estáticas

# Vocabulario:

| **Método de clase estático** | Es un método que se puede utilizar sin crear primero una instancia de la clase. Se declara al anteponer el modificador static a su definición.                                                                                                                                                                                                           |
| :--------------------------: | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|      **Clase interna**       | Es cualquier clase implantada como una clase anidada dentro de otra clase. Por definición, todas las clases internas son miembros de la clase de contenedor por composición.                                                                                                                                                                             |
|    **Variable de clase**     | Cualquier variable de nivel de clase Java que se declara con el modificador static. Esto significa que solo puede existir una instancia de la variable de clase en la JVM,                                                                                                                                                                               |
|                              | independientemente del número de instancias de clase.                                                                                                                                                                                                                                                                                                    |
|          **Static**          | Es una palabra clave que permite que una variable, un método o una clase interna esté disponible sin crear primero una instancia de una variable.                                                                                                                                                                                                        |
|      **Clase anidada**       | Es una clase interna. Las clases internas están definidas dentro de una clase principal o de contenedor y son miembros de la clase de contenedor por composición. De hecho, las clases internas son la única forma en que puede crear instancias de clase mediante composición.                                                                          |
|      **Clase estática**      | Es una clase interna que está disponible para su uso sin crear primero una instancia de la clase de contenedor. Se declara al anteponer el modificador static a su definición.                                                                                                                                                                           |
|     **Método estático**      | Cualquier método de Java definido con un modificador static. Es accesible fuera de la clase cuando se le antepone un especificador de acceso public, protected o default. Es privado e inaccesible fuera de la clase cuando se le antepone un especificador private. Los métodos de clase están disponibles sin crear primero una instancia de la clase. |
|    **Variable estática**     | Es una variable que puede estar disponible fuera de una clase sin crear primero una instancia de una clase. Se declara al anteponer el modificador static al nombre de variable.

# Inténtelo/resuélvalo:
1. Cree clases que se utilicen para comparar el uso de variables static y de instancia.
   - Cree un paquete nuevo denominado "vehicles".
   - Cree e implante la siguiente clase concreta:
      1. Cree una clase denominada "Vehicle".
      1. Cree las variables static de la siguiente forma:
         1. Una variable public static String denominada "MAKE" con un valor "Augur".
         1. Una variable public static int denominada "numVehicles" con un valor inicial 0.
      1. Cree sus variables de instancia de la siguiente forma:
         1. Una variable private String denominada "ChassisNo".
         1. Una variable private String denominada "model".
      1. Cree un constructor que tome un único parámetro formal de tipo String llamado "model". El constructor debe ejecutar las siguientes tareas:
         1. Aumente el valor de la variable static "numVehicles" en uno.
         1. Defina el valor de la variable de instancia "chassisNo" igual a la concatenación de "ch" con el valor que tiene "numVehicles".
         1. Defina la variable de instancia "model" igual al valor del parámetro "model" (indicación: tendrá que utilizar esto aquí).
         1. Haga que el constructor muestre un mensaje que indique "Vehicle manufactured".
      1. Implante dos pares de métodos getter y setter que le permitan obtener y definir los valores de las dos variables de instancia.
   - Cree e implante la siguiente clase de controlador:
      1. Cree una clase denominada "TestVehicle".
      1. Cree un método main estático que pruebe lo siguiente:
         1. El uso del valor de la variable estática "MAKE" crea el siguiente mensaje de salida:
            - `"Manufacturer: Augur"`
         1. El uso del valor de la variable estática "numVehicles" crea el siguiente mensaje de salida:
            - `"Number of vehicles manufactured: "`
      1. Ejecute el programa. Verá que los valores identificados como estáticos se crean en tiempo de ejecución y, por lo tanto, se puede acceder a ellos.
      1. En el método main use la variable "chassisNo" para crear el siguiente mensaje de salida:
         - `"The chassis number is _chassisNo_".`
      1. Ejecute el programa. Verá que el programa no se ejecutará. Esto es porque todavía no hemos creado una instancia (objeto) de la clase Vehicle.
      1. En el método main, cree un objeto vehicle denominado vehicle1 por encima de la sentencia de salida para el número de chasis.
      1. Actualice la sentencia de salida de número de chasis para utilizar la notación de puntos para identificar el chasis del vehículo que queremos ver (utilice vehicle1).
      1. Ejecute el programa. Verá que el programa ahora muestra las variables estáticas y de instancia.
      1. Actualice el código existente para mostrar también el modelo del coche.
      1. Cree un segundo vehículo (denominado "vehicle2", utilice "Edict" como parámetro para el constructor) y visualice las variables de instancia de ese objeto.
      1. Cree un método toString() en la clase Vehicle que mostrará la marca, modelo y número de chasis del vehículo en la pantalla utilizando una línea diferente para cada sentencia de salida.
      1. Visualice el contenido del vehículo en el método main mediante el método toString().
      1. Agregue un método de salida final que muestre el número total de coches fabricados.

**La salida del programa se debe parecer a la siguiente:**
```bash
Manufacturer: Augur
Number of vehicles manufactured: 0
Vehicle manufactured
The vehicle is manufactured by: Augur
The model type is Vision
The chassis number is ch1
Vehicle manufactured
The vehicle is manufactured by: Augur
The model type is Edict
The chassis number is ch2
Number of vehicles manufactured: 2
```

2. Para resaltar el hecho de que las variables estáticas se almacena en un único espacio de memoria al que accede cada instancia de una clase, vamos a corregir el código creado en la pregunta 1.
   1. En el método main, por encima de la línea que muestra el número total de coches fabricados, agregue la siguiente línea de código:
      - `vehicle2.setMake("Seer");`
   
      Estamos utilizando vehicle2 para corregir el valor, pero podríamos utilizar cualquier nombre de instancia.
   1. Agregue dos sentencias de salida bajo esta línea que utilicen el método toString para mostrar el valor de vehicle1 y vehicle2.

**La salida del programa se debe parecer a la siguiente:**
```bash
..
.. ..
The vehicle is manufactured by: Seer
The model type is Vision
The chassis number is ch1
The vehicle is manufactured by: Seer
The model type is Edict
The chassis number is ch2
Number of vehicles manufactured: 2
```

3. Con la solución creada en la pregunta 2, va a crear una clase estática anidada que contendrá los detalles del motor utilizado en el vehículo.
   1. Abra la clase vehicle.
   1. Bajo el método constructor cree una clase public static denominada Engine.
   1. Cree dos variables private static final denominadas MAKE y CAPACITY. Make contendrá texto, mientras que capacity almacenará números enteros.
   1. Los valores que debe asignar a las variables son "Predicter" y "1600"
   1. No cree un constructor para esta clase.
   1. Cree dos public static getters para ambas variables creadas.
   1. Actualice el método toString de la clase Vehicle para mostrar la marca y modelo del motor. Recuerde que Engine es una clase estática.

**La salida del programa para cada vehículo se debe parecer ahora a la siguiente:**
```bash
The vehicle is manufactured by: Seer
The model type is Edict
The chassis number is ch2
The engine make is Predicter
The engine capacity is 1600cc
```

4. Adaptará el código para utilizar una clase estática interior que pueda devolver información de la instancia de su clase de contenedor.
   1. Cambie la declaración Engine para que coincida con lo siguiente:
      - public static class Engine extends Vehicle
   1. Cree un constructor que acepte un parámetro String denominado model.
   1. El constructor debe tener una única instrucción que envíe la variable model al superconstructor.
   1. Vaya a su método main y cree un objeto Engine denominado vehicle3 por encima de la línea de código que muestra el número total de coches fabricados. Para ello, tendrá que seguir estas directrices:
      - Outerclass.InnerClass object name = new Outerclass.InnerClass (parameter);
      - Vehicle.Engine vehicle3 = new Vehicle.Engine("Fortune");
   1. Esto le da acceso a los métodos y los campos de la clase interna, así como a los métodos y los campos en su clase delimitadora. Cree una sentencia de salida que utilice los métodos getter adecuados para mostrar lo siguiente:
      - "Vehicle number ch3 is a Fortune model and has an engine capacity of 1600cc"
   1. Para ver la diferencia entre los diferentes tipos de vehículos, intente crear la sentencia anterior con vehicle1 o vehicle2 (no funciona ya que no tienen acceso a los trabajos internos de la clase estática Engine).