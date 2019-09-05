import java.util.Scanner;

public class Replace {
    public static String defangIPaddr(String address, String oldChar) {
        String s = null;
        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                s = address.replace(".", "[.]");
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String newString = defangIPaddr(s, ".");
        System.out.println(newString);
    }
}
