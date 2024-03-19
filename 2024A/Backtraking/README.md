# Backtracking: Explorando Soluciones de Manera Eficiente

## ¿Qué es el Backtracking?

El **backtracking** es una técnica de búsqueda que se utiliza para resolver problemas de decisión y explorar todas las posibles soluciones. Funciona de la siguiente manera:

1. Se toma una decisión inicial.
2. Se avanza en la solución hasta que se llega a un punto en el que no se puede continuar sin violar alguna restricción.
3. Se retrocede (backtrack) y se toma una decisión diferente.
4. Se repite el proceso hasta encontrar una solución válida o agotar todas las posibilidades.

## ¿Por qué se Creó el Backtracking?

El backtracking se creó para abordar problemas en los que se deben explorar exhaustivamente todas las opciones posibles. Algunos ejemplos incluyen:

- **Sudoku**: Resolver un tablero de Sudoku requiere probar diferentes números en las casillas hasta encontrar una combinación válida.
- **Problema de la Mochila (Knapsack)**: Seleccionar objetos con valores y pesos para maximizar el valor total sin exceder la capacidad de una mochila.
- **Generación de Permutaciones**: Encontrar todas las formas posibles de ordenar un conjunto de elementos.

## Índice

1. [Backtracking en el Juego de Sudoku](#backtracking-en-el-juego-de-sudoku)
2. [Problema de la Mochila (Knapsack Problem)](#problema-de-la-mochila-knapsack-problem)
3. [Enumeración de Combinaciones usando Generación de Permutaciones](#enumeración-de-combinaciones-usando-generación-de-permutaciones)

# Backtracking en el Juego de Sudoku

## ¿Qué es el Backtracking en la toma de decisiones?

El backtracking es un algoritmo de búsqueda que se utiliza para resolver problemas de decisión, especialmente aquellos en los que se deben explorar todas las posibles soluciones. Funciona de la siguiente manera:

1. Se toma una decisión inicial.
2. Se avanza en la solución hasta que se llega a un punto en el que no se puede continuar sin violar alguna restricción.
3. Se retrocede (backtrack) y se toma una decisión diferente.
4. Se repite el proceso hasta encontrar una solución válida o agotar todas las posibilidades.

## ¿Qué es el Sudoku?

El Sudoku es un juego de lógica numérica en el que se debe completar una cuadrícula de 9x9 casillas dividida en subcuadrículas de 3x3. El objetivo es rellenar todas las casillas con números del 1 al 9, de manera que no se repitan en ninguna fila, columna o subcuadrícula.

## Backtracking en el Sudoku

El backtracking es una técnica comúnmente utilizada para resolver Sudokus. Aquí está cómo se aplica:

1. Se comienza con una cuadrícula parcialmente rellenada (con algunos números ya colocados).
2. Se intenta colocar un número en una casilla vacía.
3. Si el número no viola ninguna regla (no se repite en la fila, columna o subcuadrícula), se avanza a la siguiente casilla.
4. Si el número viola alguna regla, se retrocede (backtrack) y se prueba con otro número.
5. Se repite el proceso hasta llenar todas las casillas o hasta agotar todas las posibilidades.

El backtracking garantiza que se explore todas las combinaciones posibles y encuentra una solución válida si existe.

## Implementación en Java

Para implementar el backtracking en el Sudoku en Java, puedes seguir estos pasos:

1. Define una matriz de 9x9 para representar el tablero del Sudoku.
2. Escribe una función recursiva que intente colocar un número en una casilla vacía.
3. Verifica si el número cumple con las reglas del Sudoku (no se repite en la fila, columna o subcuadrícula).
4. Si es válido, avanza a la siguiente casilla y llama recursivamente a la función.
5. Si no es válido, retrocede (backtrack) y prueba con otro número.
6. Repite el proceso hasta llenar todo el tablero o hasta agotar todas las posibilidades.

# Problema de la Mochila (Knapsack Problem)

## ¿Qué es el Problema de la Mochila?

El **Problema de la Mochila** es un desafío clásico en optimización combinatoria. Imagina que tienes una mochila con una capacidad máxima y una serie de objetos, cada uno con un valor y un peso. El objetivo es seleccionar un subconjunto de objetos que maximice el valor total sin exceder la capacidad de la mochila.

## Ejemplo Gráfico

Supongamos que tenemos una mochila con una capacidad de **850 unidades**. A continuación, se muestra una representación gráfica de algunos objetos que queremos empacar:

- Objeto 1: Valor = 360, Peso = 7
- Objeto 2: Valor = 83, Peso = 0
- Objeto 3: Valor = 59, Peso = 30
- ...
- Objeto 50: Valor = 312, Peso = 65

Nuestro objetivo es seleccionar un subconjunto de estos objetos para maximizar el valor total sin exceder la capacidad de la mochila.

## Implementación en Java

Para resolver el Problema de la Mochila en Java, puedes seguir estos pasos:

1. Define un vector con los valores de los objetos.
2. Define otro vector con los pesos de los objetos.
3. Declara un solucionador especializado para problemas de la mochila.
4. Utiliza el algoritmo de ramificación y acotación (branch and bound) para encontrar la solución óptima.

# Enumeración de Combinaciones usando Generación de Permutaciones

## ¿Qué es una Permutación?

Las permutaciones se refieren a la acción de organizar a todos los miembros de un conjunto en algún tipo de orden o secuencia. En otras palabras, permutar significa reorganizar los elementos de un conjunto. En las permutaciones, el **orden de los elementos sí importa**. Por ejemplo, si nuestra contraseña es "1234" y alguien ingresa los números "3241", la contraseña será incorrecta, ya que los mismos números están presentes pero en un orden diferente. Así, "3421" es una permutación de "1234".

Ejemplo de permutaciones para el conjunto {1, 2, 3, 4}:

- 4321, 4312, 4123, 4132, 4213, 4231
- 3412, 3421, 3214, 3241, 3124, 3142
- 2413, 2431, 2314, 2341, 2134, 2143
- 1432, 1423, 1324, 1342, 1234, 1243

## ¿Qué es una Combinación?

En contraste, una combinación se relaciona con la acción de organizar los elementos de una colección de modo que **el orden de la selección no importa**. Por ejemplo, escoger un equipo de 3 personas de un grupo de 20 personas es una combinación. En este caso, el orden en que seleccionamos a las personas no afecta el resultado.

Ejemplo de combinaciones para el conjunto {1, 2, 3, 4, 5} al escoger 3 elementos:

- 123, 234, 345, 124, 125
- 134, 145, 135, 235, 245

## Fórmulas para Permutaciones y Combinaciones

Las fórmulas básicas son:

1. **Permutaciones (sin repetición):**

   - Si tenemos una colección de n objetos y queremos escoger r de ellos:
     \[ _{n}P_{r} = \frac{n!}{(n-r)!} \]

2. **Combinaciones (sin repetición):**
   - Si no queremos considerar las diferentes permutaciones de los elementos, dividimos la expresión de las permutaciones por el número de permutaciones de r (que es r!):
     \[ _{n}C_{r} = \frac{_{n}P_{r}}{r!} = \frac{n!}{(n-r)!r!} \]

## Implementación en Java

Para generar todas las permutaciones posibles en Java, puedes utilizar algoritmos de generación de permutaciones. Estos algoritmos exploran todas las combinaciones posibles y generan las permutaciones sin repetición.
