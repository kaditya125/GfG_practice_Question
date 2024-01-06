//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long sumOfPowers(long a, long b) {
        // code here
        long[] v = new long[(int) (b + 1)];
        Arrays.fill(v, -1);
        v[0] = 0;
        v[1] = 1;
        for (long i = 2; i <= b; i++) {
            if (v[(int) i] == -1) {
                // remained unvisited
                for (long x = i; x <= b; x += i) {
                    v[(int) x] = i;
                }
            }
        }

        long ans = 0;
        for (long i = a; i <= b; i++) {
            long x = i;
            while (x > 1) {
                ans++;
                x = x / v[(int) x];
            }
        }
        return ans;
    }
}
        
