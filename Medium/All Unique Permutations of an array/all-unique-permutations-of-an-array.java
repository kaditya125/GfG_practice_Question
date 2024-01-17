//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(arr);
        // Use a set to store unique permutations
        HashSet<ArrayList<Integer>> uniqueSet = new HashSet<>();

        generatePermutations(arr, 0, uniqueSet);

        // Convert set to list and sort the result
        result.addAll(uniqueSet);
        Collections.sort(result, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });

        return result;
    }

    private static void generatePermutations(ArrayList<Integer> arr, int start, HashSet<ArrayList<Integer>> uniqueSet) {
        if (start == arr.size() - 1) {
            // If the current permutation is complete, add it to the set
            uniqueSet.add(new ArrayList<>(arr));
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            // Swap elements to create different permutations
            Collections.swap(arr, start, i);
            // Recursively generate permutations for the remaining elements
            generatePermutations(arr, start + 1, uniqueSet);
            // Backtrack to the previous state by swapping back
            Collections.swap(arr, start, i);
        }
    }
}