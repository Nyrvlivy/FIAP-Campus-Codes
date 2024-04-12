def print_header():
    print('Debt Interest Calculator'.center(50, '-') + '\n')


def get_debt_value():
    while True:
        try:
            debt_value = float(input('Enter the price of the debt: '))
            if debt_value > 0:
                return debt_value
            else:
                print("Invalid value. The price of the debt must be greater than zero.\n")
        except ValueError:
            print("Invalid input. Please enter a valid price.\n")


def calculate_debt_interest(debt_value):
    installments = [1, 3, 6, 9, 12]
    interest_rates = [0, 0.10, 0.15, 0.20, 0.25]

    for i in range(len(installments)):
        total = debt_value * (1 + interest_rates[i])
        interest = total - debt_value
        installment_value = total / installments[i]
        print(f'Total: R$ {total:8.2f}  Interest: R$ {interest:8.2f}  Number of installments: {installments[i]:^3d}  Installment Value: R$ {installment_value:8.2f}')


def main():
    print_header()
    calculate_debt_interest(get_debt_value())


if __name__ == "__main__":
    main()
