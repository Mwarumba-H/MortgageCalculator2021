package com.mwarumbaproject;

public class Main {

    public static void main(String[] args) {

        int principal =(int) Console.readNumber("Principal: ",1000,1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ",1,30);
        byte Years = (byte) Console.readNumber("Period (Years): ",1,30);

        var calculator = new MortgageCalculator(principal,annualInterest,Years);
        var report = new MortgageReport(calculator);
        report.printMortgage(); // extracted method
        report.printPaymentSchedule(); //extracted method

    }
}
