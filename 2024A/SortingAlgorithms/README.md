# Algoritmos de Ordenamiento

Los algoritmos de ordenamiento son esenciales en informática y se utilizan para organizar elementos en una lista o arreglo en un orden específico. A continuación, presentamos algunos algoritmos comunes junto con sus características:

## 1. **Selection Sort (Ordenamiento por Selección)**

- **Descripción**: Este algoritmo busca el elemento más pequeño y lo coloca en la primera posición, luego busca el siguiente elemento más pequeño y lo coloca en la segunda posición, y así sucesivamente.
- **Pros**:
    - Simple y fácil de implementar.
    - No requiere memoria adicional (in-place).
- **Contras**:
    - Ineficiente para grandes conjuntos de datos.
    - Complejidad temporal: **O(n^2)**.
## 2. **Bubble Sort (Ordenamiento de Burbuja)**

- **Descripción**: Compara elementos adyacentes y los intercambia si están en el orden incorrecto. Continúa haciendo pasadas a través de la lista hasta que esté completamente ordenada.
- **Pros**:
    - Simple y fácil de entender.
    - In-place.
- **Contras**:
    - Ineficiente para grandes conjuntos de datos.
    - Complejidad temporal: **O(n^2)**.

## 3. **Insertion Sort (Ordenamiento por Inserción)**

- **Descripción**: Ordena los elementos uno por uno mientras recorre la lista.
- **Pros**:
    - Eficiente para listas pequeñas.
    - In-place.
- **Contras**:
    - Ineficiente para grandes conjuntos de datos.
    - Complejidad temporal: **O(n^2)**.

## 4. **Merge Sort (Ordenamiento por Combinación)**

- **Descripción**: Divide la lista en mitades, ordena cada mitad por separado y luego combina las mitades ordenadas.
- **Pros**:
    - Eficiente y estable.
    - Complejidad temporal: **O(n log n)**.
- **Contras**:
    - Requiere memoria adicional para la mezcla.

## 5. **Quick Sort (Ordenamiento Rápido)**

- **Descripción**: Divide la lista en dos partes, los elementos más pequeños y los más grandes, y luego ordena recursivamente cada parte.
- **Pros**:
    - Rápido y ampliamente utilizado.
    - Complejidad temporal: **O(n log n)** en promedio.
- **Contras**:
    - No es estable.
    - Peor caso: **O(n^2)**.

## 6. **Heap Sort (Ordenamiento por Montón)**

- **Descripción**: Utiliza una estructura de datos llamada "montón" para organizar los elementos.
- **Pros**:
    - Complejidad temporal: **O(n log n)**.
    - In-place.
- **Contras**:
    - No es estable.

## 7. **Counting Sort (Ordenamiento por Conteo)**

- **Descripción**: Ideal para datos con un rango limitado de valores. Cuenta cuántas veces aparece cada valor y luego construye la lista ordenada.
- **Pros**:
    - Complejidad temporal: **O(n + k)**, donde k es el rango de valores.
- **Contras**:
    - Requiere espacio adicional para el conteo.

## 8. **Radix Sort (Ordenamiento por Raíz)**

- **Descripción**: Ordena los elementos basándose en sus dígitos, desde el dígito menos significativo hasta el más significativo.
- **Pros**:
    - Eficiente para números enteros.
    - Complejidad temporal: **O(nk)**, donde k es el número de dígitos.
- **Contras**:
    - No es estable.

## 9. **Bucket Sort (Ordenamiento por Cubos)**

- **Descripción**: Divide la lista en "cubos" y luego ordena cada cubo individualmente.
- **Pros**:
    - Eficiente para datos distribuidos uniformemente.
    - Complejidad temporal: **O(n^2)** en el peor caso.
- **Contras**:
    - Requiere espacio adicional para los cubos.
