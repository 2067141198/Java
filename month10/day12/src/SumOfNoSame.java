import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfNoSame {
    public static Set<String> set = new HashSet<>();
    public static void addInSet(String[] str) {
        for(int i = 0; i < str.length; i++) {
            set.add(str[i]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            String string = s.nextLine();
            String[] str = string.split(" ");
            addInSet(str);
        }
        System.out.println(set.size());
    }
}
