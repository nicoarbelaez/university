# Ingeniería de Software ejercicios (SQL)

## Base de datos:

### 1. Tabla de Proveedores (`PROVEEDORES`)

| id_prov | razon_social          | direccion         | nit       | ciudad | estado |
| ------: | --------------------- | ----------------- | --------- | ------ | ------ |
|   12345 | Universidad el bosque | cra 10 # 34-54    | 890098743 | Bogota | Activo |
|   12346 | USC                   | calle 34 #5-4a-50 | 890097644 | Cali   | Activo |
|   12347 | Universidad libre     | diagonal 3 #3n-67 | 890012345 | Cali   | Activo |
|   12348 | Universidad del valle | cra 100 # 3-45    | 890098420 | Cali   | Activo |

### 2. Tabla de Artículos (`ARTICULOS`)

| id_articulo | codigo  | unidad_medida |     categoria      | peso | estado |
| ----------: | :-----: | :-----------: | :----------------: | ---: | :----: |
|       98765 | EAM4356 |    Unidad     |     SERVICIOS      |    3 | Activo |
|       98766 | EAM4357 |    Metros     |     SERVICIOS      |    5 | Activo |
|       98767 | EAM4358 |    Unidad     | PRODUCTO TERMINADO |    7 | Activo |
|       98768 | EAM4359 |    Metros     | PRODUCTO TERMINADO |    6 | Activo |
|       98769 | EAM4360 |     kilo      |   MATERIA PRIMA    |    3 | Activo |
|       98770 | EAM4361 |     kilo      |   MATERIA PRIMA    |    2 | Activo |
|       98771 | EAM4362 |     kilo      |     SERVICIOS      |    1 | Activo |

### 3. Tabla de Órdenes de Compra (`ORDENES_COMPRA`)

| id_oc | numero_oc | fecha_creacion | id_proveedor | id_pago | moneda |
| ----: | :-------: | :------------: | -----------: | ------: | :----: |
| 56789 | 96101112  |    2-ene-17    |        12345 |     123 |  COP   |
| 56781 | 96101113  |   23-ene-17    |        12346 |     124 |  COP   |
| 56782 | 96101114  |    3-feb-17    |        12347 |     125 |  COP   |
| 56783 | 96101115  |   15-feb-17    |        12348 |     126 |  USD   |
| 56784 | 96101116  |   30-abr-17    |        12345 |     127 |  USD   |
| 56785 | 96101117  |    1-may-17    |        12346 |     128 |  USD   |
| 56786 | 96101118  |   30-may-17    |        12348 |     129 |  COP   |

### 4. Tabla de Líneas de Órdenes (`LINEAS_ORDENES`)

| id_linea_oc | id_oc | numero_linea | id_art | cantidad | precio |
| ----------: | ----: | -----------: | -----: | -------: | -----: |
|       98765 | 56789 |            1 |  98765 |      100 |   1200 |
|       98766 | 56789 |            2 |  98766 |       30 |   1380 |
|       98767 | 56789 |            3 |  98767 |       50 |   4500 |
|       98768 | 56781 |            1 |  98768 |       10 |    900 |
|       98769 | 56781 |            2 |  98765 |       87 |   2000 |
|       98770 | 56781 |            3 |  98769 |       43 |   1230 |
|       98771 | 56782 |            1 |  98765 |       28 |   4350 |
|       98772 | 56783 |            1 |  98770 |       22 |   6000 |
|       98773 | 56784 |            1 |  98771 |      100 |   1200 |
|       98774 | 56784 |            2 |  98770 |       98 |   4900 |
|       98775 | 56784 |            3 |  98769 |       10 |   1234 |
|       98776 | 56785 |            1 |  98767 |       44 |   3450 |
|       98777 | 56785 |            2 |  98768 |       55 |   4500 |
|       98778 | 56786 |            1 |  98765 |       32 |   3290 |
|       98779 | 56786 |            2 |  98766 |       20 |   8000 |

