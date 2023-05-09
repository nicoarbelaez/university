![](https://imgur.com/DTwwCeI.png) ![](https://imgur.com/Erd7DXs.png)

![](https://imgur.com/F7J0Q1r.png)
Conceptos fundamentales de Java 

7-5:  Polimorfismo 

Actividades prácticas 

**Objetivos de la lección:** 

- Aplicar referencias superclase a subclase objetos  
- Redactar un código para sobrescribir métodos 
- Usar el enlace dinámico para soportar el polimorfismo 
- Crear métodos y clases abstract 
- Reconocer el proceso de sobrescritura de método correcto 
- Usar el modificador final 
- Explicar el prototipo y la importancia de la clase Objeto 
- Redactar un código para un applet que muestra dos triángulos de diferentes colores • 	Describir las referencias a objetos 
**


![](Aspose.Words.88160a25-de92-488c-ac4c-f49e7e7181fa.002.jpeg)**Vocabulario:** 
**


Identifique el término correspondiente a cada una de las siguientes definiciones. 

|**Polimorfismo**|Un concepto en la programación orientada por objetos que les permite a las clases tener varias formas y comportarse como sus superclases. |
| :-: | :- |
|**Invalidación de métodos**|Implementar métodos en una subclase que tiene el mismo prototipo (los mismos parámetros, nombre de método, y tipo de retorno) que otro método en la superclase. |
|**Final**|Una palabra clave en Java usada para limitar las subclases a partir de la extensión de una clase, sobrescribiendo métodos o cambiando datos. |
|**Inmutabilidad**|Una propiedad de una clase estática que hace que la clase no pueda ser extendida o que sus datos sean cambiados. |
|**Sobrecarga de métodos**|Implementar un método con el mismo nombre que otro método en la misma clase que tiene diferentes parámetros o un tipo de retorno diferente. |
|**Distribución dinámico**|El proceso por el cual Java es capaz de determinar qué método invocar cuando los métodos han sido sobrescritos. |
|**abstract**|Una palabra clave en Java que permite que las clases sean extendidas, pero las clases no pueden ser instanciadas (construidas)y cuando se aplican los métodos, se indica que los métodos deberían ser implementados en todas las subclases de la clase. |

Copyright © 2020 Oracle y/o sus filiales. Todos los derechos reservados. Oracle y Java son marcas comerciales registradas de Oracle y sus filiales. Todos los demás nombres pueden ser marcas comerciales de sus respectivos propietarios. 



**Inténtelo/resuélvalo:** 

¿Cuál sería el resultado del siguiente código? 



class A  

{ 

`	 	`void callthis() { 

`	 	 	`System.out.println(“Inside Class A's Method!”); 

`	 	`} 

} 



class B extends A  

{ 

`	 	`void callthis() { 

`	 	 	`System.out.println(“Inside Class B's Method!”); 	 	 	 

`	 	`} 

} 



class C extends A 

{ 

`	 	`void callthis() { 

`	 	 	`System.out.println(“Inside Class C's Method!”); 	 	 	 

`	 	`} 

} 



class DynamicDispatch { 

`	 	`public static void main(String args[])  { 

1. a = new A(); 
1. b = new B(); 
1. c = new C(); 

`	 	 	`A ref; 



`	 	 	`ref = b; 

`	 	 	`ref.callthis(); 

` 	 	 	 	 `ref = c; 

`	 	 	`ref.callthis(); 



`	 	 	`ref = a; 

`	 	 	`ref.callthis(); 	 	 	 

`	 	`} 

} 

` `Inside Class B's Method!

Inside Class C's Method!

` `Inside Class A's Method!

2. ¿Cuál es la diferencia entre una clase abstract y una interfaz? ¿Cuándo es apropiado el uso de una clase abstract o una interfaz? 

Una clase abstracta es una clase que puede contener uno o más métodos abstractos, pero también puede tener métodos concretos. Por otro lado, una interfaz es un tipo de clase que solo puede tener métodos abstractos, los cuales actúan como un contrato que cualquier clase que implemente esa interfaz debe cumplir.

La utilización de una clase abstracta es apropiada cuando se desea proporcionar una base común para un conjunto de subclases relacionadas. Es decir, una clase abstracta puede ser utilizada como un modelo para otras clases que desean heredar de ella, pero no se quiere crear instancias directamente de la clase abstracta. Esto asegura que las subclases compartan un conjunto común de métodos y propiedades.

Por otro lado, una interfaz se utiliza cuando se desea tener polimorfismo en el código, desvinculando totalmente la herencia de las clases para evitar que una modificación en una clase padre afecte a sus subclases. Cualquier clase que implemente una interfaz debe implementar todos los métodos abstractos definidos por la interfaz, lo que garantiza una consistencia en el comportamiento de las clases que implementan la interfaz.







Copyright © 2020, Oracle y/o sus filiales. Todos los derechos reservados. Oracle y Java son marcas comerciales registradas de Oracle y/o sus filiales. Todos los demás nombres pueden ser marcas comerciales de sus respectivos propietarios 

2 

2. Dada la siguiente información, determine si resultará: “siempre compila”, “a veces compila”, “no compila”. 

public interface A public class B implements A public abstract class C public class D extends C 

public class E extends B 

Cada clase ha sido inicializada, pero no queda claro para qué han sido inicializadas: 

1. a = new... 
1. b = new... 

C   c = new... 

4. d = new... 
4. e = new... 



Se incluyen los siguientes métodos: 

interfaz A especifica method void methodA() clase C tiene el abstract method void methodC() 



|**Código:** |**¿Siempre compila, a veces compila, no compila?** |
| :-: | :-: |
|a = new B(); |` `Siempre compila|
|d = new C(); |` `No compila|
|b.methodA(); |` `A veces compila|
|e.methodA(); |` `Siempre compila|
|c = new C(); |` `A veces compila|
|(D)c.methodC(); |` `A veces compila|





2. Sobrescribir el método toString() para la clase más abajo para generar los resultados, haciendo coincidir con el resultado dado. El método toString() debería imprimir todos los valores desde 1 al número especificado en num y luego imprimir el valor final usando el método getFactorial provisto. 

`	 	`Suponga que el num int variable es un valor global público: 

`	 	`“Factorial: 10! = 1  \* 2 \*  3 \* 4 \* 5 \* 6 \* 7 \* 8 \* 9 \* 10 = 3628800” 



int getFactorial(){ 

int factorial; 

`	 	 	`for(i = num; num > 0; i--){ 

`	 	 	 	`factorial \*= num; 

`	 	 	`} 	 	 

`	 	 	`return factorial; 

`	 	   `} 

`	 	`public String toString() { 



`	 	`} 



Copyright © 2020, Oracle y/o sus filiales. Todos los derechos reservados. Oracle y Java son marcas comerciales registradas de Oracle y/o sus filiales. Todos los demás nombres pueden ser marcas comerciales de sus respectivos propietarios  
