import os

archivos_dic = {}
omitir = ['_', '.']

def normalizar_palabra(nombre):
    archivo_nombre = nombre
    archivo_nombre = archivo_nombre.replace(" ", "_").replace("-", "")
    remplazar = [
        ("á", "a"),
        ("é", "e"),
        ("í", "i"),
        ("ó", "o"),
        ("ú", "u"),
    ]
    for a, b in remplazar:
        archivo_nombre = archivo_nombre.replace(a, b)
    
    for i in range(len(archivo_nombre) - 1):
        if archivo_nombre[i] == '_' and archivo_nombre[i + 1] == '_':
            archivo_nombre = list(archivo_nombre)
            archivo_nombre[i] = ''
            archivo_nombre = ''.join(archivo_nombre)

    archivos_dic[nombre] = archivo_nombre

def leer_archivos(ruta=r'C:\Users\arbel\OneDrive\Documentos\Programs\Python'):
    os.chdir(ruta)
    archivos_dic.clear()
    print()
    for archivo in os.listdir():
        name_file = archivo
        
        if name_file[0] in omitir:
            continue
        normalizar_palabra(name_file)


def preguntar():
    ruta = r'C:\Users\arbel\OneDrive\Documentos\Programs\Python'
    titulo = f"""
    *** Renombrar archivos en masa ***
    <{ruta}>"""
    while True:
        os.system("cls")
        print(titulo)
        opcion = input("\n\tCambiar ruta [S/N] ")

        if opcion == 's' or opcion == 'S':
            ruta = input("\n\tPS ")
            break
        else:
            break
    leer_archivos(ruta)
    imprimir_archivos()
    opciones()

def opciones():
    print()
    print("""
    (1) Cambiar ruta
    (2) Eliminar archivo
    (3) Cambiar nombres
    (0) Salir""")
    opcion = int(input("\t => "))
    if opcion == 1:
        return preguntar()
    elif opcion == 2:
        while True:
            eliminar = input("Nombre del archivo(exit para salir): ")
            try:
                if not eliminar == "exit":
                    archivos_dic.pop(eliminar)
                break
            except:
                print(f"<{eliminar}> no existe")
    elif opcion == 3:
        cambiar = input("Esta seguro que desea cambiar los nombres [S/N] ")
        if cambiar == 's' or cambiar == 'S':
            os.system("cls")
            for file, name in archivos_dic.items():
                os.rename(file, name)
                print(name)
            input("")
            preguntar()
        else:
            return preguntar()
    else:
        return
    os.system("cls")
    imprimir_archivos()
    opciones()

def imprimir_archivos():
    for file, name in archivos_dic.items():
        print(f"{file} .   .   .   .   .<{name}>")

if __name__ == '__main__':
    os.system("cls")
    preguntar()
    input("Salir")