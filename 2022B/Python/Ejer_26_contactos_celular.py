contactos = {} # diccionario
while True:
    print("""
\n\t .:M E N U:.
1. Nuevo contacto")
2. Borarr contacto")
3. Ver contactos existentes""")
    opcion = int(input("4. Salir \n===> "))
    print("")
    if opcion == 1:
        nombre = input("Nombre: ")
        telefono = input("Telefono: ")
        if nombre not in contactos:
            contactos[nombre] = telefono # Se agrega una key y valor en el diccionario
            print("Contacto agragado con exito")
        else:
            print("El nombre de contacto ya existe")
    elif opcion == 2:
        nombre = input("Nombre: ")
        if nombre in contactos:
            del(contactos[nombre]) # Eliminar un key del diccionario
            print("Contacto eliminado con exito")
        else:
            print("El nombre de contacto no existe")
    elif opcion == 3:
        i = 1
        for clave,valor in contactos.items():
            print(f"[{i}] Nombre: {clave}", end=" <==> ")
            print(f"Telefono: {valor}")
            i += 1
    elif opcion == 4:
        print("Muchas gracias")
        break
    else:
        print("*** OPCIÓN INCORRECTA ***\n\n")