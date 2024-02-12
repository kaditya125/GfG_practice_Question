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
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long sequence(int n) {
        final int MOD = 1000000007;
        long result = 0;
        long p=1;

        for (int i = 1, count = 1; i <= n; i++, count++) {
            long val = 1;

            for (int j = 0; j < count; j++) {
                val = (val * (p++)) % MOD;
            }

            result = (result + val) % MOD;
        }

        return result;
    }
}
