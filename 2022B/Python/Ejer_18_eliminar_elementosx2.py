# Eliminar elementos repetidos

lista = ["Hola", 1, "Hola", 2, 3, 4, 3, "Nicolas", 3.1415]
print(lista) # Lista sin convertir

conjunto = set(lista) # Convertir una lista a una conjunto
lista = list(conjunto) # Convertir un conjunto a una lista
print(lista)

print("===================")
lista2 = ["Marcelo", 1, 5, 1.70, "Marcelo", 2, 1.70, 3, "Hi", 4, 3, "Nicolas", 3.1415]
print(lista2)
lista2 = list(set(lista2)) # Se convirte en un conjunto y en el momento a una lista
print(lista2)