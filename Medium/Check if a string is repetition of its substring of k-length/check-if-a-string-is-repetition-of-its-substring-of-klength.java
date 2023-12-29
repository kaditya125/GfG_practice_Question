//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        if(n%k!=0) return 0;
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0; i<n; i=i+k){
            String sub = s.substring(i,i+k);
            hm.put(sub,hm.getOrDefault(sub,0)+1);
        }
        
        int x = hm.size();
        if(x==1) return 1;
        if(x==2) for(Integer val : hm.values()) if(val==1) return 1;
        return 0;// Your Code Here   
        
    }
}