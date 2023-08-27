print("*********************")
print("* Cajero automatico *")
print("*********************\n")
print("1. Ingresar dinero en la cuenta")
print("2. Retirar dinero de la cuenta")
print("3. Mostar dinero disponible")
print("4. Salir")
opcion = int(input("===> "))

dineroTotal = 1000
if opcion == 1:
    dineroAgregar = float(input("Dinero que agregara ===> $"))
    dineroTotal += dineroAgregar
    print("*********************")
    print(f"* Dinero disponible: ${dineroTotal} *")
    print("*********************\n")
elif opcion == 2:
    dineroQuitar = float(input("Dinero que retirara ===> $"))
    if dineroQuitar > dineroTotal:
        print("No puedes retirar ${dineroQuitar}")
    else:
        dineroTotal -= dineroQuitar
        print("*********************")
        print(f"* Dinero disponible: ${dineroTotal} *")
        print("*********************\n")
elif opcion == 3:
    print("*********************")
    print(f"* Dinero disponible: ${dineroTotal} *")
    print("*********************\n")
else:
    print("Muchas gracias por confir en nosotros.")
