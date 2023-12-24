//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

// import java.util.*;

class Solution {
    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int buyMaximumProducts(int n, int K, int[] price) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));

        // Making pair of product cost and number of day and adding to PriorityQueue
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(price[i], i + 1));
        }

        // Calculating the maximum number of stock count.
        int ans = 0;
        while (!pq.isEmpty()) {
            Pair stock = pq.poll();
            ans += Math.min(stock.second, K / stock.first);
            K -= stock.first * Math.min(stock.second, K / stock.first);
        }
        return ans;
    }
}

