print("*******************************")
print("* Sistema vacacional de Rappi *")
print("*******************************")

nombreTrabajador = str(input("Cual es su nombre: "))
print("1. Departamento de atención al cliente \n2. Departamento de logistica \n3. Gerencia")
opcionDepartamento = int(input("===> "))
yearsServicio = int(input("Cuantos años de servicio tiene: "))
if opcionDepartamento == 1:
    if yearsServicio == 1:
        diasVacaciones = 6
    elif yearsServicio >= 2 and yearsServicio <= 6:
        diasVacaciones = 14
    elif yearsServicio > 7:
        diasVacaciones = 20
    else:
        print("Sin derecho a vacaciones")
elif opcionDepartamento == 2:
    if yearsServicio == 1:
        diasVacaciones = 7
    elif yearsServicio >= 2 and yearsServicio <= 6:
        diasVacaciones = 15
    elif yearsServicio > 7:
        diasVacaciones = 22
    else:
        print("Sin derecho a vacaciones")
elif opcionDepartamento == 3:
    if yearsServicio == 1:
        diasVacaciones = 10
    elif yearsServicio >= 2 and yearsServicio <= 6:
        diasVacaciones = 20
    elif yearsServicio >= 7:
        diasVacaciones = 30
    else:
        print("Sin derecho a vacaciones")
else:
    print("La clave no existe")
print(nombreTrabajador, ", usted tiene", diasVacaciones, "de vacaciones.")
