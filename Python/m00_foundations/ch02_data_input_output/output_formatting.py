# Inputs: name, age, weight
name = input('Enter your name: ')
age = int(input('Enter your age: '))
weight = float(input('Enter your weight: '))
print()

# Example 1 = Basic Concatenation:
print('1. My name is', name, 'I am', age, 'years old and I weigh', weight, 'Kg')

# Example 2 = Using str.format() method:
# Basic formatting
print('2. My name is {} I am {} years old and I weigh {} Kg'.format(name, age, weight))
# Formatting by specifying the position of variables
print('2. My name is {0} I am {1} years old and I weigh {2:.1f} Kg'.format(name, age, weight))
# Formatting explicit naming of arguments
print('2. My name is {n} I am {i} years old and I weigh {p:.2f} Kg'.format(n=name, i=age, p=weight))

# Example 3 = Using f-strings (Formatted String Literals):
# Including expressions inside f-strings
print(f'3. My name is {name} I am {age} years old and I weigh {weight:.2f} Kg')
