//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int splitArray(int[] arr, int N, int K) {
        int low = 0;
        int high = 0;

        for (int i = 0; i < N; i++) {
            high += arr[i];
            low = Math.max(low, arr[i] - 1);
        }

        while (low < high - 1) {
            int mid = low + (high - low) / 2;

            // Using lambda expression for the check function
            // Note: Java does not have the auto keyword, so we need to explicitly define the functional interface.
            CheckFunction check = () -> {
                int cuts = 0;
                int sum = 0;

                for (int i = 0; i < N; i++) {
                    if (sum + arr[i] > mid) {
                        cuts++;
                        sum = arr[i];
                    } else {
                        sum += arr[i];
                    }
                }

                return cuts < K;
            };

            if (check.check())
                high = mid;
            else
                low = mid;
        }

        return high;
    }

    // Functional interface for the check function
    interface CheckFunction {
        boolean check();
    }
}


