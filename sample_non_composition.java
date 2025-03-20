/**
 * Author: Dr. Peter Yau
 * Email: PeterCY.Yau@glasgow.ac.uk
 * 
 * Copyright 2025
 * School of Computing Science, University of Glasgow
 *  
 * Disclaimer:
 * Programmers should ensure the environment and settings are correct.
 * This code does not confirm 100% accuracy. Remember to change the filename and 
 * class name to match your specific implementation.
 */

// Base class: BankAccount
class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        System.out.println("Deposited: $" + amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawn: $" + amount);
            balance -= amount;
        }
    }

    public void showBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }
}

// Derived class: SavingsAccount
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}

// Derived class: LoanAccount
class LoanAccount extends BankAccount {
    public LoanAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void payLoan(double amount) {
        System.out.println("Loan payment made: $" + amount);
        balance -= amount; // Reducing loan balance
    }
}

public class NonCompositionBankingDemo {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("123456789", 1000.00);
        savingsAccount.showBalance();
        savingsAccount.deposit(500);
        savingsAccount.withdraw(300);
        savingsAccount.showBalance();

        LoanAccount loanAccount = new LoanAccount("987654321", 5000.00);
        loanAccount.showBalance();
        loanAccount.payLoan(1000);
        loanAccount.showBalance();
    }
}
