package br.com.fiap.m00_foundations.ch5_functions_procedures_and_arrays;

import java.util.Scanner;

public class MatrixHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printWelcomeMessage();
        int[][] matrix = readMatrix();
        sumMatrix(matrix);
        findValue(matrix);
    }

    private static void printWelcomeMessage() {
        System.out.println("==============================");
        System.out.println("Welcome to Matrix Handler");
        System.out.println("==============================\n");
    }

    private static int[][] readMatrix() {
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.printf("Enter the value of matrix[%d][%d]: ", r, c);
                matrix[r][c] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        System.out.printf("Total: %d %n", sum);
    }

    private static void findValue(int[][] matrix) {
        System.out.print("Enter the value to find: ");
        int valueToFind = scanner.nextInt();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToFind) {
                    System.out.printf("Value %d found at position [%d, %d]!%n", valueToFind, r, c);
                    return;
                }
            }
        }
        System.out.println("Value not found!");
    }
}
