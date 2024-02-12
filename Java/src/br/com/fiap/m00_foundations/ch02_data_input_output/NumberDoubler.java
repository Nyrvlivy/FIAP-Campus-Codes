package br.com.fiap.m00_foundations.ch02_data_input_output;

import java.util.Scanner;

public class NumberDoubler {
    /**
     * Doubles the provided number.
     *
     * @param baseNumber The number to double.
     * @return The doubled value of the input number.
     */
    public double doubleNumber(double baseNumber) {
        return baseNumber * 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("Double Number Program");
        System.out.println("Type 'exit' to quit the program.");
        System.out.println("---------------------");
        System.out.println();

        while (true) {
            System.out.printf("%-17s", "Enter a number: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            try {
                double inputNumber = Double.parseDouble(userInput);
                NumberDoubler doubler = new NumberDoubler();
                double doubledResult = doubler.doubleNumber(inputNumber);

                System.out.printf("%-17s%.2f * 2 = %.2f.%n", "Doubled number: ", inputNumber, doubledResult);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or type 'exit' to quit the program.");
            }
            System.out.println();

        }

        scanner.close();

    }
}
