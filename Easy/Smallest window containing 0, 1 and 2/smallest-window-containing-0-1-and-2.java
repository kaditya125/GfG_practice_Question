//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
         int[] count = new int[3]; // Count of 0, 1, 2 in the current window
        int n = S.length();
        int left = 0; // Left pointer of the window
        int minLength = Integer.MAX_VALUE;
        int foundChars = 0; // Count of unique characters found in the window

        for (int right = 0; right < n; right++) {
            char currentChar = S.charAt(right);
            count[currentChar - '0']++;

            if (count[currentChar - '0'] == 1) {
                foundChars++;
            }

            // Try to minimize the window size by moving the left pointer
            while (foundChars == 3) {
                minLength = Math.min(minLength, right - left + 1);

                char leftChar = S.charAt(left);
                count[leftChar - '0']--;

                if (count[leftChar - '0'] == 0) {
                    foundChars--;
                }

                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
};
