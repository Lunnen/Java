import java.util.Scanner;

public class AskPass {
	
	public static void main(String[] args) {
	
	
	Scanner inputPass = new Scanner(System.in); //Input strings for the account process
	Scanner inputUser = new Scanner(System.in);
	
	System.out.println("Creating your account\nPick your Password:");
	String Pass = inputPass.next();
	
	System.out.println("Pick your account ID:");
	String User = inputUser.next();
	
	for (int counter = 0; counter < 3; counter++) { //gives the user three tries to enter credentials.
	
	System.out.println("Login screen\nEnter account ID:");
	String GivenUser = inputUser.next(); //ID according to what's entered by the user.

	System.out.println("Enter your password:");
	String GivenPass = inputPass.next(); //Password according to what's entered by user.
	
	if (GivenUser.equals(User) && GivenPass.equals(Pass)) { //Checks that the right ID and Password is entered.
		System.out.println("\nYour credentials are accepted!");
		break; 
		
	} else if (counter == 1){ //After the second invalid try, it informs the user.
		System.out.println("\nWrong ID or password! \nThis is your last attempt!");
	} else { 
		System.out.println("\nWrong ID or password!");
	}
	
	}
	System.out.println("Program terminated."); //When the loop-function is done, the program exits.
	System.exit(0);
	
	}	

}
