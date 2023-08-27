# Dos listas y que, a continuación, cree las siguientes listas (en las que no debe haber repeteciones)
# > Lista de elementos que aparecen en las dos listas.
# > Lista de elementos que aparecen en la primera lista, pero no en la segunda.
# > Lista de elementos que aparecen en la segunda lista, pero no en la primera.
# > Lista de elementos que aparecen en ambas listas

lista1 = [1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1]
lista2 = [2,4,6,8,10,1,12,14,16,1,2,3,5,7,2,8]
listA = set(lista1)
listB = set(lista2)

print("======================================")
print(lista1, "Lista")
print(lista2, "Lista")
print(listA, "Conjunto")
print(listB, "Conjunto")
print("======================================\n\n")

union = list(listA | listB)
soloA = list(listA - listB)
soloB = list(listB - listA)
interseccion = list(listA & listB)

print(union)
print(soloA)
print(soloB)
print(interseccion)
