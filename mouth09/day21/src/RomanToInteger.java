import java.util.*;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] c = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < c.length; i++) {
            char c1 = c[i];
            if(i < c.length - 1) {
                char next = c[i + 1];
                if(c1 == 'C') {
                    if(next == 'D') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    } if(next == 'M') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    }
                }
                if(c1 == 'X') {
                    if(next == 'L') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    } if(next == 'C') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    }
                }
                if(c1 == 'I') {
                    if(next == 'X') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    }  if(next == 'V') {
                        sum += map.get(next) - map.get(c1);
                        i++;
                        continue;
                    }
                }
            }
            int n = map.get(c1);
            sum += n;
        }
        return sum;
    }
}
