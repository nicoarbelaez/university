frase = "Nicolas"
lista = []
for i in frase:
    lista.append(i)
lista = set(lista)
print(lista)

lista.clear
for i in frase:
    if i not in lista:
        lista.append(i)
print(lista)