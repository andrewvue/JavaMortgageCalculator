package com.javamortgagecalculator;

public class MortgageCalculator {
    //Reduce duplicated logic
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;
    //Create private fields that can only be accessed by MortgageCalculator class
    //This reduces code redundancy
    //These fields are the state of our class
    private int principal;
    private float annualInterest;
    private byte years;

    //Create a constructor so we can use these fields
    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }
//Turn the static methods into an instance Methods so we can access the private fields
    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public short getYears() {
        return years;
    }
}
