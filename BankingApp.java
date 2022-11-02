import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {
		
		BankAccount customerOne = new BankAccount("Ryuko", "R00030");
		customerOne.showMenu();

	}
}

class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	//Constructor
	BankAccount(String cName, String cId) {
		customerName = cName;
		customerId = cId;
	}

	// If amount is not equal to 0 we will add the balance and amount deposited
	void deposit(int amount) {
		if (amount > 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}


	void withdraw(int amount) {
		if (amount < this.balance) {
			this.balance -= amount;
			this.previousTransaction = -amount;
		}
		
		else {
			System.out.println("Funds insufficient, please try another amount.");
			this.balance += 0;
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

	//Option menu for customer to navigate
	void showMenu() {
		char option = '\0';
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome " + customerName);
			System.out.println("Your ID is " + customerId);
			System.out.println("\n");
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Previous Transaction");
			System.out.println("E. Exit");
			
			//do while loop with switch statements. Case will print/run if chosen. 
			do {
				System.out.println("================================================================");
				System.out.println("Enter an option");
				System.out.println("================================================================");
				option = scanner.next().charAt(0);
				System.out.println("\n");
				
				switch(option) {
				case 'A':
					System.out.println("---------------------------");
					System.out.println("Balance = " + balance);
					System.out.println("---------------------------");
					System.out.println("\n");
					break;
					
				case 'B':
					System.out.println("---------------------------");
					System.out.println("Enter an amount to deposit: ");
					System.out.println("---------------------------");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C':
					System.out.println("---------------------------");
					System.out.println("Enter an amount to withdraw: ");
					System.out.println("---------------------------");
					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'D':
					System.out.println("---------------------------");
					getPreviousTransaction();
					System.out.println("---------------------------");
					System.out.println("\n");
					break;
					
				case 'E':
					System.out.println("****************************");
					break;
					
					default:
						System.out.println("Invalid option! Please enter again.");
						break;
				}
			} while(option != 'E');
		}
		
		System.out.println("Thank You for using our services");
	}

}
