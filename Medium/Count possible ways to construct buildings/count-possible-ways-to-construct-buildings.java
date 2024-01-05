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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int TotalWays(int N)
    {
        int MOD = 1000000007;

        // Initialize dp arrays for buildings and spaces on both sides of the road
        int[] building = new int[N + 1];
        int[] space = new int[N + 1];

        // Base cases
        building[1] = 1;
        space[1] = 1;

        // Fill the dp arrays for buildings and spaces
        for (int i = 2; i <= N; i++)
        {
            building[i] = (building[i - 1] + space[i - 1]) % MOD;
            space[i] = building[i - 1];
        }

        // Total ways to construct buildings on both sides of the road
        int totalWays = (building[N] + space[N]) % MOD;

        // Return the result
        return (int)((long)totalWays * totalWays % MOD);
    }
}

