from timeit import default_timer
from os import system
import random

def generar_numeros(cantidad = 1):
    lista = []
    for i in range(cantidad):
        while True:
            numero_random = random.randint(0, cantidad * cantidad // 2)
            if numero_random not in lista:
                lista.append(numero_random)
                break
    return lista

def ordenar_mezcla(lista):
    nueva_lista = lista
    if len(nueva_lista) > 1:
        mitad = len(nueva_lista) // 2
        primera_mitad = nueva_lista[:mitad]
        segunda_mitad = nueva_lista[mitad:]

        ordenar_mezcla(primera_mitad)
        ordenar_mezcla(segunda_mitad)
        i, j ,k = 0, 0, 0

        while i < len(primera_mitad) and j < len(segunda_mitad):
            if primera_mitad[i] < segunda_mitad[j]:
                nueva_lista[k] = primera_mitad[i]
                i += 1
            else:
                nueva_lista[k] = segunda_mitad[j]
                j += 1
            k += 1

        while i < len(primera_mitad):
            nueva_lista[k] = primera_mitad[i]
            i += 1
            k += 1

        while j < len(segunda_mitad):
            nueva_lista[k] = segunda_mitad[j]
            j += 1
            k += 1
    return nueva_lista

if __name__ == "__main__":
    system("cls")
    numeros = generar_numeros(100)
    print("Original:")
    print(numeros)

    inicio_cronometro = default_timer()
    nuevo_numeros = ordenar_mezcla(numeros)
    fin_cronometro = default_timer()
    print("\nOrdenado:")
    print(nuevo_numeros)
    print(f"Tiempo de ejecución: {fin_cronometro - inicio_cronometro}")