### 5. Tabla de Pagos (`PAGOS`)

| id_pago | Numero_pago | valor_pago | fecha_pago |
| ------: | :---------: | ---------: | :--------: |
|     123 |   PAG-01    |     386640 | 12-ene-17  |
|     124 |   PAG-02    |     235890 | 27-ene-17  |
|     125 |   PAG-03    |     121800 | 23-feb-17  |
|     126 |   PAG-04    |     132000 | 25-feb-17  |
|     127 |   PAG-05    |     612540 | 30-abr-17  |
|     128 |   PAG-06    |     399300 | 10-may-17  |
|     129 |   PAG-07    |     265280 | 31-may-17  |

# Ejercicios de SQL Oracle Apex

## Tema 1: Uniones (JOINs y combinaciones complejas con subconsultas)

### Ejercicio 1

**Enunciado:**  
Un ejecutivo requiere un resumen consolidado de todas las órdenes de compra. La consulta debe mostrar:

- Número de Orden (numero_oc)
- Fecha de Creación
- Razón Social del Proveedor
- Total de la Orden (calculado como la sumatoria de _cantidad_ multiplicada por _precio_ de cada línea, mediante subconsulta)
- Número del Pago asociado

**Tabla de resultado esperada:**

| Numero_OC | Fecha_Creacion | Razon_Social          | Total_Orden | Numero_Pago |
| --------- | -------------- | --------------------- | ----------- | ----------- |
| 96101112  | 2-ene-17       | Universidad el bosque | 386400      | PAG-01      |
| 96101113  | 23-ene-17      | USC                   | 235890      | PAG-02      |
| 96101114  | 3-feb-17       | Universidad libre     | 121800      | PAG-03      |
| 96101115  | 15-feb-17      | Universidad del valle | 132000      | PAG-04      |
| 96101116  | 30-abr-17      | Universidad el bosque | 612540      | PAG-05      |
| 96101117  | 1-may-17       | USC                   | 399300      | PAG-06      |
| 96101118  | 30-may-17      | Universidad del valle | 265280      | PAG-07      |

---

### Ejercicio 2

**Enunciado:**  
El ejecutivo desea obtener la información de las órdenes de compra en moneda **USD** junto con el detalle de los artículos comprados. Se requiere mostrar:

- Número de Orden
- Razón Social del Proveedor
- Código del Artículo
- Categoría del Artículo
- Cantidad adquirida

**Tabla de resultado esperada:**

| Numero_OC | Razon_Social          | Codigo  | Categoria          | Cantidad |
| --------- | --------------------- | ------- | ------------------ | -------- |
| 96101115  | Universidad del valle | EAM4361 | MATERIA PRIMA      | 22       |
| 96101116  | Universidad el bosque | EAM4362 | SERVICIOS          | 100      |
| 96101116  | Universidad el bosque | EAM4361 | MATERIA PRIMA      | 98       |
| 96101116  | Universidad el bosque | EAM4360 | MATERIA PRIMA      | 10       |
| 96101117  | USC                   | EAM4358 | PRODUCTO TERMINADO | 44       |
| 96101117  | USC                   | EAM4359 | PRODUCTO TERMINADO | 55       |

---

### Ejercicio 3

**Enunciado:**  
Se requiere listar los proveedores que hayan realizado órdenes de compra cuyo total supere el promedio de todas las órdenes. Se debe mostrar:

- Razón Social del Proveedor
- Número de Orden
- Total de la Orden

**Tabla de resultado esperada:**

| Razon_Social          | Numero_OC | Total_Orden |
| --------------------- | --------- | ----------- |
| Universidad el bosque | 96101112  | 386400      |
| Universidad el bosque | 96101116  | 612540      |
| USC                   | 96101117  | 399300      |

---

### Ejercicio 4

**Enunciado:**  
El ejecutivo solicita un reporte comparativo de ventas por proveedor. Se requiere mostrar:

