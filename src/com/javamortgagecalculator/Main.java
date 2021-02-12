package com.javamortgagecalculator;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Please enter your Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber(" Enter your Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Enter the loan Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        //Create a report object to print out
        var report = new MortgageReport(calculator);
        //Call and reference report object so that it will print
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
