//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean isPossible(int N, int[] coins) {
        int MAX = Arrays.stream(coins).sum() + 1;

        int[][] dp = new int[N + 1][MAX];

        for (int i = 20; i < MAX; i += 20)
            dp[N][i] = 1;
        for (int i = 24; i < MAX; i += 24)
            dp[N][i] = 1;
        if (2024 < MAX)
            dp[N][2024] = 1;

        for (int i = N - 1; i > -1; i--) {
            for (int j = 0; j < MAX; j++) {
                int take, notake;
                take = notake = 0;

                notake = dp[i + 1][j];

                if (coins[i] + j < MAX)
                    take = dp[i + 1][j + coins[i]];

                dp[i][j] = Math.max(take, notake);
            }
        }

        return dp[0][0] == 1;
    }
}

        
