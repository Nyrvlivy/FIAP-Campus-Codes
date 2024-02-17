from decimal import Decimal, getcontext, InvalidOperation

TAX_BRACKETS = [(2259.20, Decimal('0.00')),
                (2826.65, Decimal('0.075')),
                (3751.05, Decimal('0.15')),
                (4664.68, Decimal('0.225')),
                (Decimal('inf'), Decimal('0.275'))]

getcontext().prec = 2


def read_salary():
    while True:
        try:
            salary_input = input("\nEnter your salary: ")
            salary = Decimal(salary_input)
            if salary > 0:
                return salary
            else:
                print("Invalid input. Please enter a valid salary.")
        except (ValueError, InvalidOperation):
            print("Invalid input. Please enter a numeric value.")


def calculate_tax(salary, ):
    for bracket, rate in TAX_BRACKETS:
        if salary <= bracket:
            ir = salary * rate
            break
    print_details(salary, ir)


def print_details(salary, ir):
    print("-----------------------------")
    print(f"Salary:     {salary:.2f}")
    print(f"Income Tax: {ir:.2f}")
    if ir == Decimal(0):
        print("! You are exempt from paying income tax !")
    print("-----------------------------")


def exit_program():
    while True:
        user_input = input("Do you want to calculate another salary? (Y/N): ")
        if user_input.lower() == 'n':
            print("Exiting program.")
            return True
        elif user_input.lower() == 'y':
            return False
        else:
            print("Invalid input. Please enter 'Y' or 'N'.")


def main():
    print("==============================")
    print("Income Tax Calculator")
    print("==============================")

    while True:
        salary = read_salary()
        calculate_tax(salary)
        if exit_program():
            break


if __name__ == '__main__':
    main()