- Razón Social
- Número total de órdenes realizadas
- Total acumulado de ventas (sumatoria de _cantidad_ x _precio_)
- Promedio de venta por orden

**Tabla de resultado esperada:**

| Razon_Social          | Total_Ordenes | Total_Ventas | Promedio_Venta |
| --------------------- | ------------- | ------------ | -------------- |
| Universidad el bosque | 2             | 998940       | 499470         |
| USC                   | 2             | 635190       | 317595         |
| Universidad libre     | 1             | 121800       | 121800         |
| Universidad del valle | 2             | 397280       | 198640         |

**Posible solución:**

---

## Tema 2: Vistas Virtuales y Materializadas

### Ejercicio 1

**Enunciado:**  
Crear una vista virtual llamada `V_Ventas_Resumen` que consolide la información de cada orden de compra. La vista deberá mostrar:

- Número de Orden
- Fecha de Creación
- Razón Social del Proveedor
- Total de la Orden
- Número del Pago

**Tabla de resultado esperada:**

| Numero_OC | Fecha_Creacion | Razon_Social          | Total_Orden | Numero_Pago |
| --------- | -------------- | --------------------- | ----------- | ----------- |
| 96101112  | 2-ene-17       | Universidad el bosque | 386400      | PAG-01      |
| 96101113  | 23-ene-17      | USC                   | 235890      | PAG-02      |
| 96101114  | 3-feb-17       | Universidad libre     | 121800      | PAG-03      |
| 96101115  | 15-feb-17      | Universidad del valle | 132000      | PAG-04      |
| 96101116  | 30-abr-17      | Universidad el bosque | 612540      | PAG-05      |
| 96101117  | 1-may-17       | USC                   | 399300      | PAG-06      |
| 96101118  | 30-may-17      | Universidad del valle | 265280      | PAG-07      |

**Posible solución:**

---

### Ejercicio 2

**Enunciado:**  
Crear una vista virtual llamada `V_Proveedor_Ventas` que muestre, para cada proveedor:

- Razón Social
- Ciudad
- Número de Órdenes realizadas
- Total acumulado de Ventas

**Tabla de resultado esperada:**

| Razon_Social          | Ciudad | Ordenes | Total_Ventas |
| --------------------- | ------ | ------- | ------------ |
| Universidad el bosque | Bogota | 2       | 998940       |
| USC                   | Cali   | 2       | 635190       |
| Universidad libre     | Cali   | 1       | 121800       |
| Universidad del valle | Cali   | 2       | 397280       |

**Posible solución:**

---

### Ejercicio 3

**Enunciado:**  
Crear una vista materializada llamada `MV_Ventas_Detalle` que almacene el detalle de cada línea de orden de compra. La vista debe incluir:

- Número de Orden
- Número de Línea
- Código del Artículo
- Categoría
- Cantidad
- Precio
- Total Línea (Cantidad \* Precio)

**Tabla de resultado esperada:**

| Numero_OC | Numero_Linea | Codigo  | Categoria          | Cantidad | Precio | Total_Linea |
| --------- | ------------ | ------- | ------------------ | -------- | ------ | ----------- |
| 96101112  | 1            | EAM4356 | SERVICIOS          | 100      | 1200   | 120000      |
| 96101112  | 2            | EAM4357 | SERVICIOS          | 30       | 1380   | 41400       |
| 96101112  | 3            | EAM4358 | PRODUCTO TERMINADO | 50       | 4500   | 225000      |
| 96101113  | 1            | EAM4359 | PRODUCTO TERMINADO | 10       | 900    | 9000        |
| 96101113  | 2            | EAM4356 | SERVICIOS          | 87       | 2000   | 174000      |
| 96101113  | 3            | EAM4360 | MATERIA PRIMA      | 43       | 1230   | 52890       |
| 96101114  | 1            | EAM4356 | SERVICIOS          | 28       | 4350   | 121800      |
| 96101115  | 1            | EAM4361 | MATERIA PRIMA      | 22       | 6000   | 132000      |
| 96101116  | 1            | EAM4362 | SERVICIOS          | 100      | 1200   | 120000      |
| 96101116  | 2            | EAM4361 | MATERIA PRIMA      | 98       | 4900   | 480200      |
| 96101116  | 3            | EAM4360 | MATERIA PRIMA      | 10       | 1234   | 12340       |
| 96101117  | 1            | EAM4358 | PRODUCTO TERMINADO | 44       | 3450   | 151800      |
| 96101117  | 2            | EAM4359 | PRODUCTO TERMINADO | 55       | 4500   | 247500      |
| 96101118  | 1            | EAM4356 | SERVICIOS          | 32       | 3290   | 105280      |
| 96101118  | 2            | EAM4357 | SERVICIOS          | 20       | 8000   | 160000      |

