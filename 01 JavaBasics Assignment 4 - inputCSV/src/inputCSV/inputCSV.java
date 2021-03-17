package inputCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
 * Lesson 4 - Parsing. 
 * EC Utbildning 2020 i Ronneby.
 * reading from sample.csv.
 */

public class inputCSV {
	
	public static String COMMA_DELIMITER = ",";
	static int checkValue = 0;
	
	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>(); 
		try (Scanner scanner = new Scanner(new File("sample.csv"));) {
			while (scanner.hasNextLine()) {
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		checkValue = checkForAorAndroidDevs(records, 1);
		println("----------------\nNumber of A/a's in the name list of column 2-3 is: " + checkValue);
		
		checkValue = checkForAorAndroidDevs(records, 2);
		println("----------------\nNumber of Android App developers in the list: " + checkValue);

		println("----------------\nIdentical timestamps found here: ");
		checkTimeStamps(records); 	
		
	}
	
	private static List<String> getRecordFromLine(String line) { //Get columns from file
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
			
		}	
		return values;
	}
	public static void println(String text) { //basic print method
		System.out.println(text);
	}
	
	/* This method counts the amount of A's in column 2-3 
	 * or checks for Android app developers in column 6 depending on int sent to it. 
	 */
	public static int checkForAorAndroidDevs(List<List<String>> list, int option) {
		
		int counter = 0;
		
		if (option == 1) {
			
		list.remove(0); //Do not count the title itself, which contains the letter.
		
		for(List<String> line: list) {	
			for(int x = 1; x < 3; x++) {
				if(line.get(x).toLowerCase().contains("a")) {	
				counter++;
				}
			}
			}
		} else {
			
		for(List<String> line: list) {
		if (line.get(6).contains("Android App") ) {
			counter += 2; 
			}
		}
		}
		
		return counter;
		
	}
	 /* Fills an array with data from 'list' (originally the records array).
	  * Then compares it to every other position in the other (identical) array.
	  * Duplicates are printed and shown to the user.
	 */
	public static void checkTimeStamps(List<List<String>> list) {
		
		List<Integer> dupesTime = new ArrayList<>();	
		
		for (int i = 0; i < list.size(); i++) {
			
			List<String> first = list.get(i); 
			
			for (List<String> second : list) {
				
				if (second.get(0).equals(first.get(0)) && !(first.equals(second)) ) { 
					//if first and second values are the same, and they are not at the same position. 
					//if so, add to duplicate array, which in turn shows what the duplicates are to user.
					
					dupesTime.add(i);
				} 
				} 
			}	
		for(int x: dupesTime) {
			System.out.println(list.get(x));
		}
		
	}	

} 
