import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//        System.out.println(wordAbbreviation("internationalization", "i12iz4n"));
//        System.out.println(wordAbbreviation("apple", "a2e"));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);

        if (!wordSet.contains(endWord)) return ladders;

        Map<String, Integer> distances = new HashMap<>();
        for (String word : wordSet) distances.put(word, Integer.MAX_VALUE);
        bfs(endWord, wordSet, distances);

        if (!distances.containsKey(beginWord)) return ladders;

        int minLadderLength = distances.get(beginWord);

        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);

        dfs(beginWord, wordSet, distances, new HashSet<>(), ladder, minLadderLength, ladders);

        return ladders;
    }

    private static void bfs(String endWord, Set<String> wordSet, Map<String, Integer> distances) {
        Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
        String word = endWord;
        int ladderLength = 1;

        queue.add(new MutablePair<>(word, ladderLength));
        distances.put(word, ladderLength);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                Pair<String, Integer> pair = queue.poll();

                word = pair.getKey();
                ladderLength = pair.getValue();

                for (String neighbor : getNeighbors(word, wordSet)) {
                    if (ladderLength + 1 < distances.get(neighbor)) {
                        queue.add(new MutablePair<>(neighbor, ladderLength + 1));
                        distances.put(neighbor, ladderLength + 1);
                    }
                }
            }
        }
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            char originalC = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);

                if (newWord.equals(word)) continue;
                if (!wordSet.contains(newWord)) continue;

                neighbors.add(newWord);
            }

            chars[i] = originalC;
        }

        return neighbors;
    }

    private static void dfs(String word, Set<String> wordSet,
                            Map<String, Integer> distances, Set<String> visited, List<String> ladder,
                            int length, List<List<String>> ladders) {
        if (distances.get(word) == 1) {
            ladders.add(new ArrayList<>(ladder));
            return;
        }

        for (String neighbor : getNeighbors(word, wordSet)) {
            if (visited.contains(neighbor)) continue;
            if (length < ladder.size() + distances.get(neighbor)) continue;

            visited.add(neighbor);
            ladder.add(neighbor);

            dfs(neighbor, wordSet, distances, visited, ladder, length, ladders);

            visited.remove(neighbor);
            ladder.remove(ladder.size() - 1);
        }
    }
}
