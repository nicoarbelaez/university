print("********************")
print("* Menu de opciones *")
print("********************")

print("1. Suma \n2. Resta \n3. Mutiplicación \n4. División \n5. División entera \n6. Exponente \n7. Modulo o resto")
opcion = int(input("===> "))

if opcion == 1:
    print("Opcion: Suma")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 + numero2
    print(numero1, "+", numero2, "=", total)
elif opcion == 2:
    print("Opcion: Resta")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 - numero2
    print(numero1, "-", numero2, "=", total)
elif opcion == 3:
    print("Opcion: Multiplicación")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 * numero2
    print(numero1, "*", numero2, "=", total)
elif opcion == 4:
    print("Opcion: División")
    numero1 = float(input("Digite el primer numero: "))
    numero2 = float(input("Digite el segundo numero: "))
    total = numero1 / numero2
    print(numero1, "/", numero2, "=", total)
elif opcion == 5:
    print("Opcion: División entera")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 // numero2
    print(numero1, "//", numero2, "=", total)
elif opcion == 6:
    print("Opcion: Exponente")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 ** numero2
    print(numero1, "**", numero2, "=", total)
elif opcion == 7:
    print("Opcion: Modulo o resto")
    numero1 = int(input("Digite el primer numero: "))
    numero2 = int(input("Digite el segundo numero: "))
    total = numero1 % numero2
    print(numero1, "%", numero2, "=", total)
else: 
    print("La opcion no existe")