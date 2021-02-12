package com.javamortgagecalculator;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Please enter your Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber(" Enter your Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Enter the loan Period (Years): ", 1, 30);

        MortgageReport.printMortgage(principal, annualInterest, years);
        MortgageReport.printPaymentSchedule(principal, annualInterest, years);
    }

}
