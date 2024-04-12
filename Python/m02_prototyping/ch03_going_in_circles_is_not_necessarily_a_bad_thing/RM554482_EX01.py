def print_header():
    print('Day of the Week Vote'.center(50, '-') + '\n')


def get_number_of_employees():
    while True:
        try:
            employees = int(input('Enter the number of employees: '))
            if employees > 0:
                return employees
            else:
                print("Invalid value. At least one employee is required.")
        except ValueError:
            print("Invalid input. Please enter a valid number.")


def vote_counter(employees, days):
    votes = {day: 0 for day in days}
    for employee in range(1, employees + 1):
        while True:
            print("\nPlease, enter your preferred day for the live:")
            for i, day in enumerate(days, start=1):
                print(f'  {i} - {day}')
            vote = input(f'\nEmployee {employee}, enter the day or number: ').strip()
            if vote.isdigit():
                vote_index = int(vote) - 1
                if 0 <= vote_index < len(days):
                    day_voted = days[vote_index]
                else:
                    print("Invalid number. Please enter a number from 1 to", len(days))
                    continue
            else:
                day_voted = vote.capitalize()

            if day_voted in days:
                votes[day_voted] += 1
                break
            else:
                print('Invalid day of the week. Please enter a valid day.')

    chosen_day = max(votes.values())
    winners_days = [day for day, votes in votes.items() if votes == chosen_day]

    return chosen_day, winners_days


def print_results(chosen_day, winners_days):
    if len(winners_days) == 1:
        print(f'\nThe winning day for the live is {winners_days[0]} with {chosen_day} votes.')
    else:
        print(f'\nThe vote ended in a tie between the days:')
        for day in winners_days:
            print(f'  - {day} with {chosen_day} votes.')


def main():
    print_header()
    days_of_week = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday']
    employees_number = get_number_of_employees()
    votes = vote_counter(employees_number, days_of_week)
    print_results(*votes)

    print('\nThanks for voting!')


if __name__ == "__main__":
    main()
