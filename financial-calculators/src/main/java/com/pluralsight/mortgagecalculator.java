package com.pluralsight;

import java.util.*;

public class mortgagecalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Calculator:");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        int choice = scanner.nextInt();

        if (choice == 1) {
            mortgageCalculator(scanner);
        } else if (choice == 2) {
            futureValueCalculator(scanner);
        } else {
            System.out.println("Invalid selection.");
        }

        scanner.close();
    }

    public static void mortgageCalculator(Scanner scanner) {
        System.out.print("Enter loan amount (principal): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (e.g., 7.625 for 7.625%): ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("Enter loan term in years: ");
        int years = scanner.nextInt();

        int n = years * 12; // Total number of monthly payments
        double i = annualRate / 12; // Monthly interest rate

        double monthlyPayment = principal * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1);
        double totalPaid = monthlyPayment * n;
        double totalInterest = totalPaid - principal;

        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);
    }

    public static void futureValueCalculator(Scanner scanner) {
        System.out.print("Enter deposit amount (principal): ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (e.g., 1.75 for 1.75%): ");
        double annualRate = scanner.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        double years = scanner.nextDouble();

        double FV = principal * Math.pow(1 + annualRate / 365, 365 * years);
        double interestEarned = FV - principal;

        System.out.printf("Future Value: $%.2f\n", FV);
        System.out.printf("Total Interest Earned: $%.2f\n", interestEarned);
    }
}