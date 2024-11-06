import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn " + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class ATM {
    private BankAccount account;
    private static final Logger logger = Logger.getLogger(ATM.class.getName());

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performAction(int choice, double amount) {
        switch (choice) {
            case 1:
                account.withdraw(amount);
                logger.log(Level.INFO, "Withdrawal of amount: " + amount);
                break;
            case 2:
                account.deposit(amount);
                logger.log(Level.INFO, "Deposit of amount: " + amount);
                break;
            case 3:
                System.out.println("Current balance: " + account.getBalance());
                logger.log(Level.INFO, "Checked balance: " + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                logger.log(Level.INFO, "User exited the ATM");
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                logger.log(Level.WARNING, "Invalid menu choice");
                break;
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); 
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);
        boolean continueUsingATM = true;

        System.out.println("Welcome to the ATM System!");

        while (continueUsingATM) {
            atm.displayMenu();
            int choice = 0;
            boolean validChoice = false;

            while (!validChoice) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    validChoice = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
            }

            if (choice == 4) {
                atm.performAction(choice, 0);
                continueUsingATM = false;
            } else {
                double amount = 0;
                boolean validAmount = false;

                while (!validAmount) {
                    try {
                        System.out.print("Enter amount: ");
                        amount = scanner.nextDouble();
                        validAmount = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        scanner.next(); // Clear the invalid input
                    }
                }

                atm.performAction(choice, amount);
            }
        }

        scanner.close();
    }
}

