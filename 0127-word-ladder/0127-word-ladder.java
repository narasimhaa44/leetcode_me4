import java.util.*;

class Pair {
    String word;
    int steps;

    public Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;  // End word must be in the word list
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordChars[i] = ch;
                    String newWord = new String(wordChars);

                    if (wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        queue.add(new Pair(newWord, steps + 1));
                    }
                }
            }
        }

        return 0;  // No valid transformation
    }
}
