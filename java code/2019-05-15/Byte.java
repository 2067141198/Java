public class Byte {
	public static int printbyte(int n) {
		int count = 0;
		while(n % 10 > 0) {
			n /= 10;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n = 123456789;
		int m = printbyte(n);
		System.out.println(n + " 的位数是：" + m);
	}
}