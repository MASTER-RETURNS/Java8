package lambda.javabrains.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambda.javabrains.unit1.exercise.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)));
		
		/* Print all elements in the list */
		System.out.println("Print all elements in the list \n");
		people.stream().forEach(System.out::println);
		
		/* Print all people that have last name beginning with 'C' */
		System.out.println("Print all people that have last name beginning with 'C' \n");
		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println);
		
		/* Print all people that have first name beginning with 'C' */
		System.out.println("Print all people that have first name beginning with 'C' \n");
		people.stream().filter(p -> p.getFirstName().startsWith("C")).forEach(System.out::println);
		
		/* Count all people that have last name beginning with 'C' */
		System.out.println("Count all people that have last name beginning with 'C'");
		System.out.println(people.stream().filter(p -> p.getLastName().startsWith("C")).count());
		
		/* Count all people that have last name beginning with 'D' */
		System.out.println("\nCount all people that have last name beginning with 'D'");
		System.out.println(people.stream().filter(p -> p.getLastName().startsWith("D")).count());
		
		/* Using Parallel Streams - Print all people that have first name beginning with 'C' */
		System.out.println("\nUsing Parallel Streams - Print all people that have first name beginning with 'C'");
		people.parallelStream().filter(p -> p.getFirstName().startsWith("C")).forEach(System.out::println);
	}

}
