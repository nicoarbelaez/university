diccionario = {"Azul":"Blue", "Rojo":"Red", "Verde":"Green"}
print(diccionario)

diccionario["Azul"] = "RED" # Cambiar el valor de una clave
diccionario["Amarillo"] = "Yellow" # agregar una clave y su contenido
del(diccionario["Rojo"]) # elimina una clave del diccionario

print(diccionario["Azul"])
print(diccionario["Amarillo"])
print(diccionario)
print("\n===============================\n")

agenda = {"Nicolas":{"Edad":17, "Estatura":1.70}, "Ana":[17, 1.65], "Juli":[24, 1.77]}
print(agenda)
print(agenda["Nicolas"]) # Una clabe con un diccionario adentro
print(agenda["Ana"])
print("\n===============================\n")

equipo = {10:"Paulo Dybala", 11:"Douglas Costa", 7:"Cristiano ronaldo"}
print(equipo)
print(equipo[10]) # Que hay en a clave
print(equipo.get(6,"No existe ese dorsal")) # Si no existe muestra mensaje
print(11 in equipo) # Existe esa clave en el diccionario
print(12 in equipo)
print(equipo.keys()) # Solo las clabes
print(equipo.values()) # Solo los valores
print(equipo.items()) # Mostrar duplas
print(len(equipo)) # Cuantos elemntos hay
equipo.clear() # Limpiar diccionario