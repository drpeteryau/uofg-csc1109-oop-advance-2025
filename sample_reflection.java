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

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Custom annotation for sensitive transactions
@Retention(RetentionPolicy.RUNTIME)
@interface SensitiveTransaction {}

class BankAccount {
    public void deposit(double amount) {
        System.out.println("Deposited: $" + amount);
    }

    @SensitiveTransaction
    public void withdraw(double amount) {
        System.out.println("Withdrew: $" + amount);
    }
}

public class ReflectionFinancialDemo {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount();
        
        // Process and check for sensitive transactions
        for (Method method : BankAccount.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(SensitiveTransaction.class)) {
                System.out.println("Logging sensitive transaction: " + method.getName());
            }
        }

        account.deposit(500);
        account.withdraw(300); // This should be logged as a sensitive transaction
    }
}
