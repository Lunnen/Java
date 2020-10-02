package gameHangman;

import java.util.ArrayList;
import java.util.Random;

public class hiddenWord {
	
	private static String theWord = ""; 
	
	public static ArrayList <String> arr = new ArrayList<>(); //used as an intermedium for checking purposes.
	
    private static String randomWordFromList() {
        
        Random random = new Random();
    	
    	String [] words = {"oslo", "stockholm", "berlin", "helsinki", 
				 "copenhagen", "london", "paris", "madrid", 
				 "rome", "vienna", "amsterdam", "moskva", 
				 "tokyo", "beijing", "seoul", "ankara",
				 "tehran", "baku", "minsk", "kiev", "prague",
				 "tallinn", "bratislava", "budapest", "zagreb",
				 "belgrade", "sarajevo", "bucharest", "sofia", 
				 "lisbon", "tblisi", "jerevan", "dublin",
				 "reykjavik", "brussels", "bern", "tirana",
				 "brasilia", "santiago", "quito", "lima", 
				 "montevideo", "caracas", "ottawa", "havana",
				 "warsaw", "edinburgh", "cardiff", "belfast",
				 "athens", "nicosia", "cairo", "tripoli", 
				 "alger", "rabat", "damascus", "baghdad", "beirut", 
				 "riyadh", "muscat", "sanaa", "doha", "manama", 
				 "islamabad", "delhi", "katmandu", "dhaka", "taipei" }; 
    
    	int index = random.nextInt(words.length); //randomizer
    		theWord += words[index];
    		
    		arr.clear();
    		
    		 //create the length of the word in an array-list and asterisk (*).
    		for(int i = 0; i<theWord.length(); i++){
    			arr.add("*");
    		}
    		
    		return theWord;
    }
    public static String getTheWord() {
    	
    	randomWordFromList();
    	
		return theWord;
	}

}
