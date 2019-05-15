public class Reverse {
	
	public static String reverse(String s) {
		String e = "";
		int length = s.length();
		for(int i = length - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			e = e + ch;
		}
		return e;
	}
	
	public static void main(String[] args) {
		String s = "Hello";
		String e = reverse(s);
		System.out.println(e);
	}
}