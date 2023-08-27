frase = "reconocer"
frase = frase.replace(" ", "") # Se remplaza los espacios por "nada"

nueva_frase = frase[::-1] # Se invierte la frase
print(f'Frase original: "{frase}"')
print(f'Frase invertida: "{nueva_frase}"')

if frase == nueva_frase:
    print("La frase SI es palidroma")
else:
    print("La frase NO es palidroma")