package gameHangman;

import java.util.Scanner;

/**
 * 
 * @author Andreas "Lunnen" Lönnholm. EC utbildning Ronneby 2020.
 * 
 * This is a version of Hangman.
 * You have 7 lives and can either try the word by picking a letter or the entire word.
 * 
 * This main function is only the menu, which has its methods in gameFunctions, 
 * which gets the word from hiddenWord.
 */

public class gameHangman {

    public static Scanner scanner = new Scanner(System.in);
   	
    public static void main(String[] args) {
    	
       	String answer = "";
       	boolean gameOn = true;
    	
    	while (gameOn) {
    	
        gameFunctions.resetGameValues();
        println("\n------------------\nWelcome to Hangman!\nCapital cities of the world edition\n");
       	
       while (gameFunctions.checkResult(answer)) {
    	   
    	   	println("Pick a choice: ");
            println("1. Guess char");
            println("2. Guess word");
            println("q to quit\n");
            
            String menu = scanner.nextLine();

            if (menu.equals("q")) {
            	
                	println("\nProgram terminated.");
                	gameOn = false;
                	break;
                
            } else if (menu.equals("1")) {
            	
                    println("\nEnter a Letter: (a-z)");
                    answer = scanner.nextLine().toLowerCase();
                    gameFunctions.checkLetterInput(answer);

            } else if (menu.equals("2")) { 
                	
                    println("\nEnter word: (a-z)");
                    answer = scanner.nextLine().toLowerCase();
                    gameFunctions.checkWordInput(answer);
                
       		} else {
                println("\n>> Invalid choice! Pick again! <<\n");
                continue;
       			}
        	}
        }
    	
    	}

    	public static void println(String input) {
    	
		System.out.println(input);
    	}


} 