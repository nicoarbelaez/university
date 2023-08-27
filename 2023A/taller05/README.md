# Videos sobre Programación Orientada a Objetos (POO)

## 1. Introducción a POO
En este video (https://www.youtube.com/watch?v=ZY5pwm92cWQ&t=110s), se explica el vocabulario básico de la Programación Orientada a Objetos, como las clases y los objetos, así como su relación y diferencias. Además, se muestran ejemplos de cómo se puede utilizar la POO para modelar problemas y resolverlos de manera más sencilla.

## 2. Modulación y encapsulamiento
En el segundo video (https://www.youtube.com/watch?v=RZOSJ2zuxIs&t=397s), se profundiza en dos conceptos claves de la POO: la modulación y el encapsulamiento. Se explica cómo se pueden dividir los problemas en módulos más pequeños y cómo estos módulos se relacionan entre sí a través de interfaces. Además, se muestra cómo el encapsulamiento permite ocultar la complejidad interna de los objetos y ofrecer una interfaz más simple y clara para su uso.

## 3. Getter y setters
Por último, en el tercer video (https://www.youtube.com/watch?v=7ALMZymOs_s&t=784s), se habla sobre los getter y setters, métodos que se utilizan para acceder y modificar los atributos de un objeto desde fuera de la clase. Se explica por qué es importante utilizar estos métodos en lugar de acceder directamente a los atributos y se muestra cómo se implementan en Java.

## Análisis del código
El código que se presenta consta de dos archivos: Main.java y Coche.java. El primero es el archivo principal que contiene el método main, mientras que el segundo es una clase que representa un coche y que se utiliza en el método main.

En la clase Coche se definen varios atributos privados, como el número de ruedas, la longitud, el ancho, el motor, el peso y el color del coche. También se define un constructor que inicializa algunos de estos atributos con valores por defecto. Además, se definen dos métodos públicos para acceder a dos de los atributos: el número de ruedas y el color del coche.

En el método main se crea un objeto de la clase Coche llamado myCar. A continuación, se utiliza el método setColor para establecer el color del coche en "blue". Finalmente, se utilizan los métodos getColor y getNumWheels para obtener la información del color del coche y del número de ruedas, respectivamente, y se muestran por pantalla utilizando el método println.

___Main.java___
```java
import poo.Coche;

public class Main {
	public static void main(String[] args) {
		Coche myCar = new Coche();
		
		myCar.setColor("blue");

		System.out.println(myCar.getColor());
		System.out.println("This car has " + myCar.getNumWheels() + " wheels");
	}
}

```
___Coche.java___
```java
package poo;

public class Coche {
    private int numWheels;
    private int length;
    private int width;
    private int engine;
    private int weight;
    private String color;

    public Coche() {
        numWheels = 4;
        length = 2000;
        width = 300;
        engine = 1600;
        weight = 500;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public String getLenght(){
        return "The length of the car is " + length + " cm";
    }

    public void setColor(String colorCoche){
        color = colorCoche;
    }

    public String getColor(){
        return "The color of the car is " + color;
    }

}

```

___Consola___
```bash
The color of the car is blue
This car has 4 wheels
```
