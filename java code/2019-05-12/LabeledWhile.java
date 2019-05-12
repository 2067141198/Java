public class LabeledWhile {
	public static void main(String[] args) {
		int i = 0;
		outer:
		while(true){
			prt("outer while loop");
			while(true){
				i++;
				prt("i = " + i);
				if(i == 1){
					prt("continue");
					continue;
				}
				if(i == 3){
					prt("break");
					break;
				}
				if(i == 5){
					prt("contine outer");
					continue outer;
				}
				if(i == 7){
					prt("break outer");
					break outer;
				}
			}
		}
	}
	static void prt(String s) {
		System.out.println(s);
	}
}