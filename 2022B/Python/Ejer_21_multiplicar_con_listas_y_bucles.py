number = 5

lista = list(range(1,11))
print(lista)

for i in lista:
    lista[i-1] *= number
print(lista)