public class PrintNumBreak {
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			prt(i);
			if(i == 47)
				break;
		}
	}
	static void prt(int i) {
		System.out.print(i + " ");
	}
}