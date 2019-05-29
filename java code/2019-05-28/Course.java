class B {
	int sum;
	
	B(int a, int b, int c) {
		System.out.println("a + b + c");
		sum = a + b + c;
	}
	
	void print() {
		System.out.println(sum);
	}
}

public class Course {
	
	public static void main(String[] args) {
		B b = new B(10, 20, 30);
		b.print();
	}
}