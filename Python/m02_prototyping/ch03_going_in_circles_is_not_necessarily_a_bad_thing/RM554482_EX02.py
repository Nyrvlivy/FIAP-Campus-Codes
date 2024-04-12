def print_header():
    print('Car Price Calculator'.center(50, '-') + '\n')


def get_car_price():
    while True:
        try:
            car_price = float(input('Enter the price of the car: '))
            if car_price > 0:
                return car_price
            else:
                print("Invalid value. The price of the car must be greater than zero.\n")
        except ValueError:
            print("Invalid input. Please enter a valid price.\n")


def calculate_final_price(car_price):
    cash_price = car_price * 0.8
    print(f'The final cash price with a 20% discount is: R$ {cash_price:.2f}\n')
    for installments in range(6, 61, 6):
        final_price = ((installments // 6) * 0.03 + 1) * car_price
        installment_value = final_price / installments
        print(f'The final price in {installments} installments is R$ {final_price:.2f} with installments of R$ {installment_value:.2f}')


def main():
    print_header()
    calculate_final_price(get_car_price())


if __name__ == "__main__":
    main()
