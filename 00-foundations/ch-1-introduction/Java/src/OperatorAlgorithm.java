import java.util.Scanner;

public class OperatorAlgorithm {

    public void addition(double n1, double n2) {
        double addition = n1 + n2;
        System.out.printf("Addition: %.1f + %.1f = %.1f%n", n1, n2, addition);
    }

    public void subtraction(double n1, double n2) {
        double subtraction = n1 - n2;
        System.out.printf("Subtraction: %.1f - %.1f = %.1f%n", n1, n2, subtraction);
    }

    public void multiplication(double n1, double n2) {
        double multiplication = n1 * n2;
        System.out.printf("Multiplication: %.1f * %.1f = %.1f%n", n1, n2, multiplication);
    }

    public void division(double n1, double n2) {
        if (n2 == 0) {
            System.out.println("Cannot divide by zero.");
        } else {
            double division = n1 / n2;
            System.out.printf("Division: %.1f / %.1f = %.1f %n", n1, n2, division);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double n1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double n2 = scanner.nextDouble();

        System.out.println();

        OperatorAlgorithm operatorAlgorithm = new OperatorAlgorithm();

        operatorAlgorithm.addition(n1, n2);
        operatorAlgorithm.subtraction(n1, n2);
        operatorAlgorithm.multiplication(n1, n2);
        operatorAlgorithm.division(n1, n2);

        scanner.close();
    }
}

