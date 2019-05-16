public class Factorial {
	public static long factorial(int n) {
		if(n == 0 || n == 1)
			return 1;
		else
			return factorial(n - 1) * n;
	}
	
	public static void main(String[] args) {
		int i = 6;
		long n = factorial(i);
		System.out.println(i + "的阶乘是：" + n);
	}
}