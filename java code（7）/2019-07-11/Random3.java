import java.util.Random;
import java.util.Scanner;

/*
*题目要求：
*根据 int 变量 n 的值，来获取随机数字，范围是[1,n)，可以去取到1也可以取到n。
*
*思路：
*1.定义一个变量n
*2.要使用Random就是那三个步骤
*3.如果写10，那么就是0~9，然而想要的是1~10，可以发现，整体加1即可 
*4.打印随机数字
*/

public class Random3 {
	public static void main(String[] args) {
		
		System.out.println("输入你想生成随机数的最大值：");
		//使用Scanner类，利用键盘输入随机数的生成范围
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Random r = new Random();
		
		for(int i = 0; i < 100; i++) {
			//本来随机生成的范围是[0,n),加1后就变成了[1,n+1),也就是[1,n]
			int result = r.nextInt(n) + 1;
			System.out.println(result);
		}
	}
}