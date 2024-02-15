//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] paths = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    paths[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.isPossible(paths);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int isPossible(int[][] paths) {
        int n = paths.length;

        // Check if the graph is connected
        if (!isConnected(paths, n)) {
            return 0;
        }

        // Check the degree of each vertex
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }

            // If any vertex has an odd degree, return 0
            if (degree % 2 != 0) {
                return 0;
            }
        }

        return 1;
    }

    private boolean isConnected(int[][] paths, int n) {
        boolean[] visited = new boolean[n];
        int count = 0;

        // Find the first non-zero degree vertex and start DFS
        int startVertex = 0;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                degree += paths[i][j];
            }

            if (degree > 0) {
                startVertex = i;
                break;
            }
        }

        // Perform DFS
        dfs(paths, startVertex, visited);
        
        // Check if all vertices are visited
        for (int i = 0; i < n; i++) {
            if (!visited[i] && paths[i][startVertex] > 0) {
                count++;
                dfs(paths, i, visited);
            }
        }

        // If all vertices are visited, return true
        return count == 0;
    }

    private void dfs(int[][] paths, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < paths.length; i++) {
            if (paths[vertex][i] == 1 && !visited[i]) {
                dfs(paths, i, visited);
            }
        }
    }
}
