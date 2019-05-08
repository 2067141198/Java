public class Compare{
	public static void main(String[] args){
		int a = 0;
		int b = 0;
		int c = 0;
		if(a < b){
			if(a > c){
				System.out.print("b" + b + " " + "a" + a + " " + "c" + c);
			}else{
				System.out.print("b" + b + " " + "c" + c + " " + "a" + a);
			}
		}else{
			if(b < c){
				System.out.print("a" + a + " " + "c" + c + " " + "b" + b);
			}else{
				System.out.print("a" + a + " " + "b" + b + " " + "c" + c);
			}
		}
		Compare com = new Compare();
	}
}