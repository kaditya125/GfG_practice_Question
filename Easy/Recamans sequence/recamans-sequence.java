//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> recamanSequence(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        result.add(0);
        set.add(0);

        for (int i = 1; i < n; i++) {
            int prev = result.get(i - 1);

            int next = prev - i;
            if (next > 0 && !set.contains(next)) {
                result.add(next);
                set.add(next);
            } else {
                next = prev + i;
                result.add(next);
                set.add(next);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n1 = 5;
        System.out.println(recamanSequence(n1));  // Output: [0, 1, 3, 6, 2]

        int n2 = 3;
        System.out.println(recamanSequence(n2));  // Output: [0, 1, 3]
    }
}