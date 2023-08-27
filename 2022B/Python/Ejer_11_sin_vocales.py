string = "Hola como estan todos"
letter = 'z'
for character in string:
    if character.lower() == letter.lower():
        break
    elif character.lower() == 'a':
        continue
    elif character.lower() == 'e':
        continue
    elif character.lower() == 'i':
        continue
    elif character.lower() == 'o':
        continue
    elif character.lower() == 'u':
        continue
    print(character, end="")