package proj;


import java.time.Month;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class calculatorTest {

	@Before
	private void setup() {
		System.out.println("setup");
	}
	
	@After
	private void done() {
		System.out.println("done");
	}
	
	@Ignore
	@Test

	public void testAdd() {
		Calculator calculator = new Calculator();
		int a = 2;
		int b = 2;
		
		int result = calculator.add(a, b);
		
		assertEquals(4,result);
	}
	
	@Ignore
	@Test
	private void asserts() {
		assertEquals(1,1);
		assertTrue(1==1);
		assertNotNull(1);
	}
	
	@Ignore
	@Test
	void testDivide() {
		Calculator calculator = new Calculator();
		int a = 2;
		int b = 2;
		
		int result = calculator.divide(a, b);
		
		assertEquals(1,result);
	}
	
	@Ignore
	@Test
	void testDivideException() {
		Calculator calculator = new Calculator();
		int a = 2;
		int b = 0;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {calculator.divide(a, b);
		});
		
		assertEquals("Деление на ноль невозможно", exception.getMessage());
	}
	
	@Ignore
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 4, 10})
	public void testSquare(int a) {
		Calculator calculator = new Calculator();

		assertNotNull(calculator.square(a));
	}
	
	@Ignore
	@ParameterizedTest
	@CsvSource({
		"1, 1, 2", 
		"100, 1, 101",
		"-5, 5, 0"
	})
	
	public void testAdd(int a, int b, int result) {
		Calculator calculator = new Calculator();

		assertEquals(result, calculator.add(a, b));
	}
	
	@Ignore
	@ParameterizedTest
	@EnumSource(Month.class)
	void testMonthValueBetween1and12(Month month) {
	    int monthNumber = month.getValue();
	    assertTrue(monthNumber >= 1 && monthNumber <= 12);
	}
	
	static Stream<Arguments> numbersForAddition() {
		return Stream.of(
				Arguments.of(1,1,2),
				Arguments.of(2,3,5),
				Arguments.of(-1,-1,-2),
				Arguments.of(-10,1,-9)
				);
				
	}
	
	@Ignore
	@ParameterizedTest
	@MethodSource("numbersForAddition")
	public void testAdd2(int a, int b, int result) {
		Calculator calculator = new Calculator();

		assertEquals(result, calculator.add(a, b));
	}
	
	
	@Ignore
	@ParameterizedTest
	@ArgumentsSource(CustomArgumentsProvider.class)
	public void testAdd3(int a, int b, int result) {
		Calculator calculator = new Calculator();

		assertEquals(result, calculator.add(a, b));
	}
	
}

