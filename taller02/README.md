![](https://imgur.com/DTwwCeI.png)	![](https://imgur.com/Erd7DXs.png)

![](https://imgur.com/F7J0Q1r.png)

Conceptos fundamentales de Java 4-3: Tipos de datos y operadores Actividades prácticas
# **Objetivos de la lección:**
- Usar tipos de datos primitivos en código Java
- Especificar literales para los tipos primitivos y para las cadenas
- Demostrar cómo inicializar variables
- Describir las reglas de alcance de un método
- Identificar la necesidad de conversión de tipo en una expresión
- Aplicar la conversión en código Java
- Usar operadores aritméticos
- Usar el operador de asignación
- Usar un método de la clase Math
- Acceder a un método de la clase Math de la API de Java

Copyright © 2020 Oracle y/o sus filiales. Todos los derechos reservados. Oracle y Java son marcas comerciales registradas de Oracle y sus filiales. Todos los demás nombres pueden ser marcas comerciales de sus respectivos propietarios.

# Vocabulario

Identifique el término correspondiente a cada una de las definiciones a continuación.

|**Variable y constante**|Mecanismos de almacenamiento de datos primitivos u objetos con nombre definidos en un programa. El valor asignado puede cambiar o no (constantes).|
| :-: | :- |
|**Operador aritmético**|Se utilizan símbolos para sumar, restar, multiplicar y dividir, y aritmética modular en expresiones y fórmulas matemáticas.|
|**Datos primitivos**|Grupo de tipos de datos de Java que no utiliza la palabra clave new cuando se declara o inicializa. Los tipos de datos primitivos almacenan el valor en el mismo lugar de la memoria que el nombre de la variable.|
|**byte**|El tipo primitivo de Java más pequeño (1 byte) que puede contener un valor entero.|
|**long**|Este tipo de dato (8 bytes) es el tipo entero más grande.|
|**Convenciones de programación**|Convenciones de formato y nomenclatura que siguen las mayoría de los programadores.|
|**int**|Este tipo de dato primitivo de Java (4 bytes) puede contener valores enteros.|
|**long**|Este tipo de dato primitivo de Java (8 bytes) es el primitivo más grande que puede contener un valor decimal.|
|**Inicialización**|Cuando se asigna un valor a una variable por primera vez.|
|**float**|Este tipo de dato primitivo de Java (4 bytes) puede inicializarse con un número decimal precediendo a la letra f. Por ejemplo: float x = 3.5f;|
|**Valor inicial**|Puede ser cualquier número, texto o información que represente un valor; se utiliza para inicializar un tipo primitivo.|
|**Declaración de variable**|Sentencia Java cuando se define una variable pero no se le asigna necesariamente un valor. Ejemplo: int x;|
|**Precedencia**|Esta palabra describe la prioridad matemática de una variable en un programa Java.|
|**char**|Este tipo de dato primitivo de Java (2 bytes) puede contener valores de un solo carácter. Ejemplo: “a”, “#”, o “X”|
|**corchetes**|Se utilizan para describir el bloque de código cuando existe una variable en un programa. {} indica la existencia de un bloque de código.|
|**Conversión de tipo**|Proceso de modificar explícitamente un tipo de dato para que se convierta en otro tipo de dato diferente.|
|**Redondeo**|Concepto por el que un número se redondea siempre al entero más cercano.|
|**Asignación**|Signo igual “=” utilizado en una sentencia Java para asignar un valor a una variable.|
|<p>**Conversión de tipo**</p><p></p>|Proceso de modificar un tipo de dato para que se convierta en otro tipo de dato diferente, ya sea este implícito o explícito.|
|<p></p><p>**short**</p>|Tipo de dato primitivo de Java (2 bytes) que contiene números enteros dentro de un rango más corto que int.|
|**boolean**|Tipo primitivo de Java de un bit que puede contener un valor true|

Copyright © 2020, Oracle y/o sus filiales. Todos los derechos reservados. Oracle y Java son marcas comerciales registradas de Oracle y/o sus filiales. Todos los demás nombres pueden ser marcas comerciales de sus respectivos propietarios

# Inténtelo/resuélvalo:
1. Escriba un programa que tome la base y altura de un triángulo y calcule y muestre la superficie de este utilizando la fórmula a continuación.

$$
\begin{align}
A &= \frac{1}{2} bh 
\end{align}
$$

2. Escriba las siguientes fórmulas matemáticas en Java. Tendrá que usar métodos de la clase Math así como una incrustación de métodos y paréntesis para forzar el orden de las operaciones y calcular correctamente la respuesta. Suponga que todas las variables de las fórmulas ya se han declarado e inicializado

$$
\begin{align}
a = \frac{\sqrt{x^5-6}}{4} 
\end{align}
$$

$$
\begin{align}
b = x^y - 6^x
\end{align}
$$

$$
\begin{align}
c = 4\cos(\frac{z}{5}) - \sin(x^2) 
\end{align}
$$

$$
\begin{align}
d = x^4 - \sqrt{6x - y^3}
\end{align}
$$

$$
\begin{align}
e = \frac{1}{y - \frac{1}{x - 2^y}}
\end{align}
$$

$$
\begin{align}
f = 7cos\sqrt{5 - \sin{\sqrt{3x - 4}}}
\end{align}
$$

3. Un autobús lleva 45 personas. El colegio solo utilizará el autobús si puede llenarlo del todo. El resto de personas irá en furgonetas. Escriba un programa que registre el número de personas que se han apuntado para ir de viaje. Haga que el programa muestre el número necesario de autobuses y, después, el número total de personas que tendrá que viajar en furgonetas.


4. Escriba true o false en los espacios en blanco del programa a continuación para mostrar el valor de la variable booleana true_false mientras se ejecuta el programa.

    int i=5; int j=6;

    boolean true_false
    - true_false=(j<5) `false`
    - true_false=(j>3) `true`
    - true_false=(j<i) `false`
    - true_false=(i<5) `false`
    - true_false=(j<=5) `false`
    - true_false=(6<6) `false`
    - true_false=(i!=j) `true`
    - true_false=(i==j || i<50) `true`
    - true_false=(i==j && i<50); `false`
    - true_false=(i>j || true_false && j>=4) `false`
    - true_false=(!(i<2 && j==5)) `true`
    - true_false=!true_false; `false`

5. Explique por qué las declaraciones de la segunda lista son erróneas.

    |boolean gameOver = false;|int 2beOrNot2be;|
    |-|-|
    |int students=50,classes=3;|float price index;|
    |double sales_tax;|double lastYear'sPrice;|
    |short number1;|long class;|

> Las declaraciones de la segunda lista son erróneas por las siguientes razones:
> 
> - **int 2OrNot2; :** los nombres de variables no pueden comenzar con un número, por lo que este nombre no es válido.
> 
> - **float price index; :** el espacio no es un carácter válido en un nombre de variable, por lo que este nombre no es válido. Se podría utilizar un guión bajo en su lugar: float price_index;.
> 
> - **double lastYear'sPrice; :** las comillas simples no son válidas en un nombre de variable, por lo que este nombre no es válido. Se podría utilizar un guión bajo en su lugar: double lastYear_sPrice;.
> 
> - **long class; :** "class" es una palabra clave en Java que se utiliza para definir clases. No se pueden utilizar palabras clave como nombres de variables, por lo que este nombre no es válido. Se podría utilizar un nombre diferente: long classSize;.

6. Explique por qué las declaraciones de la segunda lista no siguen las convenciones para los nombres de variables.

    |int cadence=3, speed=55, gear=4;|int c=3,s=55,g=4;|
    |-|-|
    |final double SALES_TAX=.06;|final double salesTax=.06;|
    |double gearRatio=.5;|double gearratio=.05,Gear=4;|
    |int currentGear=5;|int current_gear;|

> Las declaraciones de la segunda lista no siguen las convenciones para los nombres de variables por las siguientes razones:
> 
> - **int c=3,s=55,g=4; :** los nombres de variables deben ser descriptivos y legibles. Utilizar letras simples como nombres de variables no proporciona información útil sobre su propósito o uso en el programa.
> 
> - **final double salesTax=.06; :** las convenciones de nombres de variables en Java establecen que los nombres deben comenzar con letra minúscula y utilizar la convención CamelCase para separar las palabras. En este caso, el nombre de variable debería ser salesTax en lugar de SALES_TAX.
> 
> - **double gearratio=.05,Gear=4; :** los nombres de variables deben utilizar la convención CamelCase para separar las palabras. Además, Gear debería ser gear para seguir la convención de nombres de variables en Java.
> 
> - **int current_gear; :** las convenciones de nombres de variables en Java establecen que los nombres de variables deben comenzar con letra minúscula y utilizar la convención CamelCase para separar las palabras. En este caso, el nombre de variable debería ser currentGear en lugar de current_gear.

