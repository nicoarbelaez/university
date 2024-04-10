# Pseudocódigo para encontrar el número en el juego de Toros y vacas

# Inicializa una lista de arreglos de todas las combinaciones posibles de X dígitos (Pueden empezar con 0)
posibles_numeros = generar_todas_las_combinaciones_posibles()

# Repite hasta que se encuentre el número secreto:
mientras Verdadero:
    # Obtén la cantidad de toros y vacas para la propuesta
    toros, vacas = obtener_toros_y_vacas(propuesta, numero_secreto)

    # Actualiza la lista de posibles números según los toros y vacas
    posibles_numeros = filtrar_posibles_numeros(posibles_numeros, propuesta, toros, vacas)

    # Si solo queda un número posible, es el número secreto
    si len(posibles_numeros) == 1:
        numero_secreto = posibles_numeros[0]
        rompe

# Imprime el número secreto
imprimir("El número secreto es:", numero_secreto)

# Si nos quedamos sin conbinaciones posibles, mostramos al usuario todos los numeros que uso, debera selecionar el primer numero en el cual se equivoco y editarlo con la informacion correcta, y volver a generar la lista de numeros posibles mientras filtro con los numero que fueron anterior al error