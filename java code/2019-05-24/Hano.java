public class Hano {
	static void HanioTest(int x, char a, char b, char c) {
		if(x == 1) {
			System.out.println(x + "从" + a + "移动到" + c);
		}else{
			HanioTest(x - 1, a, c, b);
			System.out.println(x + "从" + a + "移动到" + c);
			HanioTest(x - 1, b, a, c);
		}
	}
	
	public static void main(String[] args) {
		HanioTest(6, 'a', 'b', 'c');
	}
}