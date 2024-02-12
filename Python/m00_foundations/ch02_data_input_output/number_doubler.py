def double_number(number):
    """
    Doubles the provided number.

    :param number: The number to be doubled.
    :return: The doubled value of the input number.
    """
    return number * 2


def main():
    print("-" * 21)
    print("Double Number Program")
    print("Type 'exit' to quit the program.")
    print("-" * 21)
    print()

    while True:
        user_input = input("Enter a number: ")

        if user_input.lower() == 'exit':
            print("Exiting program.")
            break

        try:
            input_number = float(user_input)
            doubled_result = double_number(input_number)
            print(f"Doubled number: {input_number} * 2 = {doubled_result:.2f}")
        except ValueError:
            print("Invalid input. Please enter a valid number or type 'exit' to quit the program.")
        print()


if __name__ == "__main__":
    main()
