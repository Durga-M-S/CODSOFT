import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: Rs/- %.2f\n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: Rs/-");
        double amount = readDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: Rs/-");
        double amount = readDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }

    // Helper method to safely read an integer input
    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. \nPlease enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    // Helper method to safely read a double input
    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. \nPlease enter a valid number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
