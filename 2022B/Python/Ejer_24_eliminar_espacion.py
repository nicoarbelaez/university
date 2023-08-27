frase = "¿Hola que tal?"
nueva_frase = ""
for i in frase:
    if i != " ":
        nueva_frase += i
print(f"La nueva frase es: {nueva_frase}\n Y tiene {len(nueva_frase)} caracteres")