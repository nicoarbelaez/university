![](https://imgur.com/DTwwCeI.png) ![](https://imgur.com/Erd7DXs.png)

![](https://imgur.com/F7J0Q1r.png)

Conceptos fundamentales de Java 4-4: Strings

Actividades prácticas

# Objetivos

- Instanciar (crear) una cadena
- Describir lo que ocurre cuando se modifica una cadena
- Usar los operadores + y += para concatenar cadenas
- Interpretar secuencias de escape en literales de cadena
- Identificar las diferencias entre una cadena y un tipo de dato primitivo char
- Comprobar cadenas con el método compareTo() y equals()
- Describir por qué el operador == no siempre funciona al probar la igualdad de la cadena
- Usar los métodos de cadena length(), substring(), indexOf() y charAt()

# Vocabulario:

Identifique el término correspondiente a cada una de las definiciones a continuación.

|        **Concatenar**        | Unir múltiples objetos de cadena.                                                                                                                                             |
| :--------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|   **Caracteres de escape**   | Caracteres específicos precedidos de \. En el momento de la evaluación, el carácter especial se evalúa como función especial, es decir, como separadores, nuevas líneas, etc. |
| **Inicialización de cadena** | Asignar un valor a una referencia de objeto de cadena.                                                                                                                        |
|   **Referencia de objeto**   | Tipo de dato que hace referencia a la ubicación de la memoria donde se almacena un objeto en lugar de un valor único y específico.                                            |
|    **Métodos de cadena**     | Código disponible en la API de Java para manipular o devolver cadenas.                                                                                                        |
|          **String**          | Tipo de objeto que almacena frases, palabras o varios caracteres.                                                                                                             |

# Inténtelo/resuélvalo:

1. Escriba tres formas diferentes de declarar e instanciar un objeto de cadena llamado “myString” que contenga “abc”.

```java
String myString  = new String(“abc”);
```

```java
String myString  = “abc”;
```

```java
String myString;
myString = "abc";
```

2. ¿Qué devolverá cada uno de los tres objetos de cadena que se muestran a continuación?

```java
String s1 =“ABC”;
String s2 = new String(“DEF”);
String s3 = “AB” + “C”;
```

- s1.compareTo(s2); `-3 `
- s2.equals(s3); `false`
- s3 == s1; `true`
- s2.compareTo(s3); `3`
- s3.equals(s1); `true`

3. Declare e instancie dos objetos de cadena independientes; a continuación, concaténelos y asígneles un tercer objeto de cadena arbitrario.

```java
public static void puntoTres() {
    String string1 = "ABC";
    String string2 = "def";
    
    String string3 = string1.concat(string2);
    System.out.println("String: " + string3);
}
```
