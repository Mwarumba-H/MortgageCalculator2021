package com.mwarumbaproject;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private byte Years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.Years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade){

        float monthlyInterest = getMonthlyInterest();
        int months = getNumberOfPayments();

        double balance = principal
                *(Math.pow((1+monthlyInterest),months)-Math.pow((1+monthlyInterest),numberOfPaymentsMade))
                /(Math.pow((1+monthlyInterest),months)-1);

        return balance;
    }

    public double calculateMortgage(){

       float monthlyInterest = getMonthlyInterest();
       int months = getNumberOfPayments();

        double Mortgage = principal *
                ((monthlyInterest*(Math.pow((1+monthlyInterest),months)))
                        / (Math.pow((1+monthlyInterest),months)-1));

        return Mortgage;
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);

        return balances;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private int getNumberOfPayments() {
        return Years * MONTHS_IN_YEAR;
    }

}
