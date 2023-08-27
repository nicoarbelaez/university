import random
contador = 0
adivinar = random.randint(0,100)
while True:
    numero = int(input("Cual cree que es el numero escogido por la CPU (0-100) \n===> "))
    contador += 1
    if numero == adivinar:
        break
    elif numero > adivinar:
        print(f"El numero es menor a {numero}")
    else:
        print(f"El numero es mayor a {numero}")
print(f"\n*** CORRECTO, ES {adivinar} ***\n Sus intentos fueron: {contador}")
