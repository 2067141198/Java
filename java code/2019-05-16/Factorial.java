public class Factorial {
	public static long factorial(int n) {
		if(n == 0 || n == 1)
			return 1;
		else
			return factorial(n - 1) * n;
	}
	
	public static long factorial2(int n) {
		int count = 1;
		if(n == 0)
			return 1;
		for(int i = 1; i <= n; i++) {
			count *= i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int i = 6;
		long n = factorial(i);
		System.out.println(i + " 的阶乘是：" + n);
		long n2 = factorial2(i);
		System.out.println(i + " 的阶乘是：" + n2);
	}
}