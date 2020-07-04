package lambda.javabrains.unit1;

public class RunnableExample {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Printed inside Runnable");
			}
			
		});
		t.start();
		Thread myLambdaThread = new Thread(() -> System.out.println("Printed inside lambda Runnable"));
		myLambdaThread.start();
	}

}
