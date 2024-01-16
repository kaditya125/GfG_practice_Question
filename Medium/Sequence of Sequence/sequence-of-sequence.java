//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int m = Integer.parseInt(input_line[0]);
            int n = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.numberSequence(m, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numberSequence(int m, int n) {
        int MOD = 1000000007;
        
        // dp[i][j] represents the number of special sequences of length j ending with the number i
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1; // There is only one sequence of length 1 for each number i
        }

        // Calculate the number of special sequences
        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                for (int k = i * 2; k <= m; k++) {
                    dp[k][j] = (dp[k][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        // Sum up the number of special sequences for the last element
        int result = 0;
        for (int i = 1; i <= m; i++) {
            result = (result + dp[i][n]) % MOD;
        }

        return result;
    }
}
