//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            // The mergeOverlap function now returns a List<int[]>
            List<int[]> ans = obj.mergeOverlap(arr);

            // Printing the merged arr
            for (int[] interval : ans) {
                System.out.print(interval[0] + " " + interval[1] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        // Step 1: Sort intervals by their start time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // Step 2: Use a list to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Add the first interval
        merged.add(arr[0]);

        // Step 3: Merge overlapping intervals
        for (int i = 1; i < arr.length; i++) {
            // Get the last merged interval
            int[] last = merged.get(merged.size() - 1);

            // Check if the current interval overlaps with the last merged interval
            if (arr[i][0] <= last[1]) {
                // Merge intervals by updating the end time
                last[1] = Math.max(last[1], arr[i][1]);
            } else {
                // Add the current interval as it does not overlap
                merged.add(arr[i]);
            }
        }

        // Return the merged intervals as a list
        return merged;
    
    }
}