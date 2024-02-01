//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
     boolean[] isPresent = new boolean[26];

    // Iterate through the string and mark the occurrence of each letter.
    for (int i = 0; i < s.length(); i++) {
        char ch = Character.toLowerCase(s.charAt(i));

        // Check if the character is an alphabet letter (a-z).
        if ('a' <= ch && ch <= 'z') {
            isPresent[ch - 'a'] = true;
        }
    }

    // Check if all letters are present in the array.
    for (boolean present : isPresent) {
        if (!present) {
            return false;
        }
    }

    return true;
}
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends