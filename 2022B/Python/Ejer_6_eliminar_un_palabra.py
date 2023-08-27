frase = input("Cadena de caracteres: ")
palabra = input("Palabra a eliminar: ")

indice = frase.find(palabra) # Busca una palabra
subfrase = frase[: indice] + frase[indice + len(palabra) + 1 :] # Recorta desde el inicio hasta el inicio de la palabra

print(f"La nueva plabra es ==> {subfrase} <== ")