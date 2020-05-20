package lambda.javabrains.unit1.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lambda.javabrains.unit1.exercise.Person;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)));
		
		/* Step 1: Sort list by last name */
		// Before Java8
		/*Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareToIgnoreCase(p2.getLastName());
			}
			
		});
		System.out.println("Sorted by last name - Before Java8..................... \n" + people);
		*/
		// In Java8
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));
		System.out.println("Sorted by last name - In Java8..................... \n" + people);
		
		/* Step 2: Create a method that prints all elements in the list */
		// Before Java8
		/*System.out.println("Printing all elements in the list - Before Java8..................... ");
		printAll(people);*/
		// In Java8
		System.out.println("Printing all elements in the list - In Java8..................... ");
		printConditionallyLambda(people, (p) -> true);
		printList(people, (p) -> true, (p) -> System.out.println(p));
		
		/* Step 3: Create a method that prints all people that have last name beginning with 'C' */
		// Before Java8
		/*System.out.println("Printing all people that have last name beginning with 'C' - Before Java8..................... ");
		printConditionally(people);*/
		// In Java8
		System.out.println("Printing all people that have last name beginning with 'C' - In Java8..................... ");
		printConditionallyLambda(people, (p) -> p.getLastName().startsWith("C"));
		printList(people, (p) -> p.getLastName().startsWith("C"), (p) -> System.out.println(p));
		
		/* first name beginning with 'C' */
		System.out.println("Printing all people that have first name beginning with 'C' - In Java8..................... ");
		printConditionallyLambda(people, (p) -> p.getFirstName().startsWith("C"));
		printList(people, (p) -> p.getFirstName().startsWith("C"), (p) -> System.out.println(p.getFirstName()));
		
	}

	private static void printAll(List<Person> people) {
		for (Person p: people) {
			System.out.println(p);
		}
	}
	
	private static void printConditionally(List<Person> people) {
		for (Person p: people) {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}
	
	private static void printConditionallyLambda(List<Person> people, Predicate<Person> predicate) {
		for (Person p: people) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	private static void printList(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p: people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

}
