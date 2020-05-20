package lambda.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		int key = 2;
		
		System.out.println("Before Java8.............................");
		pocess(array, key);
		
		System.out.println("In Java8.............................");
		processByLambda(array, key, (v, k) -> System.out.println(v + k));
		
		key = 0;
		System.out.println("Division for Exception In Java8.............................");
		processByLambda(array, key, wrapperLambda((v, k) -> System.out.println(v / k)));
	}

	private static void pocess(int[] array, int key) {
		for (int i: array) {
			System.out.println(i + key);
		}
	}
	
	private static void processByLambda(int[] array, int key, BiConsumer<Integer, Integer> biConsumer) {
		for (int i: array) {
			biConsumer.accept(i, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		return (v, k) -> {
			try {
				biConsumer.accept(v, k);
			} catch (ArithmeticException e) {
				System.out.println("Exception caught in wrapper lambda" + e.getMessage());
			}
		};
		
	}

}
