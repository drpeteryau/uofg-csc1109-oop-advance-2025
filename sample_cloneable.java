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

class BankAccount implements Cloneable {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

    public void showBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }

    @Override
    protected BankAccount clone() throws CloneNotSupportedException {
        return (BankAccount) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        BankAccount originalAccount = new BankAccount("123456789", 1000.00);
        originalAccount.showBalance();

        // Cloning the original account
        BankAccount clonedAccount = originalAccount.clone();
        System.out.println("Cloned account created.");

        // Simulating a transaction on the cloned account
        clonedAccount.withdraw(300);
        clonedAccount.showBalance();

        // Verifying the original account remains unchanged
        System.out.println("Original account remains unchanged:");
        originalAccount.showBalance();
    }
}
