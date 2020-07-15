package test_file;

import java.util.Date;

class Account{
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;

    }
    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0.045;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }
    public double getMonthlyInterest() {
        return (annualInterestRate/12)*balance;
    }
    public void withdraw(double cash){
        balance = balance - cash;
        System.out.println("You have withdrawn "+ cash + " $ from yo account u twat");
    }

    public void deposit(double cash){
        balance = balance + cash;
        System.out.println("You have deposit "+ cash + " $ into yo account u cunt");
    }
}
public class Account1 {
    public static void main(String[] args) {
        Account actualAccount = new Account(1122,20000);
        actualAccount.withdraw(2500);
        actualAccount.deposit(3000);
        System.out.println("Balance: "+ actualAccount.getBalance());
        System.out.println("Monthly Interest: " + actualAccount.getMonthlyInterest());
        System.out.println("Date Created: "+ actualAccount.getDateCreated());
    }
}
