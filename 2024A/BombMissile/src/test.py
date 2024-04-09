def generate_all_possible_numbers():
    # Genera todas las combinaciones posibles de X dígitos.
    count_ditits = 3;
    possible_numbers = []
    for num in range(0, pow(10, count_ditits)):
        digits = [int(d) for d in str(num)]
        if len(set(digits)) == count_ditits:  # Verifica que los dígitos sean únicos
            possible_numbers.append(digits)
    return possible_numbers

def get_toros_vacas(secret_number, guess):
    toros = 0
    vacas = 0
    for i in range(len(secret_number)):
        if guess[i] == secret_number[i]:
            toros += 1
        elif guess[i] in secret_number:
            vacas += 1
    return toros, vacas

def filter_possible_numbers(possible_numbers, guess, toros, vacas):
    filtered_numbers = []
    for num in possible_numbers:
        if get_toros_vacas(num, guess) == (toros, vacas):
            filtered_numbers.append(num)
    return filtered_numbers

def choose_next_guess(possible_numbers):
    # Calcula la cantidad de ocurrencias de cada dígito en las combinaciones restantes
    digit_counts = [0] * 10
    for num in possible_numbers:
        for digit in num:
            digit_counts[digit] += 1

    # Elige la siguiente suposición basada en el dígito con más ocurrencias
    next_guess = [digit_counts.index(max(digit_counts))] * 3

    return next_guess

def main():
    secret_number = [int(d) for d in input("Ingresa el número secreto de 4 dígitos (sin repetir dígitos): ")]
    possible_numbers = generate_all_possible_numbers()
    attempts = 0

    while len(possible_numbers) > 1:
        guess = choose_next_guess(possible_numbers)
        print(possible_numbers)
        attempts += 1
        print(f"[{attempts}] Mi suposición: {guess}")

        toros, vacas = get_toros_vacas(secret_number, guess)
        print(f"Ingresa el número de toros: {toros}")
        print(f"Ingresa el número de vacas: {vacas}")

        possible_numbers = filter_possible_numbers(possible_numbers, guess, toros, vacas)

        if len(possible_numbers) == 1:
            print(f"¡Adiviné! El número secreto es {possible_numbers[0]}")
            break

        if len(possible_numbers) == 0:
            print("¡Ups! Algo salió mal. No quedan números válidos.")
            break

if __name__ == "__main__":
    main()
