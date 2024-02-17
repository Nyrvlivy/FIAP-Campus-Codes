package br.com.fiap.m00_foundations.ch03_conditional_statements;

import java.math.BigDecimal;
import java.util.Scanner;

public class IncomeTaxCalculator {
    private static final Scanner scanner = new Scanner(System.in);

    private static BigDecimal readSalary() {
        BigDecimal salary = BigDecimal.ZERO;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your salary: ");
            if (scanner.hasNextBigDecimal()) {
                salary = scanner.nextBigDecimal();
                if (salary.compareTo(BigDecimal.ZERO) > 0) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid salary.");
                }
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
        return salary;
    }

    private void printDetails(BigDecimal salary, BigDecimal incomeTax) {
        System.out.println("-----------------------------");
        System.out.printf("%-12s %.2f %n", "Salary:", salary);
        System.out.printf("%-12s %.2f %n", "Income Tax:", incomeTax);
        if (incomeTax.compareTo(BigDecimal.ZERO) == 0) System.out.println("! You are exempt from paying income tax !");
        System.out.println("-----------------------------");
    }

    public void calculateIncomeTax(BigDecimal salary) {
        BigDecimal ir;
        if (salary.compareTo(new BigDecimal("2259.20")) <= 0) {
            ir = BigDecimal.ZERO;
        } else if (salary.compareTo(new BigDecimal("2826.65")) <= 0) {
            ir = salary.multiply(new BigDecimal("0.075"));
        } else if (salary.compareTo(new BigDecimal("3751.05")) <= 0) {
            ir = salary.multiply(new BigDecimal("0.15"));
        } else if (salary.compareTo(new BigDecimal("4664.68")) <= 0) {
            ir = salary.multiply(new BigDecimal("0.225"));
        } else {
            ir = salary.multiply(new BigDecimal("0.275"));
        }
        printDetails(salary, ir);
    }

    public static boolean exitProgram() {
        String answer;
        do {
            System.out.print("Do you want to calculate another salary? (Y/N) ");
            answer = scanner.next();
            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                System.out.println();
            }
        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        return !answer.equalsIgnoreCase("Y");
    }

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Welcome to the Income Tax Calculator");
        System.out.println("==============================");
        System.out.println();

        boolean isExit = false;
        IncomeTaxCalculator incomeTaxCalculator = new IncomeTaxCalculator();

        while (!isExit) {
            BigDecimal salary = readSalary();
            incomeTaxCalculator.calculateIncomeTax(salary);
            isExit = exitProgram();
        }

    }
}
