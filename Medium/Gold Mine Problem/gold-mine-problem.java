//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int goldMine[][])
     {
        int rows = goldMine.length;
        int cols = goldMine[0].length;

        // Create a table to store intermediate results
        int[][] dp = new int[rows][cols];

        // Initialize the last column of the dp table
        for (int i = 0; i < rows; i++) {
            dp[i][cols - 1] = goldMine[i][cols - 1];
        }

        // Iterate over each column from right to left
        for (int j = cols - 2; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                // Consider three possible moves: diagonal up, right, diagonal down
                int moveUp = (i > 0) ? dp[i - 1][j + 1] : 0;
                int moveRight = dp[i][j + 1];
                int moveDown = (i < rows - 1) ? dp[i + 1][j + 1] : 0;

                // Update the current cell with the maximum amount of gold
                dp[i][j] = goldMine[i][j] + Math.max(moveUp, Math.max(moveRight, moveDown));
            }
        }

        // Find the maximum amount of gold in the first column
        int maxGold = dp[0][0];
        for (int i = 1; i < rows; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;

    }
}