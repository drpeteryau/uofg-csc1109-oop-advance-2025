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

import java.time.LocalDateTime;

final class BankTransaction {
    private final String transactionId;
    private final String accountNumber;
    private final double amount;
    private final LocalDateTime timestamp;

    public BankTransaction(String transactionId, String accountNumber, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Capture transaction time
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Amount: $" + amount);
        System.out.println("Timestamp: " + timestamp);
    }

    public static void main(String[] args) {
        // Creating an immutable transaction
        BankTransaction transaction = new BankTransaction("TXN12345", "987654321", 500.00);
        
        // Displaying transaction details
        transaction.displayTransaction();
        
        // Uncommenting below lines will result in a compilation error due to immutability
        // transaction.amount = 1000; // Not allowed
        // transaction.accountNumber = "123456789"; // Not allowed
    }
}
