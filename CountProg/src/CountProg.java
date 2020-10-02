import java.util.Scanner;

public class CountProg {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		greet("Enter first number");
		int start = scan.nextInt(); 	//value where it starts
		
		greet("Enter last number");
		int end = scan.nextInt();		//value where it ends printing.
		
		/* Counts up or down depending if the start value 
		 * is bigger or smaller than the end value. */ 
		
		if (start <= end) {
			countManyTimesUp(start, end); //sends start and end value to method.
		} else
			countManyTimesDown(start, end);
		
	}
	public static void greet(String name) {
		
		System.out.println(name);
	}
	
	/* Prints all numbers from the bottom (start) to the top (end)
	 * Done with a while-loop */
	
	public static void countManyTimesUp(int start, int end) { 
		
		int i = start;
		while (i <= end) { 
			System.out.println(i);
			i++;
		}
		
	}	
	
	/* Prints all numbers from the top (start)) to the bottom (end)
	 * Done with a for-loop */
	
	public static void countManyTimesDown(int start, int end) {
		for(int i = start; i >= end; i--) {
			System.out.println(i);
		}

	}
	
	
	
}

