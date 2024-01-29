//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalCount(String num)
    {
          int length = num.length();
        int x = 0;
        for (int i = 0; i < length; i++) {
            x += num.charAt(i) - '0';
        }
 
        // Initialize a 2D table of size (length+1)x(x+1)
        int[][] dp = new int[length + 1][x + 1];
 
        // Base case: set all values in the last row to 1
        for (int s = 0; s <= x; s++) {
            dp[length][s] = 1;
        }
 
        // Fill the table in bottom-up manner
        for (int position = length - 1; position >= 0; position--) {
            for (int previous_sum = 0; previous_sum <= x; previous_sum++) {
                int sum = 0;
                int res = 0;
 
                // Compute the number of sub-strings with sum >=
                // previous_sum
                for (int i = position; i < length; i++) {
                    sum += (num.charAt(i) - '0');
                    if (sum >= previous_sum) {
                        res += dp[i + 1][sum];
                    }
                }
 
                // Store the result in the current position of
                // the table
                dp[position][previous_sum] = res;
            }
        }
 
        // Return the value in the top-left corner of the table
        return dp[0][0];
    }
}
