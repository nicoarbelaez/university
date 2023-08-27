# Estrcutura de datos
# Colas (primero en entrar, primero en salir)

# =======OTRA FORMA========
# from collections import deque
# =========================

cola = ["Nicolas", "Ana", "Jose", "Julian"]
print(cola)

cola.append("Maria") # Agregamos elementos al final de la cola
print(cola)

person = cola.pop(0) # Sacando elementos por el pirncipio
print(cola)
print(f"Atencion: {person} ")

person = cola.pop(0)
print(cola)
print(f"Atencion: {person} ")