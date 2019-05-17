public class CalcPi {
	
	public static double calcPi(int n) {
		int m = 0;
		double e = 0;
		for(int i = 0; i < n; i++) {
			m = 2 * i + 1;
			if(i % 2 == 0)
				e += 1.0 / m;
			else
				e -= 1.0 / m;
		}
		return 4 * e;
	}
	
	public static double calcPi2(int n) {
		int m = 0;
		double e = 0;
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0)
				m = 2 * n + 1;
			else
				m = -(2 * n + 1);
			e += 1 / m;
		}
		return 4 * e;
	}
	
	public static void main(String[] args) {
		int n = 100000000;
		double Pi = calcPi(n);
		System.out.println(Pi);
		double Pi2 = calcPi(n);
		System.out.println(Pi2);
	}
	
}