package com.alehyemelyanchyk;

public class Calculator {

    private double monthStartBalance;
    private int years;
    private double interestRate;
    private static final int MONTHS = 12;

    private double familyIncome;
    private int familyMembers;

    private int extraPayment;


    public Calculator(double monthStartBalance, int years, double interestRate, double familyIncome, int familyMembers, int extraPayment) {
        this.monthStartBalance = monthStartBalance;
        this.years = years;
        this.interestRate = interestRate;
        this.familyIncome = familyIncome;
        this.familyMembers = familyMembers;
        this.extraPayment = extraPayment;
    }

    public Calculator(double monthStartBalance, int years, double interestRate, double familyIncome, int familyMembers) {
        this.monthStartBalance = monthStartBalance;
        this.years = years;
        this.interestRate = interestRate;
        this.familyIncome = familyIncome;
        this.familyMembers = familyMembers;
    }

    private double loanCalculator() {
        double monthlyInterest;
        double monthlyPrincipal;
        int periodCount;
        double monthEndBalance = 0;
        double interestAmount = 0;
        double payment = 0;
        double extraPay = 0;
        double startBalance = monthStartBalance;

        int loanLength = years * MONTHS;
        for (int i = loanLength; i > 0; i--) {
            periodCount = (loanLength + 1) - i;
            monthStartBalance -= (payment + extraPay);
            if (payment < monthStartBalance) {
                payment = startBalance / loanLength;
            } else {
                payment = monthStartBalance;
            }
            if (payment >= monthStartBalance) {
                extraPay = 0;
            } else {
                extraPay = extraPayment;
            }
            monthlyInterest = monthStartBalance * (interestRate / 100 / MONTHS);
            monthlyPrincipal = monthlyInterest + payment;
            interestAmount += monthlyInterest;
            monthEndBalance = monthStartBalance - payment;

            System.out.println("Period " + periodCount
                    + ": month start balance: " + String.format("%.2f", monthStartBalance)
                    + "; payment: " + String.format("%.2f", payment)
                    + "; extra payment: " + String.format("%.2f", extraPay)
                    + "; monthly interest: " + String.format("%.2f", monthlyInterest)
                    + "; monthly principal: " + String.format("%.2f", monthlyPrincipal)
                    + "; month end balance: " + String.format("%.2f", monthEndBalance)
                    + "; interest amount: " + String.format("%.2f", interestAmount));
            if (monthEndBalance <= 0) {
                break;
            }

        }
        return payment;
    }

    public boolean canPay() {
        int loanLength = years * MONTHS;
        double payment;
        payment = monthStartBalance / loanLength;
        double memberDebt = payment / (familyIncome / familyMembers) * 100;
        if (familyMembers == 1 && memberDebt <= 50) {
            System.out.println("Congratulations on your loan!");
            loanCalculator();
            return true;
        } else if (familyMembers == 2 && memberDebt <= 45) {
            System.out.println("Congratulations on your loan!");
            loanCalculator();
            return true;
        } else if (familyMembers == 3 && memberDebt <= 35) {
            System.out.println("Congratulations on your loan!");
            loanCalculator();
            return true;
        } else if (familyMembers == 4 && memberDebt <= 30) {
            System.out.println("Congratulations on your loan!");
            loanCalculator();
            return true;
        } else if (familyMembers == 5 && memberDebt <= 25) {
            System.out.println("Congratulations on your loan!");
            loanCalculator();
            return true;
        } else {
            System.out.println("Sorry, the loan has been denied");
            return false;
        }

    }
}

