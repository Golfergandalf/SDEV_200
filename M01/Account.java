/* Module 1: Assignment 4
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   Account.class
*/

import java.util.Date;

public class Account {
    // Private data fields
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0; // shared by all accounts
    private Date dateCreated;

    // No-arg constructor
    public Account() {
        dateCreated = new Date(); // set creation date to now
    }

    // Constructor with id and balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    // Accessor methods (getters)
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Mutator methods (setters)
    public void setId(int id) {
        this.id = id;
    }

    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    // Get monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12 / 100; // convert percentage to decimal
    }

    // Get monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // Withdraw method
    public void withdraw(double amount) {
        balance -= amount;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }
}
