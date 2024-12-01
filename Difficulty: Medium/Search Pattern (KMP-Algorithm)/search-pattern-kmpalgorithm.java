//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public ArrayList<Integer> search(String pat, String txt) {
       ArrayList<Integer> result = new ArrayList<>();
        
        int n = txt.length();
        int m = pat.length();
        
        // Edge case: If pattern is longer than the text, no match is possible
        if (m > n) {
            return result;
        }
        
        // Step 1: Compute the LPS (Longest Prefix Suffix) array for the pattern
        int[] lps = new int[m];
        int length = 0;
        int i = 1;
        
        // Preprocess the pattern to fill the LPS array
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Step 2: Search the text using the LPS array to skip unnecessary comparisons
        int j = 0; // Index for pat[]
        i = 0; // Index for txt[]
        
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            
            if (j == m) {
                result.add(i - j); // Match found, add the starting index
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return result;
    }
}
