def normalizar_Palabra(palabra):
    remplazar = (
        ("á", "a"),
        ("é", "e"),
        ("í", "i"),
        ("ó", "o"),
        ("ú", "u"),
    )
    for a, b in remplazar:
        palabra = palabra.replace(a, b)
    return palabra.lower().replace(",","").replace(".","").replace(":","").replace('"',"") # Quita los posibles caracteres

def repeticiones(texto):
    diccionario = {}
    texto = texto.lower()
    separar_palabras = texto.split(" ") # Separa las palabras y las guarda en una lista

    for palabra in separar_palabras: # Recorre cada palabra de a lista
        if normalizar_Palabra(palabra) in diccionario: # Si la palabra esta en a lista
            diccionario[normalizar_Palabra(palabra)] += 1 # Agrega uno al contador de la palabra
        else:
            diccionario[normalizar_Palabra(palabra)] = 1 # Si no existe agrega la palabra
    for palabra,cantidad in diccionario.items(): # Muestra el diccionario
        print(f"{palabra}: {cantidad}")

texto = 'La fotografía de la portada muestra el Museo de la Ciencia en la Ciudad de las Artes y las Ciencias de Valencia, España, con un planetario en la distancia. Construido de 1991 a 1996, fue diseñado por Santiago Calatrava, arquitecto español. Calatrava siempre ha estado muy interesado en cómo las matemáticas pueden ayudar a materializar los edifi cios que imagina. Siendo un joven estudiante, él mismo aprendió geometría descriptiva de los libros con el fi n de representar objetos tridimensionales en dos dimensiones. Formado como ingeniero y arquitecto, escribió una tesis doctoral en 1981, titulada "Sobre el doblado de las estructuras espaciales", que está llena de matemáticas, especialmente transformaciones geométricas. Su fortaleza como ingeniero le permite ser atrevido en su arquitectura.'
repeticiones(texto)