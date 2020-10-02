package palinDrome;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestforTests {

		// assertEquals
	
	@Test
	public void addition() {
		System.out.println(" adding test");
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1));
	}
	@Test
	public void additionButFails() {
		System.out.println(" adding failing test");
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(2, 1));
	}
	
	// New Tests:
	
	@Test
	public void assertArrayEqualsTestThatsNotRight() {

		System.out.println(" assertArrayEqualsTest That's NOT OK!"); 
		
		int[] expected = {1, 2, 3};
		int[] actually = {1, 3, 2};
		
		assertArrayEquals(expected, actually);
		
	}
	@Test
	public void assertArrayEqualsTestThatsIsRight() {

		System.out.println(" assertArrayEqualsTest that's OK "); 
		
		int[] expected = {1, 2, 3};
		int[] actually = {1,2,3};
		
		assertArrayEquals(expected, actually);
		
	}
	
	
}

/* Labb steg 3:
Annotation är en anteckning gällande koden.
Läggs till för att underlätta läsbarhet av koden.

@Test innebär att funktionen ska testas enligt JUnit 
medans @Ignore innebär att den ska hoppa över denna del.

Assertion är en samling verktyg som testar att funktioner vi gjort
beter sig på rätt sätt och inte skriver ut fel eller 
agerar på ett sätt funktionen inte är gjord för.

assertEquals är en funktion som förväntar sig att
det första värdet som kommer in är sant och jämför det med nästkommande
värde som kommer, och ger ett sant/falskt värde beroende
på om det är samma. Den förväntar sig att de ska vara lika.

*/