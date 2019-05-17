public class CalcE {
	
	public static long factorial(int n) {
		long count = 1;
		if(n == 0 || n == 1)
			return 1;
		else
			return factorial(n - 1) * n;
	}
	
	public static double calcE(int n) {
		double e = 0;
		for(int i = 0; i < n; i++) {
			e += 1.0 / factorial(i);
		}
		return e;
	}
	
	public static void main (String[] args) {
		int n = 10;
		double e = calcE(n);
		System.out.println("e = " + e);
	}
}