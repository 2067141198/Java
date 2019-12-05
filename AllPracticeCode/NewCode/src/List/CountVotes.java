package List;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountVotes {
    private static Map<String, Integer> map = new HashMap<>();

    private static int AddCandidate(String pCandidateName) {
        if (map.containsKey(pCandidateName))
            return 0;
        else {
            map.put(pCandidateName, 0);
            return 1;
        }
    }

    private static void Vote(String pCandidateName) {
        if (map.containsKey(pCandidateName)) {
            int count = map.get(pCandidateName);
            map.put(pCandidateName, count + 1);
        }
    }

    private static int getVoteResult(String pCandidateName) {
        return map.get(pCandidateName);
    }

    public static void Clear() {
        map.clear();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n1 = Integer.parseInt(sc.nextLine());
            String[] str1 = sc.nextLine().split(" ");
            int n2 = Integer.parseInt(sc.nextLine());
            String[] str2 = sc.nextLine().split(" ");

            for (String s : str1) {
                AddCandidate(s);
            }

            for (String s : str2) {
                Vote(s);
            }

            int sum = 0;
            for (String s : str1) {
                int m = getVoteResult(s);
                sum += m;
                System.out.println(s.charAt(0) + " : " + m);
            }
            System.out.println("Invalid : " + (str2.length - sum));
        }
    }
}

