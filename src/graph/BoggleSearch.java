package graph;

public class BoggleSearch {
    static int count;
    static String ans = "";

    public static void main(String[] args) {
        String[] words = {"abc", "bcd", "adg", "abdc"};
        char[][] matrix = {
                {'a', 'b'},
                {'c', 'd'}
        };
        boggleDfs(matrix, words, matrix.length, matrix[0].length);
        System.out.println(count);
    }

    public static void boggleDfs(char[][] matrix, String[] words, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                findWords(matrix, words, visited, m, n, i, j);
            }
        }
    }

    private static void findWords(char[][] matrix, String[] words, boolean[][] visited, int m, int n, int i, int j) {
        visited[i][j] = true;
        ans = ans + matrix[i][j];

        if (isValidWord(words)) {
            count++;
        }

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int a = 0; a < 8; a++) {
            int r = i + row[a];
            int c = j + col[a];

            if (r >= 0 && c >= 0 && r < m && c < n && !visited[r][c]) {
                findWords(matrix, words, visited, m, n, r, c);
            }
        }

        ans = ans.substring(0, ans.length() - 1);
        visited[i][j] = false;
    }

    private static boolean isValidWord(String[] words) {
        for (String word : words) {
            if (ans.equalsIgnoreCase(word))
                return true;
        }
        return false;
    }
}
