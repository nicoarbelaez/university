lista = []
while True:
    number = int(input("Que numero quiere ingresar a la lista: "))
    if number == 0:
        break
    lista.append(number)
lista.sort()
print(lista)