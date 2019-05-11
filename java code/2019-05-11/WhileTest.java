public class WhileTest{
	public static void main(String[] args){
		double r = 0;
		while(r < 0.99d){
			//Math库里的static(静态）方法random()的作用的产生一个0-1之间的double值（包括0但不包括1）
			r = Math.random();
			System.out.println(r);
		}
	}
}