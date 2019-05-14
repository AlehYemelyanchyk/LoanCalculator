package com.alehyemelyanchyk;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, in order to get a loan, fill the information:");
        System.out.println("The amount of loan you would like to get:");
        double monthStartBalance = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("For how many years:");
        int years = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What interest rate do you chose:");
        double interestRate = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("How big family income do you have:");
        double familyIncome = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("How many family members do you have:");
        int familyMembers = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What extra payment you will to pay each month:");
        int extraPayment = scanner.nextInt();
        scanner.nextLine();

        Calculator newLoan = new Calculator(monthStartBalance, years, interestRate, familyIncome, familyMembers, extraPayment);
        newLoan.canPay();

    }
}
