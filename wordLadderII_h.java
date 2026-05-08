import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;

        // Map to store parents for backtracking: child -> list of parents
        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        boolean found = false;
        int minLevel = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = distance.get(word);
            
            if (level >= minLevel) break;

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String next = new String(chars);
                    
                    if (distance.containsKey(next) && level + 1 == distance.get(next)) {
                        parents.get(next).add(word);
                    } else if (dict.contains(next)) {
                        dict.remove(next); // Standard BFS pruning
                        // Re-add because other nodes at the same level might need it
                        // but don't add to queue twice
                        queue.offer(next);
                        distance.put(next, level + 1);
                        parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                        
                        if (next.equals(endWord)) {
                            found = true;
                            minLevel = level + 1;
                        }
                    }
                }
                chars[i] = old;
            }
            // Optimization: Only remove from dict AFTER the level is processed 
            // for "all paths" logic, but standard BFS with distance map is often safer.
        }

        if (found) {
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, parents, path, res);
        }
        
        return res;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> parents, Deque<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        if (parents.containsKey(word)) {
            for (String parent : parents.get(word)) {
                path.addFirst(parent);
                backtrack(parent, beginWord, parents, path, res);
                path.removeFirst();
            }
        }
    }
}
