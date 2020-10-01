package com.rudicoding;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.print("Principal ($10k - $1M): ");
            principal = scan.nextInt();
            if (principal >= 10_000 && principal <= 1_000_000)
                break;
                System.out.println("Enter a number between $10000 - $1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scan.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30){
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 - 30");
        }

        while (true) {
            System.out.print("Period (years): ");
            byte years = scan.nextByte();
            if (years >= 1 && years >= 30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value over 30");
        }
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                            / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}

/*
Principal: ?
Annual Interest Rate:?
Period (years): ?
Mortgage(monthly payment): $result

M =
 */