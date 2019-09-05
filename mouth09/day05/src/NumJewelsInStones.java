import java.util.*;

public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> jSet = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            jSet.add(J.charAt(i));
        }

        for(char c : S.toCharArray()) {
            if(jSet.contains(c))
                count++;
        }
        return count;
    }
}
