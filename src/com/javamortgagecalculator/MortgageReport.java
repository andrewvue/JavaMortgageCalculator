package com.javamortgagecalculator;

import java.text.NumberFormat;

public class MortgageReport {
//Create a field of MortgageCalculator so we don't need to repeat code to create the object
    private MortgageCalculator calculator;

    // initialize the field using a constructor so it can be used
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        //Create a getter for getYears in order to calculate the years pulling form MortgageCalculator Class
        for (short month = 1; month <= calculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    //Use an instance Method so that we can reuse this method
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
