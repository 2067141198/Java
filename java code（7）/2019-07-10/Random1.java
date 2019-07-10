import java.util.Random;

public class Random1 {
	public static void main(String[] args) {
		Random r = new Random();
		
		int num = r.nextInt();
		System.out.println("随机生成的数字是：" + num);
	}
}