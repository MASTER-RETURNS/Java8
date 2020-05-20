package lambda.javabrains.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambda.javabrains.unit1.exercise.Person;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(
			new Person("Charles","Dickens",60),
			new Person("Lewis","Carroll",42),
			new Person("Thomas","Carlyle",51),
			new Person("Charlotte","Bronte",45),
			new Person("Matthew","Arnold",39)));
	
	System.out.println("Printing all elements in the list - In Java8..................... ");
	printList(people, (p) -> true, (p) -> System.out.println(p));
	/* Using Method reference in Lambda */
	System.out.println("Using Method reference in Lambda");
	printList(people, (p) -> true, System.out::println);
	}
	
	private static void printList(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p: people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

}
