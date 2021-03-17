package gameHangman;

public class gameFunctions {
	
    static int lives = 7;
    private static String theWord = ""; 
    
    
    public static void println(String input) {
    	
    		System.out.println(input);
    }
	    public static void printWrongCharChosen() {
    	
	    	println("\nLetters a-z only! CAPITAL/common letters are treated the same way.");
    }
    
    public static void showWordLengthToUser(){
    		
    		System.out.print("\nWord to guess -> ");
    	
        	for(String x: hiddenWord.arr){
            System.out.print(x);
        	}  	
        	
    }
    public static void resetGameValues() {
    		lives = 7;
    		theWord = hiddenWord.getTheWord();
    }
    public static void showVictory() {
    	
    		println("\n************************");		
    		println("Victory! You've won!");
    		println("************************\n");
        
    }
    public static void showLoss() {
    	
    		println("\n------------------");
    		println("\n ____");
    		println(" |  |");
    		println(" |  O");
    		println(" | /|\\");
    		println(" | /\\");        	
    		println(" |");
    		println("/|\\\n");
    		println("Game over! You've been hanged.");
    		println("The correct word was: " +theWord);
        
    }
    
   /*
	 * This method checks if the user has gotten the correct result.
	 * Depending on the situation, it shows current lives, victory or loss.
	 */
    
	public static boolean checkResult(String answer){ 
		
	        String checkLetters = "";
	        
	        //Checks the intermedium if all * are gone and the word is correct.
	        for(String x: hiddenWord.arr){
	            checkLetters = checkLetters + x;
	            
	        }
	        
	        if(checkLetters.equals(theWord) || answer.equals(theWord)){
	        	
	        	showVictory();
	            
	            return false;
	            
	        } else if ( lives == 6 ) {
	        	
	    		println("\n------------------");
	    		println("\n");
	    		println("");
	    		println("");
	    		println("");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");
	        	 
	        } else if ( lives == 5 ) {
	        	
	    		println("\n------------------");
	    		println("\n");
	    		println(" |");
	    		println(" |");
	    		println(" |");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");
	    		
	        } else if ( lives == 4 ) {
	        	
	    		println("\n------------------");
	    		println("\n ____");
	    		println(" |  |");
	    		println(" |");
	    		println(" |");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");
	    		
	        } else if ( lives == 3 ) {
	        	
	    		println("\n------------------");
	    		println("\n ____");
	    		println(" |  |");
	    		println(" |  O");
	    		println(" |");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");
	    		
	        } else if ( lives == 2 ) {
	        	
	    		println("\n------------------");
	    		println("\n ____");
	    		println(" |  |");
	    		println(" |  O");
	    		println(" |  |");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");
	    		
	        } else if ( lives == 1 ) {
	        	
	    		println("\n------------------");
	    		println("\n ____");
	    		println(" |  |");
	    		println(" |  O");
	    		println(" | /|\\");
	    		println(" |");        	
	    		println(" |");
	    		println("/|\\\n");	 
	    		
	        } else if(lives == 0){
	        	
	        	showLoss();
	            return false;
	            
	        }   else { //at 7 lives we want nothing to be shown.
	        	
	        } 
	        	showWordLengthToUser();
	        	println(" You have " + lives + " lives.\n");
	        	
	        return true;

	    }
	public static void checkLetterInput(String answer) {
		
    	if ( ! answer.matches(".*[a-z].*") ) {
    		
            gameFunctions.printWrongCharChosen(); //  Prints that the user has typed the wrong input.
            
        } else {

        char letter = answer.charAt(0);

        if(hiddenWord.arr.contains(answer)){
        	
            println("This letter's already been shown.");

        } else {

        		/* Checks if the letter corresponds to any char in theWord. 
        		 * If so, it removes the *** and puts the letter at that spot instead.
        		 */
            for (int i = 0; i < theWord.length(); i++) {
                if (theWord.charAt(i) == letter) {
                    hiddenWord.arr.remove(i);
                    hiddenWord.arr.add(i, answer);
                    
                    println("That's right. Letter unmasked.");

                }
            }
            	if(!hiddenWord.arr.contains(answer)){
            		println("Too bad! Not a correct guess.");
            		lives--;
            	}
		
        	}
        }  
        
		}
	
	 public static void checkWordInput(String answer) {
		
    	if ( ! answer.matches(".*[a-z].*") ) {
    		
            gameFunctions.printWrongCharChosen(); //  Prints that the user has typed the wrong input.
            
        	}	else if (!answer.equals(theWord)) {
        		lives--;
        	} 	
		
	 	} 
}
