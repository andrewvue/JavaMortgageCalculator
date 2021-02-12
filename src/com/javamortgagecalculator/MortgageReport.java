package com.javamortgagecalculator;

import java.text.NumberFormat;

public class MortgageReport {
    //Create a private final field for currency so we don't need to repeat formatting the printed string
    private final NumberFormat currency;
    //Create a field of MortgageCalculator so we don't need to repeat code to create the object
    private MortgageCalculator calculator;

    // initialize the field using a constructor so it can be used
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("====================");
        //use the array balance and iterate through it and print out each remaining balance
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
        }

    //Use an instance Method so that we can reuse this method
    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("==============");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
