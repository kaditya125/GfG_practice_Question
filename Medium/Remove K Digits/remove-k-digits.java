//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
            int len = S.length();
        //corner case
        if(K==len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<S.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(K>0 && !stack.isEmpty() && stack.peek()>S.charAt(i)){
                stack.pop();
                K--;
            }
            stack.push(S.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(K>0){
            stack.pop();
            K--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}