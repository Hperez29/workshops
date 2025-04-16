package com.pluralsight;

import java.util.*;

public class Calculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.println("Enter loan amount (principal): ");
        double principal = scanner.nextDouble();

        System.out.println("Enter annual interest rate (e.g. 7.625 for 7.625%):" );
        double annualRate = scanner.nextDouble();

        System.out.println("Enter loan term in years: ");
        int years = scanner.nextInt();

        // Calculations
        double monthlyRate = annualRate / 100 / 12;
        int totalPayments = years * 12;

        double monthlyPayment = principal * (monthlyRate * Math.pow(1 + monthlyRate, totalPayments))
                / (Math.pow(1 + monthlyRate, totalPayments) - 1);

        double totalInterest = (monthlyPayment * totalPayments) - principal;

        // Output results
        System.out.printf("Monthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f\n", totalInterest);

        scanner.close();
    }
}