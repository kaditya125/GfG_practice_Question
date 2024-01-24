//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // Check for trivial cases
        if (m != n - 1) {
            return false; // Not a tree if edges are not one less than nodes
        }

        // Create an adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0)); // Undirected graph
        }

        // Perform DFS to check for cycles and connectivity
        boolean[] visited = new boolean[n];
        if (hasCycle(graph, 0, -1, visited)) {
            return false; // Cycle detected
        }

        // Check if all nodes are reachable
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false; // Graph is not connected
            }
        }

        return true; // No cycles and connected, it's a tree
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, node, visited)) {
                    return true;
                }
            } else if (neighbor != parent) { // Back-edge detected
                return true;
            }
        }
        return false;
    }
}
