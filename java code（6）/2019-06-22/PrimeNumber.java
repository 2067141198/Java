public class PrimeNumber {
	public static void print(int number) {
		for(int i = 2; i <= number; i++) {
			boolean flag = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 100;
		System.out.println("打印" + n + "以内的所有质数：");
		PrimeNumber.print(n);
	}
}