**Posible solución:**

---

### Ejercicio 4

**Enunciado:**  
Crear una vista materializada llamada `MV_Articulos_Stock` que muestre los artículos disponibles, agrupando por categoría. Para cada artículo se debe mostrar:

- Código
- Categoría
- Total de líneas en las órdenes de compra donde se vendió el artículo
- Total de cantidad vendida

**Tabla de resultado esperada:**

| Codigo  | Categoria          | Total_Lineas | Total_Cantidad |
| ------- | ------------------ | ------------ | -------------- |
| EAM4356 | SERVICIOS          | 4            | 247            |
| EAM4357 | SERVICIOS          | 2            | 50             |
| EAM4358 | PRODUCTO TERMINADO | 2            | 94             |
| EAM4359 | PRODUCTO TERMINADO | 2            | 65             |
| EAM4360 | MATERIA PRIMA      | 2            | 53             |
| EAM4361 | MATERIA PRIMA      | 2            | 120            |
| EAM4362 | SERVICIOS          | 1            | 100            |

**Posible solución:**

---

## Tema 3: Funciones

### Ejercicio 1

**Enunciado:**  
Crear una función llamada `FN_TOTAL_ORDEN` que reciba como parámetro el _id_ de una orden de compra y retorne el total de la orden, calculado como la sumatoria de (_cantidad_ x _precio_) de cada línea.

**Tabla de resultado esperada (ejecución de la función):**

| id_oc | Total_Orden |
| ----- | ----------- |
| 56789 | 386400      |

**Posible solución:**

---

### Ejercicio 2

**Enunciado:**  
Crear una función que determine el estado de un proveedor basado en su total acumulado de ventas. La función recibirá el _id_proveedor_ y retornará:

- **'Alto'** si el total es mayor a 600000
- **'Medio'** si el total está entre 300000 y 600000
- **'Bajo'** si el total es inferior a 300000

**Tabla de resultado esperada (ejecución de la función):**

| id_prov | Estado_Ventas |
| ------- | ------------- |
| 12345   | Alto          |

**Posible solución:**

---

### Ejercicio 3

**Enunciado:**  
Crear una función que reciba una fecha como parámetro y retorne el número de días transcurridos desde esa fecha hasta la fecha actual.

**Tabla de resultado esperada (ejecución de la función):**

| Fecha_Inicial | Dias_Transcurridos |
| ------------- | ------------------ |
| 2-ene-17      | 364                |

**Posible solución:**

---

### Ejercicio 4

**Enunciado:**  
Crear una función que, dada la categoría de un artículo, retorne el total acumulado de ventas para todos los artículos de dicha categoría. El cálculo se hará sumando la cantidad vendida.

**Tabla de resultado esperada (ejecución de la función):**

| Categoria | Total_Ventas |
| --------- | ------------ |
| SERVICIOS | 397          |

**Posible solución:**

---

## Tema 4: Índices

### Ejercicio 1

**Enunciado:**  
Crear un índice sobre la columna `nit` de la tabla **PROVEEDORES** para optimizar las consultas que filtren por este campo.

