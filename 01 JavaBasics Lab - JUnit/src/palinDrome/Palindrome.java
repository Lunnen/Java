package palinDrome;

import java.util.Scanner;


class Palindrome {

	//>>>>>> kolla AssertFalse.java
	
	//hanterar inte mellanslag/meningar.
	
  public static void main(String args[])
  {
    String original, reverse = ""; // Objects of String class
    
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter a string to check if it's a palindrome");
    
    original = input.nextLine();
   

    int length = original.length();
    
    for (int i = length -1; i >= 0; i--)
      reverse = reverse + original.charAt(i);
    
    if (original.equals(reverse))
      System.out.println("The string is a palindrome.");
    else
      System.out.println("The string isn't a palindrome.");
    
    input.close();
  }
}