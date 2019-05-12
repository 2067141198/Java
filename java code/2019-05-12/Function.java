public class Function {
	//定义方法f使输入一个int类型值后判断其范围输出一个新的int类型值
	static int f(int x) {
		if(x > 0) 
			return x + 3;
		else if(x == 0)
			return 0;
		else
			return x * x - 1;
	}
	public static void main(String[] args) {
		System.out.println(f(-5));
		System.out.println(f(0));
		System.out.println(f(5));
	}
}