import java.util.*;

public class FindComplement {
    public static int findComplement(int num) {
        List<Integer> list = new ArrayList<>();
        while(num > 0) {
            list.add(num % 2);
            num /= 2;
        }
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1) {
                list.set(i, 0);
            } else {
                list.set(i, 1);
            }
        }
        int result = 0;
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i) * (int)Math.pow(2, i);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findComplement(2));
    }
}
