public class Main{
	public static void learnStringAdd(){
	int a = 3;
	int b = 4;
	
	System.out.println("a + b的结果是" + a + b);
	System.out.println("a + b的结果是" + (a + b));
	}
	
	
	public static void learnRange(){
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
	}
	
	
	public static void main(String[] args){
	learnStringAdd();
	learnRange();
	}
}