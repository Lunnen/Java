package palinDrome;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
 
public class AssertFalse {
 
	AssertFalse att;
 
    public boolean isPalindrome(String str)
	{
		for (int i = 0,j=str.length()-1; i <str.length()/2; i++,j--) {
 
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
 
		}
		return true;
	}
 
	@BeforeEach
	public void beforeEachTest()
	{
		att = new AssertFalse();
	}
 
	@Test
	public void palindormeTestwithCondition(){
		Assertions.assertFalse(att.isPalindrome("ADAM"));
	}
 
	// assertFalse(boolean condition, String message)
	@Test
	public void palindormeTestwithConditionAndMessage(){
		Assertions.assertFalse(att.isPalindrome("MADAM"),"String is palindrome");
	}
 
	// assertFalse(BooleanSupplier booleanSupplier)
	@Test
	public void palindormeTestWithBooleanSupplier(){
		Assertions.assertFalse(() -> att.isPalindrome("ASDAS"));
	}
 
	// 	assertFalse(boolean condition, Supplier<String> messageSupplier)
	@Test
	public void palindormeTestWithConditionAndSupplier(){
		Assertions.assertFalse(att.isPalindrome("LEVEL"),() -> "String is palindrome");
	}
 
	// assertFalse(BooleanSupplier booleanSupplier, String message)
	@Test
	public void palindormeTestWithBooleanSupplierAndMessage(){
		Assertions.assertFalse(() -> att.isPalindrome("PLAN"),"String is palindrome");
	}
 
	// assertFalse(BooleanSupplier booleanSupplier, Supplier<String> messageSupplier)
	@Test
	public void palindormeTestWithBooleanSupplierAndSupplier(){
		Assertions.assertFalse(() -> att.isPalindrome("RADAR"),() -> "String is palindrome");
	}
}