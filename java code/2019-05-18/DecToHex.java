public class DecToHex {

	public static String reverse(String s) {
		String e = "";
		int length = s.length();
		for(int i = length - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			e += ch;
		}
		return e;
	}
	
	public static String decToHex(int dec) {
		String hex = "";
		while(dec >= 16) {
			int remainder = dec %16;
			dec /= 16;
			if(remainder < 10) {
				hex += remainder;
			}
			else{
				char ch = (char)('A' + (remainder - 10));
				hex += ch;
			}
		}
		if(dec != 0)
			hex += dec;
		return reverse(hex);
	}
	
	public static void main(String[] arghex) {
		System.out.println(decToHex(21954));
	}
}