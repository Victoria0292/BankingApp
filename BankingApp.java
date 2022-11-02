import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

	}
}

class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;

	// If amount is not equal to 0 we will add the balance and amount deposited
	void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}

	// If amount is not equal to 0 we will subtract the balance and amount withdrawn
	void withdraw(int amount) {
		if (amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}

	//Prints one of three things depending on previousTransaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			//Math.abs returns the absolute value of an int
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured");
		}
	}

	void showMenu() {

	}

}
