numero1 = int(input("Digite el primero numero: "))
numero2 = int(input("Digite el segundo numero: "))
numero3 = int(input("Digite el tercer numero: "))

if numero1 > numero2 and numero1 > numero3:
    print("El numero mayor es el: ", numero1)
elif numero2 > numero3:
    print("El numero mayor es el: ", numero2)
else:
    print("El numero mayor es el: ", numero3)
