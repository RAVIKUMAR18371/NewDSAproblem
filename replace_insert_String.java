package Dynamic_Programming;

public class replace_insert_String {
    static int calls = 0;

    static int rec(int i, int j, String str1, String str2, int[][] memo) {
        calls++;
        
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            return memo[i][j] = rec(i - 1, j - 1, str1, str2, memo);
        }

        int replace = 1 + rec(i - 1, j - 1, str1, str2, memo);
        int insertion = 1 + rec(i, j - 1, str1, str2, memo);
        int deletion = 1 + rec(i - 1, j, str1, str2, memo);

       memo[i][j] = Math.min(replace, Math.min(insertion, deletion));
        return Math.min(replace, Math.min(insertion, deletion));
    }

    public static void main(String[] args) {
        String str1 = "Sunday";
        String str2 = "Saturday";

        int m = str1.length();
        int n = str2.length();

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(rec(m - 1, n - 1, str1, str2, memo));
        System.out.println(calls);
    }

}
