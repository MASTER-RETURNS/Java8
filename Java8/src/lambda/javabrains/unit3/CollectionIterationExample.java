package lambda.javabrains.unit3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lambda.javabrains.unit1.exercise.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>(Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Matthew","Arnold",39)));
		
		System.out.println("Using for loop");
		for (int i=0; i<people.size(); i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("Using for-in  loop");
		for (Person p:people) {
			System.out.println(p);
		}
		
		System.out.println("Using forEach method");
		people.forEach(p -> System.out.println(p));
		
		System.out.println("Using forEach method and Method references");
		people.forEach(System.out::println);
	}

}
