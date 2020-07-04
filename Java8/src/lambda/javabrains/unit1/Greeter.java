package lambda.javabrains.unit1;

public class Greeter {

	public void greet() {
		System.out.println("Hello World!");
	}
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		//greeter.greet();
		/* Passing behaviour before Java8 */
		Greeting obj = new HelloWorldGreeting();
		greeter.greet(obj);
		
		/* Passing behaviour in Java8 */ 
		System.out.println("Passing behaviour in Java8 ");
		/*Greeting myLambda = () -> System.out.println("Hello World! " + this);
		greeter.greet(myLambda);*/
		greeter.callLambda();
		
		MyAdd addFunction = (int a, int b) -> a + b;
		System.out.println(addFunction.add(2, 2));
		
		/* Checking about the instance, inner class is an instance of interface, lambda is not */
		Greeting innerClassGreeting = new Greeting() {

			@Override
			public void perform() {
				System.out.println("Hello World! " + this);
			}
			
			public String toString() {
				return "Inside inner class";
				
			}
			
		};
		
		innerClassGreeting.perform();
	}

	private void callLambda() {
		Greeting myLambda = () -> System.out.println("Hello World! " + this);
		greet(myLambda);
	}
	
	public String toString() {
		return "Inside Greeter class";
		
	}

}

interface MyAdd {
	int add(int a, int b);
}