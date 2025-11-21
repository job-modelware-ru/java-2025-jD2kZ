package proj;

public class Calculator {

	public static enum Numbers {
		zero, one, two, three, four, five, six, seven, eight, nine
	}
	public int add(int a, int b) {
		return a+b;
	}
	
	public int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Деление на ноль невозможно");
		}
		return a/b;
	}
	
	public int square(int a) {
		return a*a;
	}
	
}

