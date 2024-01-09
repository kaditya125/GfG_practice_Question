//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
         int n = txt.length();
        int m = pat.length();
        int len = 0;
        int[] arr = new int[m];
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                arr[i] = len + 1;
                len++;
                i++;
            } else {
                if (len == 0) {
                    arr[i] = 0;
                    i++;
                } else {
                    len = arr[len - 1];
                }
            }
        }

        i = 0;
        int j = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                ans.add(i - j + 1);
                j = arr[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0) {
                    i++;
                } else {
                    j = arr[j - 1];
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;
    }
}