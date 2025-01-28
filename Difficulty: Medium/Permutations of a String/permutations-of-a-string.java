//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
         Set<String> result = new HashSet<>(); // Use a HashSet to store unique permutations
        boolean[] used = new boolean[s.length()];
        backtrack(s.toCharArray(), used, new StringBuilder(), result);
        return new ArrayList<>(result); // Convert the HashSet to a List before returning
    }

    private static void backtrack(char[] chars, boolean[] used, StringBuilder current, Set<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString()); // Add the permutation to the HashSet
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) { // If the character is not used, proceed
                used[i] = true;
                current.append(chars[i]);
                backtrack(chars, used, current, result);
                current.deleteCharAt(current.length() - 1); // Backtrack
                used[i] = false;
            }
        }
    
    }
}