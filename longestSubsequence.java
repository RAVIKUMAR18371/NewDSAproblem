package Dynamic_Programming;

public class longestSubsequence {
    // Tabulation Approach
    // yaha pe dp me -1 to hota nahi hai so, hamlog DP kaa ek size badha denge aur dp[0][j] or dp[i][0]--> pe return 0 karwa denge. 
    static int rec(String s1, String s2, int i, int j , int[][] dp){
        if(i == 0 || j == 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
            // match
            return 1 + rec(s1, s2, i-1, j-1, dp);
        }
        // not match
        dp[i][j] = Math.max(rec(s1,s2, i - 1, j, dp), rec(s1, s2, i, j-1, dp));
        return Math.max(rec(s1,s2, i - 1, j, dp), rec(s1, s2, i, j-1, dp));
       
    }
    public static void main(String[] args) {
        String s1 = "HARSH";
        String s2 = "SHARMA";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i=0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j <= n; j++){
            dp[0][j] = 0;
        }
        /**
         * Basically both are same
         */
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i == 0 || j == 0){
        //             dp[i][j] = -1;
        //         }

        //     }
        // }
        System.out.println(rec(s1, s2, s1.length()-1, s2.length()-1 , dp));
        
    }
    
}
