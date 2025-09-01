/* Module 1: Assignment 4
Name:   Gabby Willard
Class:  SDEV 200
Date:   8/25/25
File:   M01_Assignment_4.java
*/

public class M01_Assignment_4 {
  public static void main(String[] args) {
    
    // Create Account object
    Account account = new Account(1122, 20000);
    Account.setAnnualInterestRate(4.5); // set annual interest rate

    // Withdraw and deposit
    account.withdraw(2500);
    account.deposit(3000);

    // Display balance, monthly interest, and creation date
    System.out.println("Balance: $" + account.getBalance());
    System.out.println("Monthly Interest: $" + account.getMonthlyInterest());
    System.out.println("Date Created: " + account.getDateCreated());
  }
}