**Tabla de resultado esperada:**

| Objeto              | Descripción                                           |
| ------------------- | ----------------------------------------------------- |
| IDX_PROVEEDORES_NIT | Índice sobre la columna `nit` de la tabla PROVEEDORES |

**Posible solución:**

---

### Ejercicio 2

**Enunciado:**  
Crear un índice compuesto sobre las columnas `fecha_creacion` y `moneda` de la tabla **ORDENES_COMPRA** para mejorar el rendimiento de las consultas que filtran por estas columnas.

**Tabla de resultado esperada:**

| Objeto              | Descripción                                                                   |
| ------------------- | ----------------------------------------------------------------------------- |
| IDX_OC_FECHA_MONEDA | Índice compuesto sobre `fecha_creacion` y `moneda` en la tabla ORDENES_COMPRA |

**Posible solución:**

---

### Ejercicio 3

**Enunciado:**  
Crear un índice en la tabla **LINEAS_ORDENES** sobre la columna `id_art` para acelerar las consultas que realicen operaciones con la tabla **ARTICULOS**.

**Tabla de resultado esperada:**

| Objeto                   | Descripción                                                 |
| ------------------------ | ----------------------------------------------------------- |
| IDX_LINEAS_ORDENES_IDART | Índice sobre la columna `id_art` de la tabla LINEAS_ORDENES |

**Posible solución:**

---

### Ejercicio 4

**Enunciado:**  
Evaluar el impacto de los índices en el rendimiento de una consulta que une las tablas **ORDENES_COMPRA** y **PAGOS** mediante la columna `id_pago`. Se requiere comparar el tiempo de ejecución sin índice y con índice.

**Tabla de resultado esperada:**

| Consulta                                | Tiempo_Sin_Indice | Tiempo_Con_Indice | Mejora |
| --------------------------------------- | ----------------- | ----------------- | ------ |
| JOIN ORDENES_COMPRA y PAGOS por id_pago | 120 ms            | 80 ms             | 33.3%  |

---

## Tema 5: Triggers

### Ejercicio 1

**Enunciado:**  
Crear un trigger que, tras la inserción de una nueva línea en la tabla **LINEAS_ORDENES**, actualice automáticamente el campo `TOTAL_ORDEN` en la tabla **ORDENES_COMPRA** con la sumatoria actualizada de (_cantidad_ x _precio_).

**Tabla de resultado esperada:**

| Numero_OC | Total_Orden |
| --------- | ----------- |
| 96101112  | 387400      |

---

### Ejercicio 2

**Enunciado:**  
Crear un trigger que impida la eliminación de un proveedor si existen órdenes de compra asociadas.

**Tabla de resultado esperada:**

| Acción                        | Resultado                                                   |
| ----------------------------- | ----------------------------------------------------------- |
| Intento de eliminar proveedor | Operación rechazada: Existen órdenes asociadas al proveedor |

---

### Ejercicio 3

**Enunciado:**  
Crear un trigger que, antes de actualizar el estado de un pago, registre en una tabla de auditoría (por ejemplo, `AUDITORIA_PAGOS`) el `id_pago`, el valor anterior y el nuevo valor, junto con la fecha de modificación.

**Tabla de resultado esperada (registro en auditoría):**

| id_pago | Valor_Anterior | Valor_Nuevo | Fecha_Modificacion |
| ------- | -------------- | ----------- | ------------------ |
| 123     | 386640         | 400000      | 202X-XX-XX         |

**Posible solución:**

---

### Ejercicio 4

**Enunciado:**  
Crear un trigger que, al actualizar el precio de un artículo, verifique que el nuevo precio sea mayor que 0. Si el valor es menor o igual a 0, la actualización debe ser rechazada.

**Tabla de resultado esperada:**

| Acción                        | Resultado                            |
| ----------------------------- | ------------------------------------ |
| Actualización de precio a -50 | Operación rechazada: Precio inválido |

