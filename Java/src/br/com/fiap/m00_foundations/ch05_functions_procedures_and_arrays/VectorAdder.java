package br.com.fiap.m00_foundations.ch05_functions_procedures_and_arrays;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VectorAdder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcomeMessage();
        int[] vector = readVector();
        vectorAdder(vector);
        findValue(vector);
    }

    private static void printWelcomeMessage() {
        System.out.println("==============================");
        System.out.println("Welcome to Vector Adder");
        System.out.println("==============================\n");
    }

    private static int[] readVector() {
        int[] vector = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.printf("Enter the vector[%d]: ", i);
            while (true) {
                try {
                    vector[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter a valid number: ");
                    scanner.next();
                }
            }
        }
        return vector;
    }

    private static void vectorAdder(int[] vector) {
        int sum = 0;
        for (int value : vector) {
            sum += value;
        }
        System.out.printf("Total: %d %n", sum);
    }

    private static void findValue(int[] vector) {
        System.out.print("\nEnter the value to find: ");
        int valueToFind = scanner.nextInt();
        for (int value : vector) {
            if (value == valueToFind) {
                System.out.println("Value found!");
                return;
            }
        }
        System.out.println("Value not found!");
    }
}
