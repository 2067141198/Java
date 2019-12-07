package BFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) {
            wordSet.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> book = new HashSet<>();
        book.add(beginWord);

        int minLen = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                for (int j = 0; j < curWord.length(); j++) {
                    char[] tmpWord = curWord.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        tmpWord[j] = k;
                        String newWord = new String(tmpWord);
                        if (book.contains(newWord) || !wordSet.contains(newWord)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            return minLen + 1;
                        }

                        queue.add(newWord);
                        book.add(newWord);
                    }
                }
            }
            minLen++;
        }
        return 0;
    }
}
