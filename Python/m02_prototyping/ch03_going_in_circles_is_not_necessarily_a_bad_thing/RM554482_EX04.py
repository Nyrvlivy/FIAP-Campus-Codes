def print_header():
    print('Income Tax Rate Calculator'.center(50, '-') + '\n')


def input_investment_details():
    while True:
        try:
            investment_type = int(input('Types of investment \n1 - CDB \n2 - LCI \n3 - LCA\n\nEnter the type: '))
            if investment_type in [1, 2, 3]:
                if investment_type == 1:
                    amount = float(input('\nEnter the amount to be redeemed: R$ '))
                    days = int(input('Enter the number of days the amount was invested: '))
                    return investment_type, amount, days
                else:
                    print("\nInvestment exempt from income tax!\nIncome tax value: R$ 0.00")
                    exit()
            else:
                print("\nInvalid value. Please enter a valid investment type.")
        except ValueError:
            print("\nInvalid input. Please enter a valid number.")


def calculate_tax(investment_type, amount, days):
    tax_rate = 0
    if investment_type == 1:
        if days <= 180:
            tax_rate = 0.225
        elif 181 <= days <= 360:
            tax_rate = 0.2
        elif 361 <= days <= 720:
            tax_rate = 0.175
        else:
            tax_rate = 0.15
    return amount * tax_rate


def print_results(tax):
    if tax > 0:
        print(f'\nThe income tax to be paid is R$ {tax:.2f}.')
    else:
        print('\nThere is no income tax to be paid.')


def main():
    print_header()
    investment_type, amount, days = input_investment_details()
    tax = calculate_tax(investment_type, amount, days)
    print_results(tax)


if __name__ == "__main__":
    main()
