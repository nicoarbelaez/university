# Estrcutura de datos
# Pilas (primero en entrar, ultimo en salir)

pila = [1, 2, 3]

pila.append(4) # agregar elemntos por el final de la pila
pila.append(5)

print(pila)
pila.pop() # Sacar elementos por el final

print(pila)
num = pila.pop()
print(f"Numero de la pila: {num} ")
print(pila)