string = input("Escriba una frase: ")
newString = ""
for character in string:
    newString = character + newString
print(newString)