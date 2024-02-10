package br.com.fiap.m00_foundations.ch02_data_input_output;

import java.text.MessageFormat;
import java.util.Scanner;

public class OutputFormatting {

    public void basicConcatenation(String name, int age, double weight) {
        System.out.println("1. My name is " + name + ", I am " + age + " years old and I weigh " + weight + "Kg");
    }

    public void printfConcatenation(String name, int age, double weight) {
        System.out.printf("2. My name is %s, I am %d years old and I weigh %.2fKg%n", name, age, weight);
    }

    public void printfConcatenationWithPadding(String name, int age, double weight) {
        System.out.println("==========================");
        System.out.println("3. Personal Information: ");
        System.out.printf("%-10s%s; %n", "Name:", name);
        System.out.printf("%-10s%d years old; %n", "Age:", age);
        System.out.printf("%-10s%.2fKg;%n", "Weight:", weight);
        System.out.println("==========================");
    }

    public void stringFormatMethod(String name, int age, double weight) {
        String formattedString = String.format("4. My name is %s, I am %d years old and I weigh %.2fKg", name, age, weight);
        System.out.println(formattedString);
    }

    public void messageFormatMethod(String name, int age, double weight) {
        String pattern = "5. My name is {0}, I am {1} years old and I weigh {2}Kg";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String formattedString = messageFormat.format(new Object[]{name, age, weight});
        System.out.println(formattedString);
    }

    public void messageFormatMethodWithFormattingFields(String name, int age, double weight) {
        String pattern = "6. My name is {0}, I am {1} years old and I weigh {2,number,#.##}Kg";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String formattedString = messageFormat.format(new Object[]{name, age, weight});
        System.out.println(formattedString);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your weight: ");
        double weight = scanner.nextDouble();

        System.out.println();

        OutputFormatting outputFormatting = new OutputFormatting();

        outputFormatting.basicConcatenation(name, age, weight);
        outputFormatting.printfConcatenation(name, age, weight);
        outputFormatting.printfConcatenationWithPadding(name, age, weight);
        outputFormatting.stringFormatMethod(name, age, weight);
        outputFormatting.messageFormatMethod(name, age, weight);
        outputFormatting.messageFormatMethodWithFormattingFields(name, age, weight);

    }
}
