import java.util.Scanner;

/*
*题目：输入三个int数字，然后求出其中的最大值
*/

/*
*思路：
*1.需要键盘输入就需要用到Scanner
*2.Scanner使用的三个步骤，导包、创建、使用
*3.需要的是三个数字，就需要使用三次nextInt()方法
*4.得到三个数字后，将三个数字进行大小比较，选出最大的那个值
*	4.1先比较得到前两个值中的最大值
*	4.2然后再拿前两个中的最大值和第三个数字比较得到最终的最大值
*5.将结果打印出来
*/

public class ScannerMax {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入第一个数字：");
		int a = sc.nextInt();
		System.out.println("请输入第二个数字：");
		int b = sc.nextInt();
		System.out.println("请输入第三个数字：");
		int c = sc.nextInt();
		
		int max = a > b ? a : b;
		max = max > c ? max : c;
		
		System.out.println("最大的数是：" + max);
		
	}
}