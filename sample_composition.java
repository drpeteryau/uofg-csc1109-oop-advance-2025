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

// Transaction service for handling deposits and withdrawals
class TransactionService {
    public void deposit(double amount) {
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount, double balance) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Withdrawn: $" + amount);
        }
    }
}

// Loan service for handling loan payments
class LoanService {
    public void payLoan(double amount) {
        System.out.println("Loan payment made: $" + amount);
    }
}

// BankAccount class using composition
class BankAccount {
    private String accountNumber;
    private double balance;
    private final TransactionService transactionService;
    private final LoanService loanService;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionService = new TransactionService();
        this.loanService = new LoanService();
    }

    public void deposit(double amount) {
        transactionService.deposit(amount);
        balance += amount;
    }

    public void withdraw(double amount) {
        transactionService.withdraw(amount, balance);
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void payLoan(double amount) {
        loanService.payLoan(amount);
    }

    public void showBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000.00);
        
        account.showBalance();
        account.deposit(500);
        account.withdraw(300);
        account.payLoan(200);
        account.showBalance();
    }
}
