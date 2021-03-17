/*
 * Rock, paper, scissors.

 * Week 35. EC Utbildning, Ronneby.
 * 
 * This is a rock, paper, scissors game where you play rounds 
 * against the computer until you type 'quit'.
 * 
 * Players have the option to change 
 * the word they write for rock, paper or scissors to anything they'd like.
 * They may also type a number.
 * 
 */

package gameRPS;

import java.util.Scanner;
import java.util.Random;

public class gameRPS {

	static Scanner scan = new Scanner(System.in); //used by playVsAI and letPlayerPickVariables.
	static Boolean playMode = false; //To force user to pick mode.
	
	static String r = "rock"; //defines typed 'rock' into r inside array.
	static String p = "paper";
	static String s = "scissors";
	
	public static void main(String[] args) {
		
	Scanner scanInt = new Scanner(System.in); //need this separate scanner, otherwise Null-value to other functions.
	
		while (! playMode) { //this menu runs until starts the game.
			
		println("\nWelcome to Rock, Paper, Scissors");
		println("Pick an option: \n");
		println("1. Player vs AI");
		println("2. Pick your own game variables\n\n");
		
		int playOption =  scanInt.nextInt(); //Choosing game mode at start
			
			if (playOption==1) {
				playVsAI();
				playMode=true; //stops menu options from looping. Runs game.
				scanInt.close(); //closes scanner function. No longer needed.
				
			} else if (playOption==2) {
				letPlayerPickVariables();
				
			} else {
				println(">> Wrong option! <<");
			}	
		} 
		
	} //end of main
		
	public static void println(String text) { //Method for shorter print command.
		
		System.out.println(text);
	} 
	
	public static void playVsAI() { //Game play method
	
	Boolean quit = false; 

	String quitInput = "quit"; //if you type quit, the program ends.
	String valueP1; // Input values from players
	String valueAI;

	int scoreP1 = 0; //The Score board :)
	int scoreAI = 0; 
		
		while (! quit) { 
			
		println("\n----------------------------");
		println("Player vs AI mode");
		println("\nCurrent score is:\nPlayer: " + scoreP1 + "\t AI: " +scoreAI);
		println("\nType your move: (1." + r + " 2." + p + " or 3." + s + ". 'Quit' to end)"); //Shows player options. Adjusts to player given names.
		
		valueP1 =  scan.nextLine().toLowerCase(); //input value from player 1. The functions needs lowerCase to function, so it enforces it.
	
		switch(valueP1) { //checks if player entered value is a number. If not, it continues.
		
		case "1": valueP1 = r; //if the user type '1', assign it as if 'rock' was typed.
		break;
		case "2": valueP1 = p;
		break;
		case "3": valueP1 = s;
		break;
		}
		
		valueAI = randomAiHand(); //Collects the value of the random AI hand from method.
		
		
		if (valueP1.equals(quitInput)) { //if user types quit, this happens.
			
			println("\n----------------------------");
			println("\nFinishing score is:\nPlayer: " + scoreP1 + "\t AI: " +scoreAI);
			println("Program terminated!");
			
			System.exit(0);	
			
		} else if (valueP1.equals(valueAI) ) { //compares game variables and gives a result.
			println("\n>> It's a TIE! <<");	
		} else if (valueP1.equals(r) && valueAI.equals(p)) {  
			println("\n>> AI wins! <<");
			scoreAI++;
		} else if (valueP1.equals(r) && valueAI.equals(s)) {
			println("\n>> P1 wins! <<");
			scoreP1++;
		} else if (valueP1.equals(p) && valueAI.equals(r)) {
			println("\n>> P1 wins! <<");
			scoreP1++;
		} else if (valueP1.equals(p) && valueAI.equals(s)) {
			println("\n>> AI wins! <<");
			scoreAI++;
		} else if (valueP1.equals(s) && valueAI.equals(r)) {
			println("\n>> AI wins! <<");
			scoreAI++;
		} else if (valueP1.equals(s) && valueAI.equals(p)) {
			println("\n>> P1 wins! <<");
			scoreP1++;
		} else {
			println("\n>> Wrong option. <<\n");
		} 
		
		println("P1 chose: " + valueP1);
		println("AI chose: " + valueAI); 
		
		}
		
	} //end of play vs AI
	
	public static void letPlayerPickVariables() { //lets player change game play variable names.
		
		println("\nPick a name for the rock:");
		r = scan.nextLine().toLowerCase();
		
		println("\nPick a name for paper:");
		p = scan.nextLine().toLowerCase();
		
		println("\nPick a name for the scissors:");
		s = scan.nextLine().toLowerCase();
		
	}
	static String randomAiHand() { //randomizer for the hand of the AI/computer.
		
		Random random = new Random(); //Random function, needed by AI.
		int randomNr;  //needed by AI random mode
		String[] options = {r, p, s}; //options to choose from. 
		String aiHand = "";
		
		randomNr = random.nextInt (3); //Computer chooses it's options from the array.
		aiHand = options[randomNr]; 
		
		return aiHand;
	}


} //end of class

