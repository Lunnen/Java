package palinDrome;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.EnableJUnit4MigrationSupport;

// @ExtenWith(IgnoreCondition.class)
@EnableJUnit4MigrationSupport
class IgnoredTestsDemo {
	
	@Ignore
	@Test
	void testWillBeIgnored() {
		
	}
	@Test
	void testWillBeExecuted() {
		
	}
	
}
