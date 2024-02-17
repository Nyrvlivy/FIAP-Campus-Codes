package br.com.fiap.m00_foundations.ch03_conditional_statements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomeTaxCalculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<TaxBracket> taxBrackets = new ArrayList<>();

    static {
        taxBrackets.add(new TaxBracket(new BigDecimal("2259.20"), BigDecimal.ZERO));
        taxBrackets.add(new TaxBracket(new BigDecimal("2826.65"), (new BigDecimal("0.075"))));
        taxBrackets.add(new TaxBracket(new BigDecimal("3751.05"), (new BigDecimal("0.15"))));
        taxBrackets.add(new TaxBracket(new BigDecimal("4664.68"), (new BigDecimal("0.225"))));
        taxBrackets.add(new TaxBracket(null, (new BigDecimal("0.275"))));
    }

    private static class TaxBracket {
        BigDecimal limit;
        BigDecimal rate;

        public TaxBracket(BigDecimal limit, BigDecimal rate) {
            this.limit = limit;
            this.rate = rate;
        }
    }

    private static BigDecimal readSalary() {
        BigDecimal salary;
        while (true) {
            System.out.print("\nEnter your salary: ");
            if (scanner.hasNextBigDecimal()) {
                salary = scanner.nextBigDecimal();
                if (salary.compareTo(BigDecimal.ZERO) > 0) break;
                else System.out.println("Invalid input. Please enter a valid salary.");
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next();
            }
        }
        return salary;
    }


    public void calculateIncomeTax(BigDecimal salary) {
        BigDecimal ir = BigDecimal.ZERO;
        for (TaxBracket bracket : taxBrackets) {
            if (bracket.limit == null || salary.compareTo(bracket.limit) <= 0) {
                ir = salary.multiply(bracket.rate);
                break;
            }
        }

        printDetails(salary, ir);
    }

    private void printDetails(BigDecimal salary, BigDecimal incomeTax) {
        System.out.println("-----------------------------");
        System.out.printf("%-12s %.2f %n", "Salary:", salary);
        System.out.printf("%-12s %.2f %n", "Income Tax:", incomeTax);
        if (incomeTax.compareTo(BigDecimal.ZERO) == 0) System.out.println("! You are exempt from paying income tax !");
        System.out.println("-----------------------------");
    }

    public static boolean exitProgram() {
        while (true) {
            System.out.print("Do you want to calculate another salary? (Y/N) ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Y")) return false;
            else if (answer.equalsIgnoreCase("N")) return true;
            else System.out.println("Invalid input. Please enter 'Y' or 'N'.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Welcome to the Income Tax Calculator");
        System.out.println("==============================");

        IncomeTaxCalculator incomeTaxCalculator = new IncomeTaxCalculator();

        do {
            BigDecimal salary = readSalary();
            incomeTaxCalculator.calculateIncomeTax(salary);
        } while (!exitProgram());

    }
}
