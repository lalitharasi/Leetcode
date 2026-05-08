import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char letter = board[r][c];
        TrieNode child = node.children[letter - 'a'];

        if (child == null) return;

        if (child.word != null) {
            res.add(child.word);
            child.word = null; // Optimization: avoid duplicates
        }

        board[r][c] = '#'; // Mark as visited

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length 
                && board[nr][nc] != '#') {
                dfs(board, nr, nc, child, res);
            }
        }

        board[r][c] = letter; // Backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
            curr.word = w;
        }
        return root;
    }
}
