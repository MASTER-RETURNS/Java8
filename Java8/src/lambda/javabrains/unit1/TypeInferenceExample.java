package lambda.javabrains.unit1;

public class TypeInferenceExample {

	public static void main(String[] args) {
		StringLengthLambda lambda = s -> s.length();
		System.out.println(lambda.getLength("Hello"));
		
		printLambda(s -> s.length());
	}

	private static void printLambda(StringLengthLambda lambda) {
		System.out.println(lambda.getLength("Hello World!"));
	}

}

interface StringLengthLambda {
	int getLength(String s);
}