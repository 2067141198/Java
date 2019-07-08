import java.util.Scanner;
/*
*键盘输入两个 int 数字，并求出其和
*/

/*
*思路
*1.既然需要键盘输入，那么就需要用单Scanner
*2.Scanner的三个步骤：导包、创建、使用
*3.需要的是两个数字，所以需要调用两次nextInt方法
*4.得到两个数字后，需要将两个数字加起来
*5.将结果打印输出
*/

public class ScannerSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println ("请输入第一个数字：");
		int a = sc.nextInt();
		System.out.println ("请输入第二个数字：");
		int b = sc.nextInt();
		
		int result = a + b;
		System.out.println("结果是：" + result);
	}
}