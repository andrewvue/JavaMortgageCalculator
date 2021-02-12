package com.javamortgagecalculator;

public class MortgageCalculator {
    //Create private fields that can only be accessed by MortgageCalculator class
    //Static fields
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

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
        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        float numberOfPayments = getNumberOfPayments();

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }
//Create an array to hold our balances after each payment

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }
//Create private getter methods to reduce repeated code -implementation detail needs to be private-
//Reduces duplicated logic
    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
//This is public because other classes need to use this getter, but not necessary anymore because it isn't used
//    public short getYears() {
//        return years;
//    }
}
